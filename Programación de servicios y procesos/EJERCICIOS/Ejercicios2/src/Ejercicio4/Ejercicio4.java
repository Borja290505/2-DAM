package Ejercicio4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Ejercicio4 {
    public static void main(String[] args) {
        Path ruta = Path.of("src/Ejercicio4/comandos.txt");
        File archivo = ruta.toFile();

        Path rutaE = Path.of("src/Ejercicio4/errores.txt");
        Path rutaS = Path.of("src/Ejercicio4/salida.txt");

        File archivoE = rutaE.toFile();
        File archivoS = rutaS.toFile();

        try {
            Process ej4 = new ProcessBuilder("cmd").redirectInput(archivo).redirectError(archivoE).redirectOutput(archivoS).start();

            ej4.waitFor();

            System.out.println("Codigo de finalizacion: " + ej4.exitValue());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
