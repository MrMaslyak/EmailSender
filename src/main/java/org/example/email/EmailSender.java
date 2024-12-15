package org.example.email;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailSender {
    public static void main(String[] args) {
        // Настройки SMTP-сервера
        String host = "smtp.gmail.com";
        String port = "587";
        String username = "maslanyjila@gmail.com";
        String password = "npgi gakd nbnv bsiq"; // Используйте App Password для Gmail

        // Параметры письма
        String toEmail = "lala27418182@gmail.com";
        String subject = "Тестовое письмо";
        String message = "Привет! Это сообщение отправлено из Java-приложения.";

        // Настройка свойств
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Создание сессии
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Создание сообщения
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(username));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            msg.setSubject(subject);
            msg.setText(message);

            // Отправка сообщения
            Transport.send(msg);
            System.out.println("Письмо успешно отправлено!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
