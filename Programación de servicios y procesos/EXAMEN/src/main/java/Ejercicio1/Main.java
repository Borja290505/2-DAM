package Ejercicio1;

import Ejercicio1.Coche;
import Ejercicio1.Lavadero;

public class Main {

    private static int aleatorio(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    public static void main(String[] args) throws InterruptedException {
        long inicio = System.currentTimeMillis();

        int numPuestos = aleatorio(2, 4);
        int numCoches  = aleatorio(5, 12);
        int tiempoBase = aleatorio(1000, 2000);

        System.out.println("=== LAVADERO ABIERTO ===");
        System.out.println("Puestos: " + numPuestos + " | Coches: " + numCoches
                + " | Tiempo base de lavado: " + tiempoBase + " ms\n");

        Lavadero lavadero = new Lavadero(numPuestos);
        Coche[] coches = new Coche[numCoches];

        for (int i = 0; i < numCoches; i++) {
            coches[i] = new Coche("Coche-" + (i + 1), lavadero, tiempoBase);
            coches[i].start();
            Thread.sleep(aleatorio(100, 400));    // llegan escalonados
        }

        for (Coche c : coches) {
            c.join();
        }
        lavadero.mostrarEstadisticas(numCoches,System.currentTimeMillis()-inicio);
    }
}