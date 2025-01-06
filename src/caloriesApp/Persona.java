package caloriesApp;

public class Persona {
    private String sexo;
    private String nombre;
    private double peso;
    private double altura;
    private double edad;
    private String actividadFisica; // SEDENTARIO , POCO ACTIVO, ACTIVO Y MUY ACTIVO
    private double gastoCalorico;
    private String nivelExperiencia;  // PRINCIPIANTE , INTERMEDIO , AVANZADO
    private double caloriasGanarMusc;
    private double caloriasPerderGrasa;
    private double gramosProteina;
    private double gramosGrasa;
    private double gramosCarbohidratos;
    private boolean gastoCaloricoLleno;
    private boolean ganarMasaLleno;
    private boolean perderGrasaLleno;

    public Persona(){
    }
    public Persona(String sexo, String nombre, double peso, double altura, double edad, String actividadFisica) {
        this.sexo = sexo;
        this.nombre = nombre;
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
        this.gastoCalorico = 0;
        this.nivelExperiencia = "";
        this.caloriasGanarMusc = 0;
        this.caloriasPerderGrasa = 0;
        this.gramosProteina = 0;
        this.gramosGrasa = 0;
        this.gramosCarbohidratos = 0;
        this.gastoCaloricoLleno = false;
        this.ganarMasaLleno = false;
        this.perderGrasaLleno = false;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getEdad() {
        return edad;
    }

    public void setEdad(double edad) {
        this.edad = edad;
    }

    public String getActividadFisica() {
        return actividadFisica;
    }

    public void setActividadFisica(String actividadFisica) {
        this.actividadFisica = actividadFisica;
    }

    public double getGastoCalorico() {
        return gastoCalorico;
    }
    public String caloriasToString(){
        return String.format("%.2f", gastoCalorico);

    }

    public void setGastoCalorico(Persona persona) {
        //Calculo general de las gastoCalorico que consume en promedio una persona
        if (persona.sexo.equals("masculino")) {
            gastoCalorico = 13.707 * (persona.peso) + 492.3 * (persona.altura/100) - 6.673 * (persona.edad) + 77.607005;
        } else if (persona.sexo.equals("femenino")) {
            gastoCalorico = 9.740 * (persona.peso) + 172.9 * (persona.altura/100) - 4.737 * (persona.edad) + 667.051005;
        }

        //Modifcando la cantidad de gastoCalorico en funcion de la actividad fisica, para obtener el valor real
        switch (persona.actividadFisica) {
            case "sedentario" -> gastoCalorico = gastoCalorico * 1.375;
            case "ligera" -> gastoCalorico = gastoCalorico * 1.56;
            case "moderada" -> gastoCalorico = gastoCalorico * 1.64;
            case "intensa" -> gastoCalorico = gastoCalorico * 1.82;
        }
    }
}
