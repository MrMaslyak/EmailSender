package org.example.email.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.example.email.system.AESUtil;
import org.example.email.system.FileUtil;
import org.example.email.system.StageManager;

public class Profile {
    public Button sender, save;
    public TextField email, password;
    public Circle validator;

    public void initialize() {

    }

    public void sender() {
        StageManager.switchScene(sender, "/org/example/email/hello-view.fxml");
    }

    public void save() throws Exception {
        try {
            String emailText = email.getText();
            String passwordText = password.getText();
            String encryptedPassword = AESUtil.encrypt(passwordText);
            String validatorEmail = isValidEmailAddress(emailText);

            if (validatorEmail.equals("Invalid email address")) {
                validator.setFill(Color.RED);
                return;
            }
            FileUtil.savePassword(validatorEmail, encryptedPassword);
            System.out.println("Данные успешно сохранены!");
            validator.setFill(Color.GREEN);
            StageManager.switchScene(sender, "/org/example/email/hello-view.fxml");
        }catch (Exception e){
            System.out.println("Ошибка при сохранении данных: " + e.getMessage());
        }
    }

    public String isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        if (m.matches()) {
            return email;
        } else {
            return "Invalid email address";
        }
    }
}
