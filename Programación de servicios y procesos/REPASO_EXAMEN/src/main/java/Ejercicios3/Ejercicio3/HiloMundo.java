package Ejercicio3;

public class HiloMundo extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println(" mundo!");   // println = texto + retorno de carro
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}