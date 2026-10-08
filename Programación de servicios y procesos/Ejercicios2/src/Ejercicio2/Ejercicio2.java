package Ejercicio2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Ejercicio2 {
    static void main(String[] args) {

        Path rutaS = Path.of("src/Ejercicio2/salida.txt");
        Path rutaE = Path.of("src/Ejercicio2/errores.txt");

        File archivoS = rutaS.toFile();
        File archivoE = rutaE.toFile();

        try {
            Process ej2 = new ProcessBuilder("cmd.exe","/c","echo Usuario actual: && whoami && echo Directorio actual: && cd && echo Contenido del directorio: && dir").redirectError(archivoE).redirectOutput(archivoS).start();

            ej2.waitFor();

            System.out.println("Codigo de finalizacion: " + ej2.exitValue());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
