package Ejercicio3;

public class Main {
    private static int aleatorio(int min,int max){
        return min + (int)(Math.random()*(max-min+1));
    }

    static void main(String[] args) throws InterruptedException {
        long inicio = System.currentTimeMillis();

        int numClientes = aleatorio(5,10);
        int[] quiere = new int[numClientes];
        int totalBarras = 0;
        for (int i = 0; i < numClientes; i++) {
            quiere[i] = aleatorio(1,3);
            totalBarras += quiere[i];
        }

        System.out.println("=== PANADERÍA ABIERTA: " + numClientes + " clientes, "
                + totalBarras + " barras a hornear ===\n");

        Motrador motrador = new Motrador(totalBarras);
        Thread t1 = new Thread(new Panadero(motrador),"Panadero-1");
        Thread t2 = new Thread(new Panadero(motrador),"Panadero-2");
        Thread t3 = new Thread(new Panadero(motrador),"Panadero-3");

        t1.start();
        t2.start();

        Cliente[] clientes = new Cliente[numClientes];
        for (int i = 0; i < numClientes; i++) {
            clientes[i] = new Cliente("Cliente-" +(i+1), motrador,quiere[i]);
            clientes[i].start();
            Thread.sleep(aleatorio(200,500));
        }

        t1.join();
        t2.join();


        for (Cliente c : clientes){
            c.join();
        }

        motrador.mostrarEstadisticas(System.currentTimeMillis() - inicio);
    }
}
