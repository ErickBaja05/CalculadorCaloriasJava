package caloriesApp.controladores;


import caloriesApp.ManagerPersona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControladorInformacionRes {

    @FXML
    private Button botonFranciel;

    @FXML
    void eventButton(ActionEvent event) {
        botonFranciel.setText(ManagerPersona.getPersona().getNombre());
    }

}
