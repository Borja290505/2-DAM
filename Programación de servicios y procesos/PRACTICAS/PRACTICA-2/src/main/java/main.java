import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class main {
    static void main(String[] args) {
        // <====================== 1 - LISTA DE RUTAS =======================>
        Instant inicio = Instant.now();
        List<Path> archivos = new ArrayList<>();

        Path direccion = Path.of("src/main/registros");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(direccion)){
            for (Path path: stream) {
                archivos.add(path);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
