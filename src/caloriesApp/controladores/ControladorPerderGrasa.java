package caloriesApp.controladores;

import caloriesApp.ManagerPersona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class ControladorPerderGrasa  {
    @FXML
    private Label tituloPerderGrasa;
    @FXML
    private Label datoCaloriasGrasa;
    @FXML
    private Label datoPeso;
    @FXML
    private Label datoCalorias;
    @FXML
    private AnchorPane resultadosPanePerderGrasa;
    @FXML
    private Pane datosPanePerderGrasa;
    @FXML
    private AnchorPane backPanePerderGrasa;
    @FXML
    private Label proteinaLabel;
    @FXML
    private Label carbohidratosLabel;
    @FXML
    private Label grasasLabel;
    @FXML
    private Label caloriasLabel;
    @FXML
    private Label statusLabel;
    @FXML
    private Button caloriasButton;
    private Stage stage;
    private Alert alerta;

    @FXML
    private void initialize() {
        datoPeso.addEventFilter(ActionEvent.ACTION, this::calcularBtnPerderGrasa);
        datoCalorias.addEventFilter(ActionEvent.ACTION, this::calcularBtnPerderGrasa);
    }


    /* ------------------------ VALIDACIÓN ------------------------ */
    // Cuando se da el evento (click), se verifica si se tienen los datos necesarios para realizar los cálculos
    @FXML
    private void calcularBtnPerderGrasa(ActionEvent event) {
        if (!ManagerPersona.getPersona().isGastoCaloricoLleno()) {
            statusLabel.setText("Por favor, obtenga los valores necesarios en el apartado de \"Gasto Calórico\"");
            statusLabel.setTextFill(Color.ORANGERED);
            datoCalorias.setText("Empty");
            datoPeso.setText("Empty");
        }
        else {
            statusLabel.setText("Todo listo para calcular!");
            statusLabel.setTextFill(Color.GREEN);
            datoCalorias.setText(String.format("%.2f cal",ManagerPersona.getPersona().getGastoCalorico()));
            datoPeso.setText(String.format("%.2f kg",ManagerPersona.getPersona().getPeso()));
            mostrarResultados();
        }
    }


    /* ------------------------- INGESTA CALÓRICA ------------------------- */

    // Se calcula el deficit de calorías a partir de los kg a perder según el peso
    private double calcularDeficit() {
        double peso = ManagerPersona.getPersona().getPeso();
        double deficit = (peso * 3500) / (0.5 * 700);

        // Factor por peso (default = 1 para personas cuyo peso supere los 100 kg)
        double factor = 1.0;
        if (peso > 50 && peso <= 60) factor = 0.5;
        else if (peso > 60 && peso <= 70) factor = 0.65;
        else if (peso > 70 && peso <= 80) factor = 0.75;
        else if (peso > 80 && peso <= 90) factor = 0.85;
        else if (peso > 90 && peso <= 100) factor = 0.95;

        return deficit * factor;
    }

    // se determina la cantidad de calorías a partir del peso
    private void determinarIngestaCalorica() {
        double gastoCal = ManagerPersona.getPersona().getGastoCalorico();
        double ingesaCal = gastoCal - calcularDeficit();
        ManagerPersona.getPersona().setCaloriasPerderGrasa(ingesaCal);
    }

    /* --------------------- MACRO NUTRIENTES --------------------- */
    // Se calcula la cantidad de nutrientes necesaria (2.2 g proteína * kg)
    private double calcularProteinas() {
        double peso = ManagerPersona.getPersona().getPeso();
        double gramosProteina = 2.2 * peso;
        ManagerPersona.getPersona().setGramosProteinaPerderGrasa(gramosProteina);
        return gramosProteina;
    }
    // Se determina la ingesta de grasas
    private void calcularIngestaGrasa(){
        double peso = ManagerPersona.getPersona().getPeso();
        ManagerPersona.getPersona().setGramosGrasaPerderGrasa(peso);
    }

    // Se obtiene la ingesta de carbohidratos a partir de resultados anteriores
    private void calcularIngestaCarbos() {
        double gramosProteina = calcularProteinas();
        double proteinaCalorica = 4 * gramosProteina;
        double grasasCalorica = 9 * ManagerPersona.getPersona().getPeso();
        double gramosCarbos = (ManagerPersona.getPersona().getCaloriasPerderGrasa() - (proteinaCalorica + grasasCalorica)) / 4;
        ManagerPersona.getPersona().setGramosCarbohidratosPerderGrasa(gramosCarbos);
    }

    // Se muestran los resultados en las etiquetas correspondientes
    private void mostrarResultados() {
        determinarIngestaCalorica();
        calcularIngestaGrasa();
        calcularIngestaCarbos();
        calcularProteinas();

        ManagerPersona.getPersona().setPerderGrasaLleno(true); // Confirmación de haber asignado los valores correspondientes

        proteinaLabel.setText(String.format("%.2f g", ManagerPersona.getPersona().getGramosProteinaPerderGrasa()));
        carbohidratosLabel.setText(String.format("%.2f g", ManagerPersona.getPersona().getGramosCarbohidratosPerderGrasa()));
        grasasLabel.setText(String.format("%.2f g", ManagerPersona.getPersona().getGramosGrasaPerderGrasa()));
        caloriasLabel.setText(String.format("%.2f kcal", ManagerPersona.getPersona().getCaloriasPerderGrasa()));
    }
}
