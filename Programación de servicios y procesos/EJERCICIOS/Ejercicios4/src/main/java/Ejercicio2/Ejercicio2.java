package Ejercicio2;

public class Ejercicio2 {
    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1) {
            System.out.println("Uso: java Ejercicio2 <segundosMaximos>");
            return;
        }
        int maxSegundos = Integer.parseInt(args[0]);
        String yo = "[" + Thread.currentThread().getName() + "] ";

        long inicio = System.currentTimeMillis();
        Secundario sec = new Secundario();
        sec.start();

        // Esperamos de segundo en segundo, como máximo maxSegundos
        int esperados = 0;
        while (sec.isAlive() && esperados < maxSegundos) {
            System.out.println(yo + "Hilo principal esperando...");
            sec.join(1000);
            esperados++;
        }

        if (sec.isAlive()) {
            System.out.println(yo + "Tiempo máximo agotado. Interrumpo al hilo secundario.");
            sec.interrupt();
        }

        sec.join();   // esperamos a que termine definitivamente

        long total = System.currentTimeMillis() - inicio;
        System.out.println(yo + "Tiempo total de ejecución: " + total + " ms");
    }
}
