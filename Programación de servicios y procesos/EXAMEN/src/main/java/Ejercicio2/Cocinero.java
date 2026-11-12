package Ejercicio2;

public class Cocinero implements Runnable {
    private final ZonaRecogida zonaRecogida;
    private int preparados = 0;

    public Cocinero(ZonaRecogida zonaRecogida) {
        this.zonaRecogida = zonaRecogida;
    }

    @Override
    public void run() {
        String yo = Thread.currentThread().getName();
        try{
            int pedido;
            while ((pedido=zonaRecogida.siguientePedidos()) != -1){
                Thread.sleep(200 + (int)(Math.random() * 301));
                zonaRecogida.depositar(pedido);
                preparados++;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(">>> [" + yo + "] Termina. Pedidos preparados: " + preparados);
    }
}
