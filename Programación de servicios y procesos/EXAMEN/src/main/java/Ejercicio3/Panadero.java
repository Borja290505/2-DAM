package Ejercicio3;

public class Panadero implements Runnable{
    private Motrador motrador;
    private int horneadas = 0;

    public Panadero(Motrador motrador) {
        this.motrador = motrador;
    }

    @Override
    public void run() {
        String yo = Thread.currentThread().getName();
        try {
            int barra;
            while ((barra=motrador.siguienteBarra())!=-1){
                Thread.sleep(300 + (int)(Math.random()*401));
                motrador.dejar(barra);
                horneadas++;
            }
        } catch (InterruptedException e) {
            System.out.println("[" + yo + "] Interrumpido");
        }
        System.out.println(">>> [" + yo + "] Termina. Barras horneadas: " + horneadas);
    }
}
