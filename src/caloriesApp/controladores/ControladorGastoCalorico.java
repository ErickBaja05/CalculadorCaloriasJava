package caloriesApp.controladores;

import caloriesApp.App;
import caloriesApp.ManagerPersona;
import caloriesApp.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import Alert.Message;

import java.io.IOException;


public class ControladorGastoCalorico {
    private App aplicacionAsociada;

    public void asociarApp(App app){
        this.aplicacionAsociada = app;
    }
    //Se crea una persona para almacenar todos los datos necesarios para los distintos calculos
    Persona p1 = new Persona();
    //Seccion de Gasto calorico diario

    //Opciones de sexo
    @FXML
    private RadioButton Femenino;

    @FXML
    private RadioButton Masculino;

    //Grupos de seleccion para sexo y actividad fisica
    @FXML
    private ToggleGroup SelAct;

    @FXML
    private ToggleGroup SelSexo;

    @FXML
    private Button calculo;

    //Opciones de actividad física
    @FXML
    private RadioButton intenso;

    @FXML
    private RadioButton ligero;

    @FXML
    private RadioButton moderado;

    @FXML
    private RadioButton sedentario;

    //Campos de datos a llenar
    @FXML
    private TextField textNombre;

    @FXML
    private TextField txtAltura;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtPeso;
    @FXML
    private Text calDiarias;

    @FXML
    private AnchorPane MenuGanarMusculo;
    @FXML
    private AnchorPane MenuPerderGrasa;
    @FXML
    private AnchorPane InformacionResumida;
    @FXML
    void escSexo(ActionEvent event) {

    }

    @FXML
    void escAct(ActionEvent event) {
        if (sedentario.isSelected()) {
            String actividadFisica = "sedentario";
        }

    }

    @FXML
    void eventoCalculo(ActionEvent event) {
        //Mensaje en caso de error
        Message msg = new Message();
        //Al presionar el boton de calculo se generará una persona y se invocará el setter de calorías
        boolean validInput = false;
        try{
            //Configurando el sexo de la persona
            if (Masculino.isSelected()) {
                p1.setSexo("hombre");
            } else if (Femenino.isSelected()) {
                p1.setSexo("mujer");
            }
            //Configurando el nombre peso, altura y edad de la persona
            p1.setNombre(textNombre.getText());
            p1.setPeso(Double.parseDouble(txtPeso.getText()));
            p1.setAltura(Double.parseDouble(txtAltura.getText()));
            p1.setEdad(Integer.parseInt(txtEdad.getText()));

            //Configurando la nivel de actividad física de la persona
            if (sedentario.isSelected()) {
                p1.setActividadFisica("sedentario");
            } else if (ligero.isSelected()) {
                p1.setActividadFisica("ligera");
            } else if (moderado.isSelected()) {
                p1.setActividadFisica("moderada");
            } else if (intenso.isSelected()) {
                p1.setActividadFisica("intensa");
            }
            validInput = true;
        } catch (NumberFormatException e) {
            msg.setMessage("Verifique que haya rellenado todos los datos y que se encuentren en el formato correcto, considere:\n*Utilizar el punto para decimales\n*La altura es unicamente un valor entero\n*Revisar por espacios innecesarios\n*Revisar que las casillas estén seleccionadas ");
        } catch (NullPointerException e) {
            msg.setMessage("Verifique que haya rellenado todos los datos y que se encuentren en el formato correcto, considere:\n *Utilizar el punto para decimales\n*La altura es unicamente un valor entero\n*Revisar por espacios innecesarios\n*Revisar que las casillas estén seleccionadas ");
        }
        if (validInput) {
            p1.setGastoCalorico(p1);
            calDiarias.setText(p1.caloriasToString());
            p1.setGastoCaloricoLleno(true);
            ManagerPersona.setPersona(p1);
        }


    }

    @FXML
    public void initialize() throws IOException {
        try{
            FXMLLoader cargador1 = new FXMLLoader(getClass().getResource("/caloriesApp/fxml/MenuGanarMusculo.fxml"));
            AnchorPane contenidoGanarMusculo = cargador1.load();
            MenuGanarMusculo.getChildren().setAll(contenidoGanarMusculo);

            FXMLLoader cargador2 = new FXMLLoader(getClass().getResource("/caloriesApp/fxml/MenuPerderGrasa.fxml"));
            AnchorPane contenidoPerderGrasa = cargador2.load();
            MenuPerderGrasa.getChildren().setAll(contenidoPerderGrasa);

            FXMLLoader cargador3 = new FXMLLoader(getClass().getResource("/caloriesApp/fxml/InformacionResumida.fxml"));
            AnchorPane contenidoResumen = cargador3.load();
            InformacionResumida.getChildren().setAll(contenidoResumen);
        }catch (Exception e){
            e.printStackTrace();
        }


    }





}


