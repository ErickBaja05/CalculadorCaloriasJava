module CaloriesCounter {
    requires javafx.controls;
    requires javafx.fxml;

    requires javafx.graphics;
    requires jdk.unsupported.desktop;
    opens caloriesApp;
    opens caloriesApp.controladores;
}