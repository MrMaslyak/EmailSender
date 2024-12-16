package org.example.email.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.email.system.StageManager;

public class HelloController {
    @FXML
    private Button send, profileBtn;
    public TextField title, text,emailTo ;

    public void initialize() {
        send.setOnAction(event -> {
            String titleText = title.getText();
            String textText = text.getText();
            String emailToText = emailTo.getText();
            System.out.println(titleText);
            System.out.println(textText);
            System.out.println(emailToText);
        });
    }
    @FXML
    protected void onProfileBtnClick() {
        StageManager.switchScene(profileBtn, "/org/example/email/profile.fxml");
    }

}