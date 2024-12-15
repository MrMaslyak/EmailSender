package org.example.email;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;

public class StageManager {

    private static FXMLLoader currentLoader;

    public static void switchScene(Button currentButton, String fxmlPath) {
        try {
            currentLoader = new FXMLLoader(StageManager.class.getResource(fxmlPath));
            Parent root = currentLoader.load();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            currentButton.getScene().getWindow().hide();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getController(String s) {
        if (currentLoader != null) {
            return currentLoader.getController();
        }
        return null;
    }
}
