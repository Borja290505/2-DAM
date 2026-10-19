package Ejercicio1;

public class Escritor extends Thread{
    private final String palabra;

    Escritor(String nombre, String palabra){
        super(nombre);
        this.palabra = palabra;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i<10; i++){
                System.out.println(getName() + ":" + palabra);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(getName() + ": he sido interrumpido, finalizo.");
        }
    }
}
