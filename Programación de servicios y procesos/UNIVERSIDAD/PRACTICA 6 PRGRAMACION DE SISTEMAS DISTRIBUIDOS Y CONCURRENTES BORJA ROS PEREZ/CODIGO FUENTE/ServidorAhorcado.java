/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servidorahorcado;

/**
 *
 * @author borja
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorAhorcado {

    public static void main(String[] args) {
        final int PUERTO = 45000;
        final int MAX_INTENTOS = 10;
        ServerSocket socketServer = null;
        Socket socket = null;

        try {
            socketServer = new ServerSocket(PUERTO); // Escuchando en el puerto
            System.out.println("Servidor esperando al cliente");

            socket = socketServer.accept(); // Esperamos a que el cliente se conecte
            System.out.println("Cliente conectado");

            InputStream is = socket.getInputStream();
            InputStreamReader isw = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isw);

            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            final String palabra = "HOLA";
            final String FIN = "FIN";
            String palabraAdivinadaMomento = inicializarPalabraAdivinadaMomento(palabra);
            String letra;
            int intentos = 0;

            while (true) {
                // Enviar estado actual de la palabra y número de intentos restantes
                bw.write(palabraAdivinadaMomento + " | Intentos restantes: " + (MAX_INTENTOS - intentos));
                bw.write(" ");
                bw.newLine();
                bw.flush();
                

                // Recibir la letra del cliente
                letra = br.readLine().toUpperCase();

                // Comprobar si la letra está en la palabra
                if (!palabra.contains(letra)) {
                    intentos++; // Incrementar intentos solo si la letra es incorrecta
                }

                // Actualizar la palabra adivinada hasta el momento
                palabraAdivinadaMomento = actualizarPalabraAdivinadaMomento(palabra, palabraAdivinadaMomento, letra.charAt(0));

                // Verificar si el cliente ha ganado o perdido
                if (palabraAdivinadaMomento.equals(palabra)) {
                    bw.write("¡Has ganado! La palabra era: " + palabra);
                    bw.newLine();
                    bw.flush();
                    break;
                }

                if (intentos >= MAX_INTENTOS) {
                    bw.write("Has perdido. La palabra era: " + palabra);
                    bw.newLine();
                    bw.flush();
                    break;
                }
            }

            bw.write(FIN);
            bw.newLine();
            bw.flush();

        } catch (IOException ex) {
            Logger.getLogger(ServidorAhorcado.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (socket != null) socket.close();
                if (socketServer != null) socketServer.close();
            } catch (IOException ex) {
                Logger.getLogger(ServidorAhorcado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    static String inicializarPalabraAdivinadaMomento(String palabra) {
        return "-".repeat(palabra.length());
    }

    static String actualizarPalabraAdivinadaMomento(String palabra, String palabraAdivinadaMomento, char letra) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra || palabra.charAt(i) == palabraAdivinadaMomento.charAt(i)) {
                resultado.append(palabra.charAt(i));
            } else {
                resultado.append('-');
            }
        }
        return resultado.toString();
    }
}
