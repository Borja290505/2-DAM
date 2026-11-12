package Ejercicio1;

public class Coche extends Thread{
    private final Lavadero lavadero;
    private final int tiempoBase;

    public Coche(String nombre,Lavadero lavadero, int tiempoBase) {
        super(nombre);
        this.lavadero = lavadero;
        this.tiempoBase = tiempoBase;
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " LLEGA AL LAVADERO");

            Puesto puesto = lavadero.ocupar(getName());
            int tiempoLavado = (int) (tiempoBase + (Math.random()*1000));

            System.out.println("EL COCHE " + getName() + "SE HA LAVADO DURANTE " + tiempoLavado + "ms");
            Thread.sleep(tiempoLavado);
            lavadero.liberar(puesto,getName());

        } catch (InterruptedException e) {
            System.out.println(getName() + " HA SIDO INTERRUMPIDO");
        }
    }
}
