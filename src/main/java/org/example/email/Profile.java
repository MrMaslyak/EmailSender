package org.example.email;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Profile {
    public Button sender, save;


    public void initialize() {

    }

    public void sender() {
        StageManager.switchScene(sender, "/org/example/email/hello-view.fxml");
    }
}
