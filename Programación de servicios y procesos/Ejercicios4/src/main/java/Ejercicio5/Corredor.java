package Ejercicio5;

import java.util.Random;

public class Corredor extends Thread {
    public static final int DISTANCIA = 20;

    private final Clasificacion clasificacion;
    private final Random random = new Random();

    public Corredor(String nombre, Clasificacion clasificacion) {
        super(nombre);
        this.clasificacion = clasificacion;
    }

    @Override
    public void run() {
        int distancia = 0;
        try {
            while (distancia < DISTANCIA) {
                int avance = 1 + random.nextInt(3);                    // 1-3 metros
                distancia = Math.min(DISTANCIA, distancia + avance);
                System.out.println("[" + getName() + "] Ha avanzado " + avance
                        + " metros. Distancia: " + distancia + "/" + DISTANCIA);
                Thread.sleep(200 + random.nextInt(401));               // 200-600 ms
            }
            int pos = clasificacion.registrarLlegada(getName());
            System.out.println("[" + getName() + "] ¡Ha terminado! Posición: " + pos);
        } catch (InterruptedException e) {
            System.out.println("[" + getName() + "] interrumpido");
        }
    }
}