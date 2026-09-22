package Clase;

import java.util.ArrayList;

public class DAM {

    // Añadimos 'public' para que Java pueda ejecutar el programa
    public static void main (String[] args) {

        final Boolean breva = true;

        while (breva) {

            String Juanma = "Como un pulpo en un garaje...";
            String Pascual = "eh eh al talleh quilez, ya vale eh vale porque ya vale";
            String Iker = "Madura";
            pillarPorBanda(Iker);

            ArrayList<String> losBuenos = new ArrayList<>();

            losBuenos.add("PC1 Pablo");
            losBuenos.add("PC2 Héctor ");
            losBuenos.add("PC3 Andrés");
            losBuenos.add("PC4 Alonso");

            // Opcional: añadimos un break para que no sea un bucle infinito en tu consola
            break;
        }
    }

    // EL MÉTODO QUE FALTABA:
    // Debe ser static porque se llama desde un contexto estático (el main)
    public static void pillarPorBanda(String alumno) {
        System.out.println("Pillando por banda a... " + alumno + " dice: ¡" + alumno + "!");
    }
}
