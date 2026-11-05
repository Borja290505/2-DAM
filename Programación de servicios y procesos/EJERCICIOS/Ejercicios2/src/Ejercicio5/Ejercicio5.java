package Ejercicio5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Ejercicio5 {
    public static void main(String[] args) {
        Path rutaIP = Path.of("src/Ejercicio5/ipconfig.txt");
        Path rutaHT = Path.of("src/Ejercicio5/hostname.txt");
        Path rutaP = Path.of("src/Ejercicio5/ping.txt");

        File archivoIP = rutaIP.toFile();
        File archivoP = rutaP.toFile();
        File archivoHT = rutaHT.toFile();

        try {
            Process ping = new ProcessBuilder("cmd","/c","ping www.google.es").redirectOutput(archivoP).start();
            Process ipconfig = new ProcessBuilder("cmd","/c","ipconfig").redirectOutput(archivoIP).start();
            Process hostname = new ProcessBuilder("cmd","/c","hostname").redirectOutput(archivoHT).start();

            ping.waitFor();
            ipconfig.waitFor();
            hostname.waitFor();

            System.out.println("Codigo de finalizacion: " + ping.exitValue());
            System.out.println("Codigo de finalizacion: " + ipconfig.exitValue());
            System.out.println("Codigo de finalizacion: " + hostname.exitValue());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
