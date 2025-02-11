package caloriesApp;

public class Persona {
    private String sexo;
    private String nombre = "Usuario";
    private double peso;
    private double altura;
    private double edad;
    private String actividadFisica; // SEDENTARIO , POCO ACTIVO, ACTIVO Y MUY ACTIVO
    private double gastoCalorico;
    private String nivelExperiencia;  // PRINCIPIANTE , INTERMEDIO , AVANZADO
    private double caloriasGanarMusc;
    private double caloriasPerderGrasa;
    private double gramosProteinaGanarMusc;
    private double gramosGrasaGanarMusc;
    private double gramosCarbohidratosGanarMusc;
    private double gramosProteinaPerderGrasa;
    private double gramosGrasaPerderGrasa;
    private double gramosCarbohidratosPerderGrasa;
    private boolean gastoCaloricoLleno;
    private boolean ganarMasaLleno;
    private boolean perderGrasaLleno;


    public Persona(){
    }
    public Persona(String sexo, String nombre, double peso, double altura, double edad, String actividadFisica) throws Exception {

        if((peso > 635 || peso < 15) || (altura < 60 || altura > 255) || (edad < 3 || edad > 120)){
            throw new Exception("Algun valor ingresado esta fuera de rango");
        } else {
            this.sexo = sexo;
            this.nombre = nombre;
            this.peso = peso;
            this.altura = altura;
            this.edad = edad;
            this.gastoCalorico = 0;
            this.nivelExperiencia = "";
            this.caloriasGanarMusc = 0;
            this.caloriasPerderGrasa = 0;
            this.gramosProteinaGanarMusc = 0;
            this.gramosGrasaGanarMusc = 0;
            this.gramosCarbohidratosGanarMusc = 0;
            this.gramosProteinaPerderGrasa = 0;
            this.gramosGrasaPerderGrasa = 0;
            this.gramosCarbohidratosPerderGrasa = 0;
            this.gastoCaloricoLleno = false;
            this.ganarMasaLleno = false;
            this.perderGrasaLleno = false;
        }
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) throws Exception {
        if (peso > 635 || peso < 15) {
            throw new Exception("Peso fuera de rango");
        }
        this.peso = peso;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) throws Exception {
        if (altura < 60 || altura > 255) {
            throw new Exception("Altura fuera de rango");
        } else{
            this.altura = altura;
        }
    }

    public double getEdad() {
        return this.edad;
    }

    public void setEdad(double edad) throws Exception {

        if (edad < 3 || edad > 120) {
            throw new Exception("Edad fuera de rango");
        }
        else{
            this.edad = edad;
        }
    }

    public String getActividadFisica() {
        return this.actividadFisica;
    }

    public void setActividadFisica(String actividadFisica) {
        this.actividadFisica = actividadFisica;
    }

    public void setGastoCalorico(double gastoCalorico) {
        this.gastoCalorico = gastoCalorico;
    }

    public String getNivelExperiencia() {
        return nivelExperiencia;
    }

    public void setNivelExperiencia(String nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }

    public double getCaloriasGanarMusc() {
        return caloriasGanarMusc;
    }

    public void setCaloriasGanarMusc(double caloriasGanarMusc) {
        this.caloriasGanarMusc = caloriasGanarMusc;
    }

    public double getCaloriasPerderGrasa() {
        return caloriasPerderGrasa;
    }

    public void setCaloriasPerderGrasa(double caloriasPerderGrasa) {
        this.caloriasPerderGrasa = caloriasPerderGrasa;
    }

    public double getGramosProteinaGanarMusc() {
        return gramosProteinaGanarMusc;
    }

    public void setGramosProteinaGanarMusc(double gramosProteinaGanarMusc) {
        this.gramosProteinaGanarMusc = gramosProteinaGanarMusc;
    }

    public double getGramosGrasaGanarMusc() {
        return gramosGrasaGanarMusc;
    }

    public void setGramosGrasaGanarMusc(double gramosGrasaGanarMusc) {
        this.gramosGrasaGanarMusc = gramosGrasaGanarMusc;
    }

    public double getGramosCarbohidratosGanarMusc() {
        return gramosCarbohidratosGanarMusc;
    }

    public void setGramosCarbohidratosGanarMusc(double gramosCarbohidratosGanarMusc) {
        this.gramosCarbohidratosGanarMusc = gramosCarbohidratosGanarMusc;
    }

    public double getGramosProteinaPerderGrasa() {
        return gramosProteinaPerderGrasa;
    }

    public void setGramosProteinaPerderGrasa(double gramosProteinaPerderGrasa) {
        this.gramosProteinaPerderGrasa = gramosProteinaPerderGrasa;
    }

    public double getGramosGrasaPerderGrasa() {
        return gramosGrasaPerderGrasa;
    }

    public void setGramosGrasaPerderGrasa(double gramosGrasaPerderGrasa) {
        this.gramosGrasaPerderGrasa = gramosGrasaPerderGrasa;
    }

    public double getGramosCarbohidratosPerderGrasa() {
        return gramosCarbohidratosPerderGrasa;
    }

    public void setGramosCarbohidratosPerderGrasa(double gramosCarbohidratosPerderGrasa) {
        this.gramosCarbohidratosPerderGrasa = gramosCarbohidratosPerderGrasa;
    }

    public boolean isGastoCaloricoLleno() {
        return gastoCaloricoLleno;
    }

    public void setGastoCaloricoLleno(boolean gastoCaloricoLleno) {
        this.gastoCaloricoLleno = gastoCaloricoLleno;
    }

    public boolean isGanarMasaLleno() {
        return ganarMasaLleno;
    }

    public void setGanarMasaLleno(boolean ganarMasaLleno) {
        this.ganarMasaLleno = ganarMasaLleno;
    }

    public boolean isPerderGrasaLleno() {
        return perderGrasaLleno;
    }

    public void setPerderGrasaLleno(boolean perderGrasaLleno) {
        this.perderGrasaLleno = perderGrasaLleno;
    }

    public double getGastoCalorico() {
        return this.gastoCalorico;
    }
    public String caloriasToString(){
        return String.format("%.2f", this.gastoCalorico);
    }

    public String valorToString(double valor){
        return String.format("%.2f", valor);
    }

    public void setGastoCalorico(Persona persona) {
        //Calculo general de las gastoCalorico que consume en promedio una persona
        if (persona.getSexo().equals("hombre")) {
            this.gastoCalorico = 13.707 * (persona.getPeso()) + 492.3 * (persona.getAltura()/100) - 6.673 * (persona.getEdad()) + 77.607005;
        } else if (persona.sexo.equals("mujer")) {
            this.gastoCalorico = 9.740 * (persona.getPeso()) + 172.9 * (persona.getAltura()/100) - 4.737 * (persona.getEdad()) + 667.051005;
        }

        //Modifcando la cantidad de gastoCalorico en funcion de la actividad fisica, para obtener el valor real
        switch (persona.actividadFisica) {
            case "sedentario" -> this.gastoCalorico = this.gastoCalorico * 1.375;
            case "ligera" -> this.gastoCalorico = this.gastoCalorico * 1.56;
            case "moderada" -> this.gastoCalorico = this.gastoCalorico * 1.64;
            case "intensa" -> this.gastoCalorico = this.gastoCalorico * 1.82;
        }
    }
}
