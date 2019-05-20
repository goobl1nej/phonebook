package ru.phonebook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ConfigRead {
    public static String HOST = null;
    public static String PORT = null;
    public static String NAME = null;
    public static String USER = null;
    public static String PASS = null;

    static {

        FileInputStream conf;
        Properties properties = new Properties();

        try {
            conf = new FileInputStream("/Users/vertigo/IdeaProjects/phonebook/src/main/resources/settings.properties");
            properties.load(conf);

            HOST = properties.getProperty("db.host");
            PORT = properties.getProperty("db.port");
            NAME = properties.getProperty("db.name");
            USER = properties.getProperty("db.user");
            PASS = properties.getProperty("db.pass");
        } catch (IOException e) {
            System.err.println("File settings.properties not found");
        }
    }

}
