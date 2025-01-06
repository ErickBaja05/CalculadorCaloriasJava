package caloriesApp.controladores;

import caloriesApp.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorMenuInicio implements Initializable{
    private App aplicacionAsociada;

    public void asociarApp(App app){
        this.aplicacionAsociada = app;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private AnchorPane contenedorPrincipal;


    @FXML
    void comenzarPrograma(ActionEvent event) throws IOException {
        aplicacionAsociada.cambiarPantalla("fxml/MenuGastoCalorico.fxml");
    }

}
