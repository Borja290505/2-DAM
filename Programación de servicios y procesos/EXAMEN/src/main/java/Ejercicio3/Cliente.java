package Ejercicio3;

public class Cliente extends Thread{
    private final Motrador motrador;
    private final int quiere;


    public Cliente(String nombre,Motrador motrador, int quiere) {
        super(nombre);
        this.motrador = motrador;
        this.quiere = quiere;
    }

    @Override
    public void run() {
        System.out.println("[" + getName() + "] Llega y quiere " + quiere + " barras");
        try {
            for (int i = 1; i <= quiere; i++) {
                motrador.coger(i,quiere);
            }
            System.out.println("[" + getName() + "] Se va con sus " + quiere + " barras");
        } catch (InterruptedException e) {
            System.out.println("[" + getName() + "] Interrumpido");
        }
    }
}
