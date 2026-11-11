package Ejercicio4;



public class HiloMensajes extends Thread{
    private final String[] mensajes= {"Programas", "Procesos", "Servicios","Hilos"};
    public HiloMensajes(){
        super("HijoHilo");
    }

    @Override
    public void run() {
        boolean sinEsperas = false;
        for (String mensaje : mensajes){
            System.out.println(getName() + " " + mensaje);

            if (!sinEsperas){
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    System.out.println("Me han interumpido");
                    sinEsperas=true;
                }
            }
        }
        System.out.println("[" + getName() + "] He terminado");
    }
}
