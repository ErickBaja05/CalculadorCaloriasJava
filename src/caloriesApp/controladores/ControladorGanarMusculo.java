package caloriesApp.controladores;

import caloriesApp.ManagerPersona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import Alert.Message;
import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorGanarMusculo {

    @FXML
    private Button botonCalcular;

    @FXML
    private Button botonRecuperar;

    @FXML
    private Pane contenedorNivel;

    @FXML
    private ToggleGroup nivelExperiencia;

    @FXML
    private Pane paneCalorias;

    @FXML
    private Pane paneCalorias1;

    @FXML
    private RadioButton rbAvanzado;

    @FXML
    private RadioButton rbIntermedio;

    @FXML
    private RadioButton rbPrincipiante;
    Message msg = new Message();
    double nuevoPeso;

    @FXML
    private Label lbGastoCalorico;
    @FXML
    private Label lbCaloriasSuperavit;
    @FXML
    private Label lbGramosProteina;
    @FXML
    private Label lbGramosGrasa;
    @FXML
    private Label lbGramosCarbos;


    @FXML
    void calcularSuperavit(ActionEvent event) {

        if(rbAvanzado.isSelected()){
            ManagerPersona.getPersona().setNivelExperiencia("Avanzado");
        } else if (rbIntermedio.isSelected()) {
            ManagerPersona.getPersona().setNivelExperiencia("Intermedio");
        }else{
            ManagerPersona.getPersona().setNivelExperiencia("Principiante");
        }
        if(ManagerPersona.getPersona().getNivelExperiencia().equals("Avanzado")){
            nuevoPeso = (ManagerPersona.getPersona().getPeso() * 0.3) / 100;
        } else if (ManagerPersona.getPersona().getNivelExperiencia().equals("Intermedio")) {
            nuevoPeso = (ManagerPersona.getPersona().getPeso() * 0.8) / 100;
        }else{
            nuevoPeso = (ManagerPersona.getPersona().getPeso() * 1.2) / 100;
        }
        double caloriasMensuales = (nuevoPeso * 3500) / 0.5;
        double caloriasDiarias = caloriasMensuales / 30;
        double caloriasSuperavit = ManagerPersona.getPersona().getGastoCalorico() + caloriasDiarias;
        ManagerPersona.getPersona().setCaloriasGanarMusc(caloriasSuperavit);
        double gramosProteina = ManagerPersona.getPersona().getPeso() * 1.8;
        ManagerPersona.getPersona().setGramosProteinaGanarMusc(gramosProteina);
        double caloriasProteina = gramosProteina * 4;
        double gramosGrasas = ManagerPersona.getPersona().getPeso() * 1.3;
        ManagerPersona.getPersona().setGramosGrasaGanarMusc(gramosGrasas);
        double caloriasGrasas = gramosGrasas * 9;
        double caloriasCarbohidratos = caloriasSuperavit - (caloriasProteina + caloriasGrasas);
        double gramosCarbohidratos = caloriasCarbohidratos / 4;
        ManagerPersona.getPersona().setGramosCarbohidratosGanarMusc(gramosCarbohidratos);

        lbCaloriasSuperavit.setText(ManagerPersona.getPersona().valorToString(ManagerPersona.getPersona().getCaloriasGanarMusc()));
        lbGramosCarbos.setText(ManagerPersona.getPersona().valorToString(ManagerPersona.getPersona().getGramosCarbohidratosGanarMusc()));
        lbGramosGrasa.setText(ManagerPersona.getPersona().valorToString(ManagerPersona.getPersona().getGramosGrasaGanarMusc()));
        lbGramosProteina.setText(ManagerPersona.getPersona().valorToString(ManagerPersona.getPersona().getGramosProteinaGanarMusc()));



    }

    @FXML
    void recuperarGastoCalorico(ActionEvent event) {



        if(ManagerPersona.getPersona().getGastoCalorico() == 0.0){
            msg.setMessage("TODAVIA NO CALCULA SU GASTO CALORICO");
        }else{
            lbGastoCalorico.setText(ManagerPersona.getPersona().caloriasToString());
        }

    }

    @FXML
    void initialize(){
        botonCalcular.setDisable(true);
    }

    @FXML

    void experienciaActiva(ActionEvent event) {
        if(ManagerPersona.getPersona().isGastoCaloricoLleno()){
            botonCalcular.setDisable(false);
        }

    }
}

