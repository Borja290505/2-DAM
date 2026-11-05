package Ejercicio3;

public class CuentaSync extends Cuenta {
    CuentaSync(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public synchronized double getSaldo() {
        return saldo;
    }

    @Override
    public synchronized void ingresar(double cantidad) throws InterruptedException {
        super.ingresar(cantidad);
    }

    @Override
    public synchronized void retirar(double cantidad) throws InterruptedException {
        super.retirar(cantidad);
    }
}