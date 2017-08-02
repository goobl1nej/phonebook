package ru.phonebook;

public class Email {
    private long id;
    private String email;


    public Email() {
    }

    public Email(long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Email(String email) {
        this.email = email;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ru.test.Email{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}