package Ejercicio4;

public class Ejercicio4 {
    public static void main(String[] args) throws InterruptedException {
        ColaTrabajos cola = new ColaTrabajos(5);

        Productor p1 = new Productor("Productor-1", cola);
        Productor p2 = new Productor("Productor-2", cola);
        Consumidor c1 = new Consumidor("Consumidor-1", cola);
        Consumidor c2 = new Consumidor("Consumidor-2", cola);

        p1.start();
        p2.start();
        c1.start();
        c2.start();

        // Cuando acaban los productores, una marca FIN por cada consumidor
        p1.join();
        p2.join();
        cola.añadir(ColaTrabajos.FIN);
        cola.añadir(ColaTrabajos.FIN);

        c1.join();
        c2.join();
        System.out.println("Programa finalizado: se han producido y consumido 20 elementos");
    }
}