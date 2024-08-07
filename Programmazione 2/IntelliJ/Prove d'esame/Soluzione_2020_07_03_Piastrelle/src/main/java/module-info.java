module org.example.soluzione_2020_07_03 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;


    opens org.example.soluzione_2020_07_03 to javafx.fxml;
    exports org.example.soluzione_2020_07_03;
}