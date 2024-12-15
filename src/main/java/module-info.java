module org.example.email {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.email to javafx.fxml;
    exports org.example.email;
}