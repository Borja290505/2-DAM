import java.io.File;
import java.io.IOException;
import jdk.swing.interop.SwingInterOpUtils;

public class Ejercicio2 {
    static void main(String[] args) {
        try {
            File output = new File("src/output.txt");
            File errors = new File("src/errors.txt");
            File input = new File("src/comandos.bat");

            Process subProceso = new ProcessBuilder("cmd.exe","/c",input.toPath().toString()).redirectOutput(output).redirectError(errors).start();

            subProceso.waitFor();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
