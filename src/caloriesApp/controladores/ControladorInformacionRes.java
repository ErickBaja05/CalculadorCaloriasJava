package caloriesApp.controladores;

import caloriesApp.ManagerPersona;
import caloriesApp.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.control.Label;

public class ControladorInformacionRes {

    @FXML
    private Button botoninfo;

    @FXML
    private TextArea resumenDatos;

    @FXML
    private Text mensajeError;

    @FXML
    private Label labelActividad;

    @FXML
    private Label labelAltura;

    @FXML
    private Label labelCaloriasGanarMusc;

    @FXML
    private Label labelCaloriasPerderGrasa;

    @FXML
    private Label labelCarbohidratosGanarMusc;

    @FXML
    private Label labelCarbohidratosPerderGrasa;

    @FXML
    private Label labelEdad;

    @FXML
    private Label labelGasto;

    @FXML
    private Label labelGrasaGanarMusc;

    @FXML
    private Label labelGrasaPerderGrasa;

    @FXML
    private Label labelNivelExperiencia;

    @FXML
    private Label labelNombre;

    @FXML
    private Label labelPeso;

    @FXML
    private Label labelProteinaGanarMusc;

    @FXML
    private Label labelProteinaPerderGrasa;

    @FXML
    private Label labelSexo;

    @FXML
    void actualizarLabels() {
        Persona persona = ManagerPersona.getPersona(); // Obtiene la persona desde el Manager

        if (persona != null) {
            labelNombre.setText(persona.getNombre());
            labelEdad.setText(String.valueOf(persona.getEdad()));
            labelPeso.setText(String.valueOf(persona.getPeso()));
            labelAltura.setText(String.valueOf(persona.getAltura()));
            labelSexo.setText(persona.getSexo());
            labelActividad.setText(persona.getActividadFisica());
            labelNivelExperiencia.setText(persona.getNivelExperiencia());
            labelGasto.setText(persona.caloriasToString());
            labelCaloriasGanarMusc.setText(String.valueOf(persona.getCaloriasGanarMusc()));
            labelCaloriasPerderGrasa.setText(String.valueOf(persona.getCaloriasPerderGrasa()));
            labelProteinaGanarMusc.setText(String.valueOf(persona.getGramosProteinaGanarMusc()));
            labelGrasaGanarMusc.setText(String.valueOf(persona.getGramosGrasaGanarMusc()));
            labelCarbohidratosGanarMusc.setText(String.valueOf(persona.getGramosCarbohidratosGanarMusc()));
            labelProteinaPerderGrasa.setText(String.valueOf(persona.getGramosProteinaPerderGrasa()));
            labelGrasaPerderGrasa.setText(String.valueOf(persona.getGramosGrasaPerderGrasa()));
            labelCarbohidratosPerderGrasa.setText(String.valueOf(persona.getGramosCarbohidratosPerderGrasa()));
        } else {
            // Si no se obtiene la persona, establece mensajes predeterminados o de error
            labelNombre.setText("N/A");
            labelEdad.setText("N/A");
            labelPeso.setText("N/A");
            labelAltura.setText("N/A");
            labelSexo.setText("N/A");
            labelActividad.setText("N/A");
            labelNivelExperiencia.setText("N/A");
            labelGasto.setText("N/A");
            labelCaloriasGanarMusc.setText("N/A");
            labelCaloriasPerderGrasa.setText("N/A");
            labelProteinaGanarMusc.setText("N/A");
            labelGrasaGanarMusc.setText("N/A");
            labelCarbohidratosGanarMusc.setText("N/A");
            labelProteinaPerderGrasa.setText("N/A");
            labelGrasaPerderGrasa.setText("N/A");
            labelCarbohidratosPerderGrasa.setText("N/A");
        }
    }

    @FXML
    void eventButton(ActionEvent event) {
        Persona persona = ManagerPersona.getPersona();

        if (persona != null) {
            botoninfo.setText(persona.getNombre());
            actualizarLabels(); // Llamada al método para actualizar las etiquetas
        } else {
            mensajeError.setText("Error al obtener la información de la persona.");
        }
    }

}

