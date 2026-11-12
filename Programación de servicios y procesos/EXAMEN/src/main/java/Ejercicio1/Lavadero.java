package Ejercicio1;

public class Lavadero {
    private final Puesto[] puestos;
    private int cochesQueEsperaron;
    private int cochesAtendidos;

    public Lavadero(int numPuestos) {
        puestos = new Puesto[numPuestos];
        for (int i = 0; i < numPuestos; i++) {
            puestos[i] = new Puesto(i+1);
        }
    }

    private Puesto buscarLibre(){
        for (Puesto p : puestos){
            if (!p.isOcupado()){
                return p;
            }
        }
        return null;
    }

    public synchronized Puesto ocupar(String coche) throws InterruptedException {
        boolean haEsperado = false;
        Puesto libre = buscarLibre();
        while (libre == null){
            if (!haEsperado){
                cochesQueEsperaron++;
                haEsperado=true;
            }
            wait();
            libre = buscarLibre();
        }
        libre.ocupar();
        System.out.println("[" + coche + "] Ocupa el PUESTO" + libre.getId());
        return libre;
    }

    public synchronized void liberar(Puesto puesto, String coche){
        puesto.liberar();
        cochesAtendidos++;
        System.out.println("EL COCHE" + coche + " SALE DEL PUESTO" + puesto.getId() + "LIMPIO");
        notifyAll();
    }

    public synchronized void mostrarEstadisticas(int cocheTotales, long tiempoms){
        System.out.println("\n========== BALANCE FINAL ==========");
        System.out.println("Puesto abiertos     " + puestos.length);
        System.out.println("Coche llegados      " + cocheTotales);
        System.out.println("Coche atendidos     " + cochesAtendidos);
        System.out.println("Coche que esperaron " + cochesQueEsperaron);

        for (Puesto p : puestos){
            System.out.println("PUESTO " + p.getId() + " HA LAVADO " + p.getCochesLavados());
        }
        System.out.println("Tiempo total:          " + tiempoms / 1000.0 + " s");

    }
}
