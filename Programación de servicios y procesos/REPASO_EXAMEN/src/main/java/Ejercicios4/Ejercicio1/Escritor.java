package Ejercicios4.Ejercicio1;

public class EscritorHola extends Thread{
    private final String palabra;

    public EscritorHola(String nombre, String palabra) {
        super(nombre);
        this.palabra = palabra;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + ": " + palabra);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(getName() + ": he sido interrumpido. Finalizo.");
                return;
            }
        }
    }
}
