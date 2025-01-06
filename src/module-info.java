module CaloriesCounter {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;
    opens caloriesApp;
    opens caloriesApp.controladores;
}