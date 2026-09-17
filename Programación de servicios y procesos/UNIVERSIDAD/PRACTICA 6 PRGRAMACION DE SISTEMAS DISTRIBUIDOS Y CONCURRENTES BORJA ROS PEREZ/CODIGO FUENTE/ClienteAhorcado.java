/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clienteahorcado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author borja
 */

public class ClienteAhorcado {

    public static void main(String[] args) {
        final String IP = "127.0.0.1"; 
        final int PUERTO = 45000;

        try (Socket socket = new Socket(IP, PUERTO)) {
            System.out.println("Conectado al servidor. Esperando respuesta...");

            InputStream is = socket.getInputStream();
            InputStreamReader isw = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isw);

            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            final String FIN = "FIN";
            String palabraAdivinadaMomento;
            Scanner teclado = new Scanner(System.in);

            while (true) {
                System.out.println("Esperando la respuesta del servidor...");
                palabraAdivinadaMomento = br.readLine();

                if (palabraAdivinadaMomento.equals(FIN)) {
                    System.out.println("Juego terminado. Gracias por jugar");
                    break;
                }

                System.out.println("SE HA ADIVINADO HASTA EL MOMENTO: " + palabraAdivinadaMomento);

                String letra;
                do {
                    System.out.println("INDIQUE UNA NUEVA LETRA: ");
                    letra = teclado.nextLine();
                } while (letra.length() != 1); // Validar que sea una sola letra

                bw.write(letra.toUpperCase());
                bw.newLine();
                bw.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(ClienteAhorcado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
