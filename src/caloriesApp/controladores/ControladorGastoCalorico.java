package caloriesApp.controladores;

import caloriesApp.App;
import caloriesApp.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import Alert.Message;


public class ControladorGastoCalorico {
    private App aplicacionAsociada;

    public void asociarApp(App app){
        this.aplicacionAsociada = app;
    }
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
        Persona p1 = new Persona();
        boolean validInput = false;
        try{
            //Configurando el sexo de la persona
            if (Masculino.isSelected()) {
                p1.setSexo("masculino");
            } else if (Femenino.isSelected()) {
                p1.setSexo("femenino");
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
            msg.setMessage("Verifique que haya rellenado todos los datos y que se encuentren en el formato correcto, considere:\n*Utilizar el punto para decimales\n*Revisar por espacios innecesarios\n*Revisar que las casillas estén seleccionadas ");
        } catch (NullPointerException e) {
            msg.setMessage("Verifique que haya rellenado todos los datos y que se encuentren en el formato correcto, considere:\n *Utilizar el punto para decimales\n*Revisar por espacios innecesarios\n*Revisar que las casillas estén seleccionadas ");
        }
        if (validInput) {
            p1.setGastoCalorico(p1);
            calDiarias.setText(p1.caloriasToString());
        }


    }


}


