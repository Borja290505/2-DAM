package Ejercicio2;

import java.util.LinkedList;

public class ZonaRecogida {
    private static final int CAPACIDAD = 5;
    private final LinkedList<Integer> pedidos = new LinkedList<>();
    private final int totalPedidos;

    private int asignados = 0;
    private int preparados = 0;
    private int entregados = 0;

    public ZonaRecogida(int totalPedidos) {
        this.totalPedidos = totalPedidos;
    }

    public synchronized int siguientePedidos(){
        if (asignados < totalPedidos){
            asignados++;
            return asignados;
        }
        return -1;
    }

    public synchronized void depositar(int pedido) throws InterruptedException {
        String yo = Thread.currentThread().getName();
        while (pedidos.size()>=CAPACIDAD){
            System.out.println("[" + yo + "] Zona llena, espero...");
            wait();
        }

        pedidos.addLast(pedido);
        preparados++;
        System.out.println("[" + yo + "] Deposita pedido #" + pedido
                + "   (en zona: " + pedidos.size() + ")");

        notifyAll();
    }

    public synchronized int recoger() throws InterruptedException {
        String yo = Thread.currentThread().getName();
        while (pedidos.isEmpty()&&entregados<totalPedidos){
            wait();
        }
        if (entregados==totalPedidos){
            return -1;
        }

        int pedido = pedidos.removeFirst();
        entregados++;
        System.out.println("[" + yo + "] Recoge pedido #" + pedido
                + "    (en zona: " + pedidos.size() + ")");

        notifyAll();
        return pedido;
    }

    public synchronized void mostrarEstadisticas(){
        System.out.println("\n========== ESTADÍSTICAS GLOBALES ==========");
        System.out.println("PEDIDOS DE LA SESION:   " + totalPedidos);
        System.out.println("PEDIDOS PREPARADOS  :   " + preparados);
        System.out.println("PEDIDOS ENTREGADOS  :   " + entregados);

        if (preparados==entregados){
            System.out.println("OK: TODO HA IDO BIEN");
        }else{
            System.out.println("ALGO HA FALLADO NO CUADRA");
        }

    }


}
