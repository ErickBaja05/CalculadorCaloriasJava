package caloriesApp;

public class ManagerPersona {
    public static Persona persona = new Persona();

    public static Persona getPersona() {
        return persona;
    }

    public static void setPersona(Persona persona) {
        ManagerPersona.persona = persona;
    }

    public String valorToString(double valor){
        return String.format("%.2f", valor);
    }
}
