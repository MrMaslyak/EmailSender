package org.example.email.system.Util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {
    private static final String FILE_PATH = "app_password.properties";


    public static void savePassword(String email, String encryptedPassword) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("email", email);
        properties.setProperty("password", encryptedPassword);

        try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
            properties.store(fos, "User Credentials");
        }
    }


    public static String[] readAll() throws IOException {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
            properties.load(fis);
        }
        String email = properties.getProperty("email");
        String password = properties.getProperty("password");
        return new String[]{email, password};
    }

    public static String readEmail() throws IOException {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
            properties.load(fis);
        }
        String email = properties.getProperty("email");
        return email;
    }

    public static String readPassword() throws IOException {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
            properties.load(fis);
        }
        String password = properties.getProperty("password");
        return password;
    }
}
