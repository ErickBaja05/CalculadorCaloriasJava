package caloriesApp.controladores;

import caloriesApp.App;
import caloriesApp.ManagerPersona;
import caloriesApp.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import Alert.Message;

import java.io.IOException;

public class ControladorGastoCalorico {
    private App aplicacionAsociada;

    public void asociarApp(App app){
        this.aplicacionAsociada = app;
    }

    //Elementos de la ventana
    @FXML
    private RadioButton Femenino;

    @FXML
    private RadioButton Masculino;

    //Grupos de seleccion para sexo y actividad fisica
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





    private ControladorGanarMusculo controladorMusculo;
    @FXML
    void eventoCalculo(ActionEvent event) {
        //Mensaje en caso de error
        Message msg = new Message();
        //Al presionar el boton de calculo se generará una persona y se invocará el setter de calorías
        boolean validInput = false;
        try{
            //Configurando el sexo de la persona
            if (Masculino.isSelected()) {
                ManagerPersona.getPersona().setSexo("hombre");
            } else if (Femenino.isSelected()) {
                ManagerPersona.getPersona().setSexo("mujer");
            }
            //Configurando el nombre peso, altura y edad de la persona
            ManagerPersona.getPersona().setNombre(textNombre.getText());
            ManagerPersona.getPersona().setPeso(Double.parseDouble(txtPeso.getText()));
            ManagerPersona.getPersona().setAltura(Double.parseDouble(txtAltura.getText()));
            ManagerPersona.getPersona().setEdad(Integer.parseInt(txtEdad.getText()));

            //Configurando la nivel de actividad física de la persona
            if (sedentario.isSelected()) {
                ManagerPersona.getPersona().setActividadFisica("sedentario");
            } else if (ligero.isSelected()) {
                ManagerPersona.getPersona().setActividadFisica("ligera");
            } else if (moderado.isSelected()) {
                ManagerPersona.getPersona().setActividadFisica("moderada");
            } else if (intenso.isSelected()) {
                ManagerPersona.getPersona().setActividadFisica("intensa");
            }
            validInput = true;
        } catch (NumberFormatException e) {
            msg.setMessage("Verifique que haya rellenado todos los datos, considere:\n*Utilizar el punto para decimales\n*La altura es unicamente un valor entero\n*Revisar por espacios innecesarios\n*Revisar que las casillas estén seleccionadas ");
        } catch (Exception e) {
            msg.setMessage("Verifique que haya rellenado todos los datos y que estos sean coherentes.");
        }

        //Si la información ingresada es válida entonces se asignará el gasto cálorico y se lo mostrará al usuario
        //Posteriormente, se almacenaran todos los datos de la persona en la ManagerPersona
        try{
            if (validInput) {
                ManagerPersona.getPersona().setGastoCalorico(ManagerPersona.getPersona());
                calDiarias.setText(ManagerPersona.getPersona().caloriasToString());
                ManagerPersona.getPersona().setGastoCaloricoLleno(true);

            }
        }catch (NumberFormatException e) {
            msg.setMessage("Verifique que haya rellenado todos los datos y que se encuentren en el formato correcto, considere:\n*Utilizar el punto para decimales\n*La altura es unicamente un valor entero\n*Revisar por espacios innecesarios\n*Revisar que las casillas estén seleccionadas ");
        } catch (NullPointerException e) {
            msg.setMessage("Verifique que haya rellenado todos los datos, que se encuentren en el formato correcto, o contenga valores adecuados, considere:\n *Utilizar el punto para decimales\n*La altura es unicamente un valor entero\n*Revisar por espacios innecesarios\n*Revisar que las casillas estén seleccionadas ");
        }
    }

    @FXML
    public void initialize() throws IOException {
        //Se cargan todos los controladores necesarios para controlar el resto de pestañas
        try{
            FXMLLoader cargador1 = new FXMLLoader(getClass().getResource("/caloriesApp/fxml/MenuGanarMusculo.fxml"));
            AnchorPane contenidoGanarMusculo = cargador1.load();
            ControladorGanarMusculo controladorMusculo = cargador1.getController();
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


