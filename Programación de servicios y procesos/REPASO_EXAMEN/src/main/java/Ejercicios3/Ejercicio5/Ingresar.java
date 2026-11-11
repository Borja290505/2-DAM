package Ejercicio5;

public class Ingresar implements Runnable{
    private final Saldo saldo;
    private final int cantidad;

    public Ingresar(Saldo saldo, int cantidad) {
        this.saldo = saldo;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        saldo.ingresar(cantidad,Thread.currentThread().getName());
    }
}
