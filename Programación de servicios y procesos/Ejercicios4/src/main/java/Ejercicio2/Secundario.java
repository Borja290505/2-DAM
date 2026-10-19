package Ejercicio2;

public class Secundario extends Thread {
    private final String[] mensajes = {
            "Inicio del programa", "Procesos", "Servicios",
            "Multihilo", "Sincronización", "Fin del programa"
    };

    public Secundario() {
        super("Hilo-SECUNDARIO");
    }

    @Override
    public void run() {
        int i = 0;
        try {
            for (; i<mensajes.length;i++){
                System.out.println("[" + getName() + "] " + mensajes[i]);

                if (i<mensajes.length-1){
                    Thread.sleep(3000);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("[" + getName() + "] Interrupción detectada. Muestro el resto sin esperas:");
        }
        for (i = i + 1; i < mensajes.length; i++) {
            System.out.println("[" + getName() + "] " + mensajes[i]);
        }
    }
}
