package Ejercicio5;

import java.util.Random;

public class Saldo {
    private Double saldo;

    public Saldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        try {
            int tiempo = new Random().nextInt(400)+100;
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido");
        }
        this.saldo = saldo;
    }

    public synchronized void aniadirSaldo(String nombreHilo,Double cantidad){
        double saldoInicial = getSaldo();
        double saldoFinal = saldoInicial + cantidad;

        setSaldo(saldoFinal);

        System.out.println("[" + nombreHilo + "] añadió: " + cantidad +
                " | Saldo Inicial: " + saldoInicial +
                " | Saldo Final: " + getSaldo());
    }
}
