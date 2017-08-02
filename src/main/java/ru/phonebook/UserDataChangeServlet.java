package ru.phonebook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "edit", urlPatterns = "/edit")
public class UserDataChangeServlet extends HttpServlet {
    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
    protected void viewRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {
        req.setCharacterEncoding("UTF-8");
        if (req.getParameter("OK")!=null) {
            insUser(req);
//            req.getRequestDispatcher("/phonebook?action=all").forward(req, resp);
            resp.sendRedirect("/phonebook?action=all");
        }
        if (req.getParameter("editUser")!=null) {
            if (req.getParameter("userID")!=null && !req.getParameter("userID").isEmpty()) {
                editUser(req);
                Long userID = Long.parseLong(req.getParameter("userID"));
                User user = Crud.loadUserById(userID);
                req.setAttribute("user",user);
                req.getRequestDispatcher("/ViewUser.jsp").forward(req,resp);
            }
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            viewRequest(req, resp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            viewRequest(req, resp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public User setUser (HttpServletRequest req) throws ServletException, IOException, ParseException {
        User User = new User();
        User.setLastname(req.getParameter("lastName"));
        User.setFirstname(req.getParameter("firstName"));
        User.setMiddlename(req.getParameter("middleName"));
        java.util.Date utilDate = sdf.parse(req.getParameter("birthday"));
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        User.setBirthday(sqlDate);
        return User;
    }

    private void editUser(HttpServletRequest req) throws ServletException, IOException, ParseException {
        User editUser = setUser(req);
        Long userID = Long.parseLong(req.getParameter("userID"));
        Crud.updateUser(userID, editUser);
    }

    private void insUser(HttpServletRequest req) throws ServletException, IOException, ParseException {
        User newUser = setAllUser(req);
        Crud.newUser(newUser);
    }

    public User setAllUser(HttpServletRequest req) throws ServletException, IOException, ParseException{
        User User = new User();
        User.setLastname(req.getParameter("lastName"));
        User.setFirstname(req.getParameter("firstName"));
        User.setMiddlename(req.getParameter("middleName"));
        java.util.Date utilDate = sdf.parse(req.getParameter("birthday"));
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        User.setBirthday(sqlDate);
            User.setEmail(req.getParameter("email"));
            User.setPhone(req.getParameter("phone"));
        return User;
    }
}
