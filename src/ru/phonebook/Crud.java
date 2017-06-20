package ru.phonebook;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static ru.phonebook.UserDataChangeServlet.sdf;

public class Crud {

    private Crud(){
    }

    public static List<User> loadAll(){
        List<User> userList=null;
        Connection connectiondb =null;
        PreparedStatement usersPS=null;
        PreparedStatement emailsOfUserPS=null;
        PreparedStatement phonesOfUserPS=null;


        try {
            Class.forName("org.postgresql.Driver");
            connectiondb = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            usersPS=connectiondb.prepareStatement("SELECT * FROM user_");
            emailsOfUserPS=connectiondb.prepareStatement("SELECT * FROM email_ WHERE user_id=?");
            phonesOfUserPS=connectiondb.prepareStatement("SELECT * FROM phone_ WHERE user_id=?");

            ResultSet userset =usersPS.executeQuery();
            if(userset!=null) {
                userList=new ArrayList<User>();
                while (userset.next()) {
                    long id = userset.getLong("user_id");
                    String lastname = userset.getString("lastname");
                    String firstname = userset.getString("firstname");
                    String middlename = userset.getString("middlename");
                    Date birthday = (userset.getDate("birthday"));
                    User user=new User(id,firstname,lastname,middlename, birthday);
                    emailsOfUserPS.setLong(1, user.getId());
                    ResultSet emailsRS=emailsOfUserPS.executeQuery();
                    if(emailsRS!=null) {
                        List<Email> emails=new ArrayList<Email>();
                        while (emailsRS.next()){
                            int emailId=emailsRS.getInt("email_id");
                            String email = emailsRS.getString("email");

                            emails.add(new Email(emailId, email));
                        }
                        user.setEmails(emails);
                    }
                    phonesOfUserPS.setLong(1,user.getId());
                    ResultSet phonesRS=phonesOfUserPS.executeQuery();
                    if(phonesRS!=null) {
                        List<Phone> phones=new ArrayList<Phone>();
                        while (phonesRS.next()) {
                            int phoneId=phonesRS.getInt("phone_id");
                            String phone=phonesRS.getString("phone");
                            phones.add(new Phone(phoneId,phone));
                        }
                        user.setPhones(phones);
                    }
                    userList.add(user);

                }

            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(phonesOfUserPS!=null) try {
                phonesOfUserPS.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(emailsOfUserPS!=null) try {
                emailsOfUserPS.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(usersPS!=null) try {
                usersPS.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(connectiondb!=null) try {
                connectiondb.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return userList;
    }

    public static User loadUserById(Long userID){
        User user = null;
        Connection connectiondb =null;
        PreparedStatement usersPS=null;
        PreparedStatement emailsOfUserPS=null;
        PreparedStatement phonesOfUserPS=null;


        try {
            Class.forName("org.postgresql.Driver");
            connectiondb = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            usersPS=connectiondb.prepareStatement("SELECT * FROM user_ WHERE user_id=?");
            emailsOfUserPS=connectiondb.prepareStatement("SELECT * FROM email_ WHERE user_id=?");
            phonesOfUserPS=connectiondb.prepareStatement("SELECT * FROM phone_ WHERE user_id=?");
            usersPS.setLong(1,userID);
            ResultSet userset =usersPS.executeQuery();
            if(userset!=null) {
                while (userset.next()) {
                    long id = userset.getLong("user_id");
                    String lastname = userset.getString("lastname");
                    String firstname = userset.getString("firstname");
                    String middlename = userset.getString("middlename");
                    java.util.Date birthday = (userset.getDate(("birthday")));
                    user=new User(id,firstname,lastname,middlename, birthday);
                    user.getBirthday().getYear();
                    emailsOfUserPS.setLong(1, user.getId());
                    ResultSet emailsRS=emailsOfUserPS.executeQuery();
                    if(emailsRS!=null) {
                        List<Email>emails=new ArrayList<Email>();
                        while (emailsRS.next()){
                            long emailID=emailsRS.getInt("email_id");
                            String email = emailsRS.getString("email");

                            emails.add(new Email(emailID, email));
                        }
                        user.setEmails(emails);
                    }
                    phonesOfUserPS.setLong(1,user.getId());
                    ResultSet phonesRS=phonesOfUserPS.executeQuery();
                    if(phonesRS!=null) {
                        List<Phone>phones=new ArrayList<Phone>();
                        while (phonesRS.next()) {
                            long phoneID=phonesRS.getInt("phone_id");
                            String phone=phonesRS.getString("phone");
                            phones.add(new Phone(phoneID,phone));
                        }
                        user.setPhones(phones);
                    }
                }
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(phonesOfUserPS!=null) try {
                phonesOfUserPS.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(emailsOfUserPS!=null) try {
                emailsOfUserPS.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(usersPS!=null) try {
                usersPS.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(connectiondb!=null) try {
                connectiondb.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return user;

    }

    public static void newUser(User user){
        Connection connectiondb =null;
        PreparedStatement usersPS=null;
        PreparedStatement emailsOfUserPS=null;
        PreparedStatement phonesOfUserPS=null;


        try {
            Class.forName("org.postgresql.Driver");
            connectiondb = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            usersPS=connectiondb.prepareStatement("INSERT INTO user_"+"(lastname,firstname,middlename,birthday)"+"VALUES (?,?,?,?)");
            emailsOfUserPS=connectiondb.prepareStatement("INSERT INTO email_"+"(user_id,email)"+"VALUES (?,?)");
            phonesOfUserPS=connectiondb.prepareStatement("INSERT INTO phone_"+"(user_id,phone)"+"VALUES (?,?)");
            PreparedStatement usersPSId=connectiondb.prepareStatement("select user_id from user_ order by user_id desc limit 1");
            usersPS.setString(1, user.getLastname());
            usersPS.setString(2, user.getFirstname());
            usersPS.setString(3, user.getMiddlename());
            usersPS.setDate(4, (java.sql.Date) user.getBirthday());
            usersPS.execute();
            ResultSet s = usersPSId.executeQuery();
            if (s!=null && s.next()) {
                long id = s.getLong("user_id");
                if (user.getEmail()!=null && !user.getEmail().isEmpty()) {
                    emailsOfUserPS.setLong(1, id);
                    emailsOfUserPS.setString(2, user.getEmail());
                    emailsOfUserPS.execute();
                }
                if (user.getPhone()!=null && !user.getPhone().isEmpty()) {
                    phonesOfUserPS.setLong(1, id);
                    phonesOfUserPS.setString(2, user.getPhone());
                    phonesOfUserPS.execute();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(phonesOfUserPS!=null) try {
                phonesOfUserPS.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(emailsOfUserPS!=null) try {
                emailsOfUserPS.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(usersPS!=null) try {
                usersPS.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(connectiondb!=null) try {
                connectiondb.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void newEmail(Long userID, String email){
        Connection connectiondb =null;
        PreparedStatement emailsOfUserPS=null;

        try{
            Class.forName("org.postgresql.Driver");
            connectiondb = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            emailsOfUserPS=connectiondb.prepareStatement("INSERT INTO email_ (user_id,email) VALUES (?,?)");
            emailsOfUserPS.setLong(1,userID);
            emailsOfUserPS.setString(2,email);
            emailsOfUserPS.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editEmail(Long emailID, String email) {
        Connection connectiondb = null;
        PreparedStatement emailsPS=null;

        try{
            Class.forName("org.postgresql.Driver");
            connectiondb = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            emailsPS = connectiondb.prepareStatement("UPDATE email_ SET email=? WHERE email_id=?");
            emailsPS.setLong(2,emailID);
            emailsPS.setString(1,email);
            emailsPS.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteEmail(Long emailID) {
        Connection connectiondb = null;
        PreparedStatement emailPS = null;

        try {
            Class.forName("org.postgresql.Driver");
            connectiondb = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            emailPS = connectiondb.prepareStatement("DELETE FROM email_ WHERE email_id=?");
            emailPS.setLong(1, emailID);
            emailPS.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newPhone(Long userID, String phone){
        Connection connectiondb =null;
        PreparedStatement phonesOfUserPS=null;

        try{
            Class.forName("org.postgresql.Driver");
            connectiondb = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            phonesOfUserPS=connectiondb.prepareStatement("INSERT INTO phone_ (user_id,phone) VALUES (?,?)");
            phonesOfUserPS.setLong(1,userID);
            phonesOfUserPS.setString(2,phone);
            phonesOfUserPS.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editPhone(Long phoneID, String phone) {
        Connection connectiondb = null;
        PreparedStatement phonePS=null;

        try{
            Class.forName("org.postgresql.Driver");
            connectiondb = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            phonePS = connectiondb.prepareStatement("UPDATE phone_ SET phone=? WHERE phone_id=?");
            phonePS.setLong(2,phoneID);
            phonePS.setString(1,phone);
            phonePS.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletePhone(Long phoneID) {
        Connection connectiondb = null;
        PreparedStatement phonePS = null;

        try {
            Class.forName("org.postgresql.Driver");
            connectiondb = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            phonePS = connectiondb.prepareStatement("DELETE FROM phone_ WHERE phone_id=?");
            phonePS.setLong(1,phoneID);
            phonePS.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateUser(Long userID, User user){
        Connection connectiondb =null;
        PreparedStatement usersPS=null;

        try {
            Class.forName("org.postgresql.Driver");
            connectiondb = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            usersPS=connectiondb.prepareStatement("UPDATE user_ SET lastname=?,firstname=?,middlename=?,birthday=? WHERE user_id=?");
            usersPS.setString(1,user.getLastname());
            usersPS.setString(2,user.getFirstname());
            usersPS.setString(3,user.getMiddlename());
            usersPS.setDate(4,(java.sql.Date) user.getBirthday());
            usersPS.setLong(5,userID);
            usersPS.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(usersPS!=null) try {
                usersPS.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(connectiondb!=null) try {
                connectiondb.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteUser(Long userID){
        Connection connectiondb =null;
        PreparedStatement usersPS=null;
        PreparedStatement emailsOfUserPS=null;
        PreparedStatement phonesOfUserPS=null;


        try {
            Class.forName("org.postgresql.Driver");
            connectiondb = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            usersPS=connectiondb.prepareStatement("DELETE FROM user_ WHERE user_id=?");
            emailsOfUserPS=connectiondb.prepareStatement("DELETE FROM email_ WHERE user_id=?");
            phonesOfUserPS=connectiondb.prepareStatement("DELETE FROM phone_ WHERE user_id=?");
            emailsOfUserPS.setLong(1,userID);
            emailsOfUserPS.execute();
            phonesOfUserPS.setLong(1,userID);
            phonesOfUserPS.execute();
            usersPS.setLong(1,userID);
            usersPS.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(phonesOfUserPS!=null) try {
                phonesOfUserPS.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(emailsOfUserPS!=null) try {
                emailsOfUserPS.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(usersPS!=null) try {
                usersPS.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(connectiondb!=null) try {
                connectiondb.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

