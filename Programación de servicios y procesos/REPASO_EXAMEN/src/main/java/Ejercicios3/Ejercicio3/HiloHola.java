package Ejercicio3;

public class HiloHola extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println("Hola ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
