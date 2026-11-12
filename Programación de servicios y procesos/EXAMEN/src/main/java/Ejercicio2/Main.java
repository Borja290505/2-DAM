package Ejercicio2;

public class Main {
    static void main(String[] args) throws InterruptedException {
        int totalPedidos = 20 + (int)(Math.random()*21);
        System.out.println("=== RESTAURANTE ABIERTO: " + totalPedidos + " pedidos en esta sesión ===\n");

        ZonaRecogida zonaRecogida = new ZonaRecogida(totalPedidos);

        Thread[] hilos = {
                new Thread(new Cocinero(zonaRecogida),"Cocinero-1"),
                new Thread(new Cocinero(zonaRecogida),"Cocinero-2"),
                new Thread(new Cocinero(zonaRecogida),"Cocinero-3"),
                new Thread(new Camarero(zonaRecogida),"Camarero-1"),
                new Thread(new Camarero(zonaRecogida),"Camarero-2"),
        };

        for (Thread h : hilos){
            h.start();
        }

        for (Thread h : hilos){
            h.join();
        }
        zonaRecogida.mostrarEstadisticas();
    }
}
