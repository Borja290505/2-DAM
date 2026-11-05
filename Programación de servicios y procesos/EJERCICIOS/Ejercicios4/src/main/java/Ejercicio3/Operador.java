package Ejercicio3;

public class Operador implements Runnable {
    private final Cuenta cuenta;
    private final boolean esIngreso;
    private final double cantidad;

    Operador(Cuenta cuenta, boolean esIngreso, double cantidad) {
        this.cuenta = cuenta;
        this.esIngreso = esIngreso;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                if (esIngreso) cuenta.ingresar(cantidad);
                else cuenta.retirar(cantidad);
            }
        } catch (InterruptedException e) {
            System.out.println("[" + Thread.currentThread().getName() + "] interrumpido");
        }
    }
}
