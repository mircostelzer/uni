module org.example.soluzione_2019_07_26 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;


    opens org.example.soluzione_2019_07_26 to javafx.fxml;
    exports org.example.soluzione_2019_07_26;
}