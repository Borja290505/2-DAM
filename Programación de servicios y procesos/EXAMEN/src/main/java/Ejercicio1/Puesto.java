package Ejercicio1;

public class Puesto {
    private final int id;
    private boolean ocupado = false;
    private int cochesLavados;

    public Puesto(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public int getCochesLavados() {
        return cochesLavados;
    }

    public void ocupar(){
        ocupado=true;
    }

    public void liberar(){
        ocupado=false;
        cochesLavados++;
    }
}
