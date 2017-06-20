package ru.phonebook;

import java.util.List;
public class PrintPhonebook {
    public static void printPhonebook(List<User> users) {
        if (users!=null && !users.isEmpty()) {
            for (User person : users) {
                System.out.println("id: " + person.getId() + "\nФИО: " + person.getFirstname() + " " + person.getLastname() + " " + person.getMiddlename() + "\nДата рождения: " + person.getBirthday().getDate() + "." + person.getBirthday().getMonth() + "." + person.getBirthday().getYear());
                if (person.getEmails() != null && !person.getEmails().isEmpty()) {
                    System.out.println("Эл почта:");
                    for (Email email : person.getEmails()) {
                        System.out.println("\t" + email.getEmail());
                    }
                }
                if (person.getPhones() != null && !person.getEmails().isEmpty()) {
                    System.out.println("Телефоны:");
                    for (Phone phone : person.getPhones()) {
                        System.out.println("\t" + phone.getPhone());
                    }
                }
                System.out.println("\n----------------------------------------------\n");
            }
        } else System.out.println("пользователь не найден");
    }

}
