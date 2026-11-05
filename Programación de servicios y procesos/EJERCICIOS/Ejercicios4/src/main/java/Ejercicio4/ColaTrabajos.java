package Ejercicio4;
import java.util.LinkedList;
import java.util.Random;

public class ColaTrabajos {
    private final LinkedList<Integer> cola = new LinkedList<>();
    private final int capacidad;
    public static final int FIN = -1;

    ColaTrabajos(int capacidad) {
        this.capacidad = capacidad;
    }

    public synchronized void añadir(int n) throws InterruptedException {
        while (cola.size() == capacidad) {   // llena -> el productor espera
            wait();
        }
        cola.addLast(n);
        notifyAll();                         // avisa a los consumidores
    }

    public synchronized int extraer() throws InterruptedException {
        while (cola.isEmpty()) {             // vacía -> el consumidor espera
            wait();
        }
        int n = cola.removeFirst();
        notifyAll();                         // avisa a los productores
        return n;
    }
}