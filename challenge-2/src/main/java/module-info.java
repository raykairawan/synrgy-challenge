module com.challenge2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens com.challenge2 to javafx.fxml;
    exports com.challenge2;
}