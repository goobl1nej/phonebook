package ru.phonebook;

import java.util.Date;
import java.util.List;

public class User {

    private long id;
    private String firstname;
    private String lastname;
    private String middlename;
    private Date birthday;
    private String email;
    private String phone;
    private List<Email> emails;
    private List<Phone> phones;

    public User() {
    }

    public User(long id, String firstname, String lastname, String middlename, Date birthday, String email, String phone) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.birthday = birthday;
        this.email= email;
        this.phone= phone;
    }

    public User(String firstname, String lastname, String middlename) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
    }

    public User(long id, String firstname, String lastname, String middlename, Date birthday) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.birthday = birthday;
    }

    public User(long id, String firstname, String lastname, String middlename, Date birthday, List<Email> emails, List<Phone> phones) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.birthday = birthday;
        this.emails= emails;
        this.phones= phones;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "ru.test.User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", birthday='" + birthday + '\'' +
                ", emails=" + emails +
                ", phones=" + phones +
                '}';
    }
}
