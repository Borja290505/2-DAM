package Ejercicio5;

public class Ejercicio5 {
    static void main(String[] args) {
        Saldo miSaldo = new Saldo(10000.0);
        System.out.println("=== SALDO INICIAL GENERAL: " + miSaldo.getSaldo() + " ===\n");

        Thread hilo1 = new Thread(new OperacionSaldo(miSaldo,"HILO-A",200.0));
        Thread hilo2 = new Thread(new OperacionSaldo(miSaldo,"HILO-B",300.0));
        Thread hilo3 = new Thread(new OperacionSaldo(miSaldo,"HILO-C",500.0));

        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();

        } catch (InterruptedException e) {
            System.out.println("El hilo principal fue interrumpido.");
        }
        System.out.println("\n=== SALDO FINAL GENERAL: " + miSaldo.getSaldo() + " ===");
    }
}
