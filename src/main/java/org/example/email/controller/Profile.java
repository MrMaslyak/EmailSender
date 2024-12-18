package org.example.email.controller;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.example.email.system.Util.AESUtil;
import org.example.email.system.EmailSender;
import org.example.email.system.Util.FileUtil;
import org.example.email.system.StageManager;

public class Profile {
    public Button sender, save;
    public TextField email, password;
    public Circle validator;

    public void initialize() {

    }

    public void sender() {
        StageManager.switchScene(sender, "/org/example/email/emailSender.fxml");
    }

    public void save() throws Exception {
        try {
            String emailText = email.getText();
            String passwordText = password.getText();
            String encryptedPassword = AESUtil.encrypt(passwordText);
            String validatorEmail = EmailSender.isValidEmailAddress(emailText);

            if (validatorEmail.equals("Invalid email address")) {
                validator.setFill(Color.RED);
                return;
            }
            FileUtil.savePassword(validatorEmail, encryptedPassword);
            System.out.println("Данные успешно сохранены!");
            validator.setFill(Color.GREEN);
            StageManager.switchScene(sender, "/org/example/email/emailSender.fxml");
        }catch (Exception e){
            System.out.println("Ошибка при сохранении данных: " + e.getMessage());
        }
    }


}
