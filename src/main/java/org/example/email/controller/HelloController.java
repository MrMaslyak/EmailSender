package org.example.email.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.email.system.StageManager;

public class HelloController {
    @FXML
    private Button send, profileBtn;
    public TextField title, text,emailTo ;

    public void initialize() {
    }
    @FXML
    protected void onProfileBtnClick() {
        StageManager.switchScene(profileBtn, "/org/example/email/profile.fxml");
    }


    public void sendEmail() {
        String titleText = title.getText();
        String textText = text.getText();
        String emailToText = emailTo.getText();
        if (titleText.isEmpty() || textText.isEmpty() || emailToText.isEmpty()) {
            System.out.println("Поля не могут быть пустыми");
            return;
        }
    }
}