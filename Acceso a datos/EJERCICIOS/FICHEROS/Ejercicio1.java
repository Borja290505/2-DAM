package FICHEROS;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1 {
    static void main(String[] args) {

        //Declaramos la ruta del archivo
        String ruta = "texto.txt";
        int contadorLineas = contarLineas(ruta);
        System.out.println("El fichero tiene: " + contadorLineas + " lineas");

    }

    public static int contarLineas(String ruta) {
        int lineas = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))){
            while (br.readLine() != null){
                lineas++;
            }
        } catch (IOException e) {
            System.out.println("No se ha podido leer el archivo");
            System.out.println(e.getMessage());
        }
        return lineas;
    }
}
