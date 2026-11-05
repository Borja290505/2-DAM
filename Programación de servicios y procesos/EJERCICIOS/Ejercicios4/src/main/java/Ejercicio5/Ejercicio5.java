package Ejercicio5;

import java.util.List;

public class Ejercicio5 {
    public static void main(String[] args) throws InterruptedException {
        long inicio = System.currentTimeMillis();
        Clasificacion clasificacion = new Clasificacion();

        Corredor[] corredores = new Corredor[4];
        for (int i = 0; i < corredores.length; i++) {
            corredores[i] = new Corredor("Corredor-" + (i + 1), clasificacion);
        }

        for (Corredor c : corredores) c.start();
        for (Corredor c : corredores) c.join();

        System.out.println("\n=== CLASIFICACIÓN FINAL ===");
        List<String> llegadas = clasificacion.getLlegadas();
        for (int i = 0; i < llegadas.size(); i++) {
            System.out.println((i + 1) + "º " + llegadas.get(i));
        }
        System.out.println("Tiempo total de la carrera: "
                + (System.currentTimeMillis() - inicio) + " ms");
    }
}