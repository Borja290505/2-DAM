package Ejercicio3;

public class main {
    static void main(String[] args) throws InterruptedException {
        HiloHola hilo1 = new HiloHola();
        HiloMundo hilo2 = new HiloMundo();

        hilo1.start();
        Thread.sleep(20);
        hilo2.start();

        Thread.sleep(5000);
        hilo1.interrupt();

    }
}
