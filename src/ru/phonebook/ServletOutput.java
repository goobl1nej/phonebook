package ru.phonebook;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="phonebook", urlPatterns="/phonebook")
public class ServletOutput extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<ru.test.User> userList=ru.test.Crud.loadAll();
////        ru.test.PrintPhonebook.printPhonebook(userList);
//        req.setAttribute("Userlist", userList);
//        getServletContext().getRequestDispatcher("index.jsp").forward(req,resp);
//        resp.setContentType("text/html;charset=utf-8");
//        PrintWriter out = resp.getWriter();
//        out.println("<h1>Телефонный справочник</h1>");
//        if (userList!=null && !userList.isEmpty()) {
//            for (ru.test.User user : userList) {
//
//                out.println(user.getLastname()+" "+user.getFirstname()+" "+user.getMiddlename()+" </br>");
//                out.println(user.getBirthday()+"</br>");
//                user.
//                if (user.getEmails()!=null && !user.getEmails().isEmpty()) {
//                    out.println("Электронная почта:<br/>");
//                    for (ru.test.Email email : user.getEmails()) {
//                        out.println("&nbsp;&nbsp;"+ email.getEmail()+"</br>");
//                    }
//                }
//                if (user.getPhones()!=null && !user.getPhones().isEmpty()) {
//                    out.println("Телефон(ы):<br/>");
//                    for (ru.test.Phone phone : user.getPhones()) {
//                        out.println("&nbsp;&nbsp;"+ phone.getPhone()+"</br>");
//                    }
//                }out.println("----------------------------------------------</br>");
//            }
//        }
    }

}

