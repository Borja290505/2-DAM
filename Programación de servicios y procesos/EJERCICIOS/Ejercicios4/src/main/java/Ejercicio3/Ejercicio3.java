package Ejercicio3;

public class Ejercicio3 {
    public static void main(String[] args) throws InterruptedException {
        boolean sincronizada = args.length > 0 && args[0].equalsIgnoreCase("sync");
        Cuenta cuenta = sincronizada ? new CuentaSync(1000) : new Cuenta(1000);
        System.out.println("=== Versión " + (sincronizada ? "CON" : "SIN") + " synchronized ===");

        Thread[] hilos = {
                new Thread(new Operador(cuenta, true, 100), "Ingresador-1"),
                new Thread(new Operador(cuenta, true, 100), "Ingresador-2"),
                new Thread(new Operador(cuenta, true, 100), "Ingresador-3"),
                new Thread(new Operador(cuenta, false, 50), "Retirador-1"),
                new Thread(new Operador(cuenta, false, 50), "Retirador-2")
        };

        for (Thread h : hilos) h.start();
        for (Thread h : hilos) h.join();

        System.out.println("\nSaldo final: " + cuenta.getSaldo() + " € (esperado: 2000.0 €)");
    }
}
