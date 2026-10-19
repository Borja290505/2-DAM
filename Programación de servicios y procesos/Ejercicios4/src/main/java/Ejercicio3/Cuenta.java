package Ejercicio3;

import java.util.Random;

public class Cuenta {
    protected double saldo;
    protected final Random random = new Random();

    Cuenta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void ingresar(double cantidad) throws InterruptedException {
        double anterior = saldo;                         // 1. leer
        Thread.sleep(100 + random.nextInt(401));         // 2. "tarda" 100-500 ms
        saldo = anterior + cantidad;                     // 3. escribir
        mostrar("Ingreso", cantidad, anterior, saldo);
    }

    public void retirar(double cantidad) throws InterruptedException {
        double anterior = saldo;
        Thread.sleep(100 + random.nextInt(401));
        if (anterior >= cantidad) {
            saldo = anterior - cantidad;
            mostrar("Retirada", cantidad, anterior, saldo);
        } else {
            System.out.println("[" + Thread.currentThread().getName()
                    + "] Retirada de " + cantidad + " € rechazada: saldo insuficiente");
        }
    }

    protected void mostrar(String tipo, double cantidad, double anterior, double posterior) {
        System.out.println("[" + Thread.currentThread().getName() + "] " + tipo + ": " + cantidad + " €"
                + "\n   Saldo anterior: " + anterior + " €"
                + "\n   Saldo posterior: " + posterior + " €");
    }
}