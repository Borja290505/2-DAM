import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            //Creamos el preceso
            ProcessBuilder pDocumento = new ProcessBuilder("C:\\Program Files\\Notepad++\\notepad++.exe","C:\\Users\\dam2\\Desktop\\2-DAM\\Programación de servicios y procesos\\Ejercicio1.txt");

            //Ejecutamos el proceso
            Process ej1 = pDocumento.start();
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
