import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        try {
// creamos el objeto url
            URL url = new URL("https://es.wikipedia.org");
// abrimos un reader que lee directamente de la url
            BufferedReader in = new BufferedReader(

                    new InputStreamReader(url.openStream())
            );
// recorremos el reader y lo mostramos por consola
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
