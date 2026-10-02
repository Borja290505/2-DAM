public class Ejercicio3_3 {
    static void main(String[] args) {
        Thread hilo1 = new Thread(() -> {
            try {
                for (int i = 0; i <15; i++) {
                    System.out.println("Hola");
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                System.out.println("Se ha interrumpido una vez");
            }
        });

        Thread hilo2 = new Thread(() -> {
            try {
                for (int i = 0; i <15; i++) {
                    System.out.println(" mundo");
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                System.out.println("Se ha interrumpido una vez");
            }
        });

        hilo1.start();

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hilo2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        System.out.println("\n[Hilo Principal] Interrumpiendo al Hilo 1...");
        hilo1.interrupt();
    }
}