module org.example.email {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.mail;

    opens org.example.email to javafx.fxml;
    exports org.example.email;
    exports org.example.email.system;
    opens org.example.email.system to javafx.fxml;
    exports org.example.email.controller;
    opens org.example.email.controller to javafx.fxml;
}