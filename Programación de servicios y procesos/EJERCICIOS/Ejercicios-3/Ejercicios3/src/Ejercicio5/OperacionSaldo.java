package Ejercicio5;

public class OperacionSaldo implements Runnable{
    private Saldo saldoCompartido;
    private String nombreHilo;
    private double cantidadAAñadir;

    public OperacionSaldo(Saldo saldoCompartido, String nombreHilo, double cantidadAAñadir) {
        this.saldoCompartido = saldoCompartido;
        this.nombreHilo = nombreHilo;
        this.cantidadAAñadir = cantidadAAñadir;
    }

    @Override
    public void run() {
        saldoCompartido.aniadirSaldo(nombreHilo,cantidadAAñadir);
    }
}
