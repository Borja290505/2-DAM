package Ejercicio4;

public class Main {
    static void main(String[] args) throws InterruptedException {
        long inicio = System.currentTimeMillis();
        String yo = Thread.currentThread().getName();

        int tiempoMax;
        if (args.length > 0){
            tiempoMax = Integer.parseInt(args[0]);
        }else{
            tiempoMax = Integer.MAX_VALUE;
        }

        HiloMensajes hijo = new HiloMensajes();

        hijo.start();

        int segundos=0;
        boolean interrumpido = false;

        while (hijo.isAlive()){
            System.out.println("[" + yo + "] Esperando a que termine " + hijo.getName() + "... (" + segundos + " s)");
            hijo.join(1000);
            segundos++;

            if (segundos>=tiempoMax && hijo.isAlive() && !interrumpido){
                System.out.println("[" + yo + "] Tiempo máximo superado: interrumpo a " + hijo.getName());
                hijo.interrupt();
                interrumpido = true;
            }
        }
        long fin = System.currentTimeMillis();
        System.out.println("[" + yo + "] Fin del programa. Tiempo de ejecución: " + (fin - inicio) / 1000.0 + " s");
    }
}
