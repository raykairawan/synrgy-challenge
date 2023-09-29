module com.challenge1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.challenge1 to javafx.fxml;
    exports com.challenge1;
}