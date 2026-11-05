package Ejercicio4;

import static Ejercicio4.ColaTrabajos.FIN;

public class Consumidor extends Thread {
        private final ColaTrabajos cola;

        Consumidor(String nombre, ColaTrabajos cola) {
            super(nombre);
            this.cola = cola;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    int n = cola.extraer();
                    if (n == FIN) break;         // no quedan más trabajos
                    System.out.println("[" + getName() + "] Consume: " + n);
                    Thread.sleep(800);
                }
                System.out.println("[" + getName() + "] Termina");
            } catch (InterruptedException e) {
                System.out.println("[" + getName() + "] interrumpido");
            }
        }
    }
