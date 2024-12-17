package org.example.email.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.email.system.AESUtil;
import org.example.email.system.EmailSender;
import org.example.email.system.FileUtil;
import org.example.email.system.StageManager;

import java.io.IOException;
import java.util.Arrays;

public class HelloController {

    @FXML
    private Button send, profileBtn;
    public TextField title, text,emailTo ;
    public Label validProfile, error;

    public void initialize() throws Exception {
        error.setVisible(false);
        validProfile.setText("Your email: " + FileUtil.readEmail());
        if (FileUtil.readEmail() != null) {
            EmailSender.setUsername(FileUtil.readEmail());
            EmailSender.setPassword(AESUtil.decrypt(FileUtil.readPassword()));
        }
        if (FileUtil.readEmail() == null) {
            validProfile.setText("Your email: not found" );
            error.setVisible(true);
            error.setText("Please, enter your email in Profile");
        }


    }
    @FXML
    protected void onProfileBtnClick() {
        StageManager.switchScene(profileBtn, "/org/example/email/profile.fxml");
    }


    public void sendEmail() throws IOException {
        String titleText = title.getText();
        String textText = text.getText();
        String emailToText = emailTo.getText();
        String email =  EmailSender.isValidEmailAddress(emailToText);
        if (email.equals("Invalid email address")) {
            error.setVisible(true);
            error.setText("Invalid email address");
            return;
        }
        if (titleText.isEmpty() || textText.isEmpty() || email.isEmpty()) {
            System.out.println("Fields cannot be empty");
            error.setVisible(true);
            error.setText("Fields cannot be empty");
            return;
        }
        if (FileUtil.readEmail() == null) {
            System.out.println("Почта не найдена");
            return;
        }
        EmailSender.send(email, titleText, textText);
        text.clear();
        title.clear();
    }

}