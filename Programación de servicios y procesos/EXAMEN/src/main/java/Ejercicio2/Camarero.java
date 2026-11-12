package Ejercicio2;

public class Camarero implements Runnable{
    private ZonaRecogida zonaRecogida;
    private int gestionados = 0;

    public Camarero(ZonaRecogida zonaRecogida) {
        this.zonaRecogida = zonaRecogida;
    }

    @Override
    public void run() {
        String yo = Thread.currentThread().getName();
        try {
            while ((zonaRecogida.recoger() != -1)){
                gestionados++;
                Thread.sleep(300 + (int)(Math.random() * 301));

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(">>> [" + yo + "] Termina. Pedidos entregados: " + gestionados);
    }
}
