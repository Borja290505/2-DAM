package Ejercicio5;

public class Main {
    static void main(String[] args) throws InterruptedException {
        Saldo saldo = new Saldo(20);
        System.out.println("Tienes un saldo inicial de" + saldo.getSaldo());

        Thread h1 = new Thread(new Ingresar(saldo,50),"Ana");
        Thread h2 = new Thread(new Ingresar(saldo,20),"Borja");
        Thread h3 = new Thread(new Ingresar(saldo,30),"Alba");

        h1.start();
        h2.start();
        h3.start();

        h1.join();
        h2.join();
        h3.join();

        System.out.println("Saldo final: " + saldo.getSaldo());
    }
}
