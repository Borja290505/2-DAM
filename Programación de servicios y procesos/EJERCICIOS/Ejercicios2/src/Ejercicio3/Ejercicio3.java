package Ejercicio3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Ejercicio3 {
    static void main(String[] args) {

        Path ruta = Path.of("src/Ejercicio3/comando.txt");
        File archivo = ruta.toFile();

        Path rutaE = Path.of("src/Ejercicio3/errores.txt");
        Path rutaS = Path.of("src/Ejercicio3/salida.txt");

        File archivoE = rutaE.toFile();
        File archivoS = rutaS.toFile();

        try {
            Process ej3 = new ProcessBuilder("cmd").redirectError(archivoE).redirectOutput(archivoS).redirectInput(archivo).start();

            ej3.waitFor();

            System.out.println("Codigo de finalizacion: " + ej3.exitValue());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
