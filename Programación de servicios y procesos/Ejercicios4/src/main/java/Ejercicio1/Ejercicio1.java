package Ejercicio1;

public class Ejercicio1 {
    static void main(String[] args) throws InterruptedException {
        Escritor hola = new Escritor("Hilo-HOLA","Hola");
        Escritor dam = new Escritor("Hilo-DAM","Dam");

        long inicio = System.currentTimeMillis();
        hola.start();
        Thread.sleep(50);
        dam.start();

        hola.join(Math.max(1,5000 - (System.currentTimeMillis()-inicio)));
        dam.join(Math.max(1,5000 - (System.currentTimeMillis()-inicio)));

        if (hola.isAlive()) hola.interrupt();
        if (dam.isAlive()) dam.interrupt();

        hola.join();
        dam.join();
    }
}
