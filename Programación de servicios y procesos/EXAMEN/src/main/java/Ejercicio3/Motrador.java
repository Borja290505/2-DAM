package Ejercicio3;

import java.util.LinkedList;

public class Motrador {
    private final int CAPACIDAD = 4;
    private final LinkedList<Integer> barras = new LinkedList<>();
    private final int totalBarras;
    private int asignadas;
    private int horneadas;
    private int vendidas;

    public Motrador(int totalBarras) {
        this.totalBarras = totalBarras;
    }

    public synchronized int siguienteBarra(){
        if (asignadas<totalBarras){
            asignadas++;
            return asignadas;
        }
        return -1;
    }

    public synchronized void dejar(int barra) throws InterruptedException {
        String yo = Thread.currentThread().getName();
        while (barras.size()>=CAPACIDAD){
            System.out.println("[" + yo + "] Mostrador lleno, espero...");
            wait();
        }
        barras.addLast(barra);
        horneadas++;
        System.out.println("[" + yo + "] Hornea barra #" + barra + "   (en mostrador: " + barras.size() + ")");
        notifyAll();
    }

    public synchronized void coger(int numero,int quiere) throws InterruptedException {
        String yo = Thread.currentThread().getName();
        while (barras.isEmpty()){
            wait();
        }
        vendidas++;
        barras.removeFirst();
        System.out.println("[" + yo + "] Coge barra (" + numero + "/" + quiere + ")   (en mostrador: " + barras.size() + ")");
        notifyAll();
    }

    public synchronized void mostrarEstadisticas(long tiempoMs) {
        System.out.println("\n========== BALANCE ==========");
        System.out.println("Barras a hornear:  " + totalBarras);
        System.out.println("Barras horneadas:  " + horneadas);
        System.out.println("Barras vendidas:   " + vendidas);
        System.out.println(horneadas == vendidas ? "OK: todo lo horneado se ha vendido"
                : "ERROR: no cuadran los totales");
        System.out.println("Tiempo total:      " + tiempoMs / 1000.0 + " s");
    }
}
