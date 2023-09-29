module com.challenge1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens com.challenge1 to javafx.fxml;
    exports com.challenge1;
}