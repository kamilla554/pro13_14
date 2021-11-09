module com.example.pro13_14 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pro13_14 to javafx.fxml;
    exports com.example.pro13_14;
}