public class Ejercicio3_4 {
    static void main(String[] args) {
        String[] lista = {"Programas","Procesos","Servicios","Hilos"};
        long tiempoInicio = System.currentTimeMillis();
        Thread hilo1 = new Thread(() -> {
            Thread hilo2 = new Thread(() -> {
                try {
                    for (String p : lista){
                        for (int i = 1; i < 4; i++) {
                            Thread.sleep(1000);
                            System.out.println(i);
                        }
                        Thread.sleep(1000);
                        System.out.println(p);
                    }

                } catch (InterruptedException e) {
                    System.out.println("Se ha interrumpido una vez");
                }

            });
            hilo2.start();
        });
        System.out.println(tiempoInicio);
        hilo1.start();


    }
}
