package caloriesApp;
import caloriesApp.controladores.ControladorMenuInicio;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private Stage ventanaActual;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.ventanaActual = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/VentanaDeInicio.fxml"));
        Parent root = fxmlLoader.load();
        ControladorMenuInicio controladorMenuInicio = fxmlLoader.getController();
        controladorMenuInicio.asociarApp(this);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Calories Counter");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void cambiarPantalla(String pantalla) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(pantalla));
        Scene scene = new Scene(root);
        this.ventanaActual.setScene(scene);
    }
}
