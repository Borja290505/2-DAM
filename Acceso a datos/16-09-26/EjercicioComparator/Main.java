package EjercicioComparator;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static void main(String[] args) {
        Comparator<Paciente> comparatorGravedad = (p1, p2) -> {
            if (p1.getGravedad() != p2.getGravedad()){
                return Integer.compare(p2.getGravedad(), p1.getGravedad());
            }
            return p1.getLlegada().compareTo(p2.getLlegada());
        };

        PriorityQueue<Paciente> colaUrgencias = new PriorityQueue<>(comparatorGravedad);

        cargarPaciente(colaUrgencias);
        while (!colaUrgencias.isEmpty()){
            Paciente atendido = colaUrgencias.poll();
            System.out.println(atendido.nombre + " " + atendido.getGravedad());
        }

    }

    private static void cargarPaciente(PriorityQueue<Paciente>cola){
        cola.add(new Paciente("Ana",5, LocalDateTime.parse("2026-09-16T10:01")));
        cola.add(new Paciente("Luis",9, LocalDateTime.parse("2026-09-16T10:02")));
        cola.add(new Paciente("Marta",9, LocalDateTime.parse("2026-09-16T10:03")));
    }
}
