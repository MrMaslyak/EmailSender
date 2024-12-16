package org.example.email.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import org.example.email.system.StageManager;

public class Profile {
    public Button sender, save;


    public void initialize() {

    }

    public void sender() {
        StageManager.switchScene(sender, "/org/example/email/hello-view.fxml");
    }

    public void save(

    ) {

    }
}
