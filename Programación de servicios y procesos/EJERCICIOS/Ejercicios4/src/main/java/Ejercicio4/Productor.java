package Ejercicio4;

import java.util.Random;

public class Productor extends Thread {
        private final ColaTrabajos cola;
        private final Random random = new Random();

        Productor(String nombre, ColaTrabajos cola) {
            super(nombre);
            this.cola = cola;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    int n = random.nextInt(100) + 1;
                    cola.añadir(n);
                    System.out.println("[" + getName() + "] Produce: " + n);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println("[" + getName() + "] interrumpido");
            }
        }
    }
