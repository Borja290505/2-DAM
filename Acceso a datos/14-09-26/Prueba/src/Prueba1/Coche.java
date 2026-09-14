package Prueba1;

public class Coche {
    String matricula;
    String numBastidor;
    String dueño;
    int potencia;

    public Coche() {
    }

    public Coche(String numBastidor, String matricula, String dueño, int potencia) {
        this.numBastidor = numBastidor;
        this.matricula = matricula;
        this.dueño = dueño;
        this.potencia = potencia;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNumBastidor() {
        return numBastidor;
    }

    public String getDueño() {
        return dueño;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNumBastidor(String numBastidor) {
        this.numBastidor = numBastidor;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", numBastidor='" + numBastidor + '\'' +
                ", dueño='" + dueño + '\'' +
                ", potencia=" + potencia +
                '}';
    }
}
