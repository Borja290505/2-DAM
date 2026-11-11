package Ejercicio5;

public class Saldo {
    private int saldo;

    public Saldo(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    private void dormir(){
        try {
            Thread.sleep((long) (Math.random() * 500));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void ingresar(int dinero,String persona){
        int inicial = getSaldo();
        setSaldo(inicial+dinero);
        System.out.println(persona + " ha ingresado " + dinero + " tienes un total de: " + getSaldo());
    }
}
