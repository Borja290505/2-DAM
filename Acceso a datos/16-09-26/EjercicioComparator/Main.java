package EjercicioComparator;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static void main(String[] args) {
        //Creamos el comparador
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
            System.out.println(atendido.nombre + " " + atendido.getGravedad() + " " + atendido.getLlegada());
        }

    }

    private static void cargarPaciente(PriorityQueue<Paciente>cola){
        cola.add(new Paciente("Ana", 5, LocalDateTime.parse("2026-09-16T10:01")));
        cola.add(new Paciente("Luis", 9, LocalDateTime.parse("2026-09-16T10:02")));
        cola.add(new Paciente("Marta", 9, LocalDateTime.parse("2026-09-16T10:03")));
        cola.add(new Paciente("Pepe", 3, LocalDateTime.parse("2026-09-16T10:04")));
        cola.add(new Paciente("Sonia", 7, LocalDateTime.parse("2026-09-16T10:05")));
        cola.add(new Paciente("Raul", 4, LocalDateTime.parse("2026-09-16T10:06")));
        cola.add(new Paciente("Julia", 10, LocalDateTime.parse("2026-09-16T10:07")));
        cola.add(new Paciente("Ivan", 6, LocalDateTime.parse("2026-09-16T10:08")));
        cola.add(new Paciente("Clara", 8, LocalDateTime.parse("2026-09-16T10:09")));
        cola.add(new Paciente("Diego", 2, LocalDateTime.parse("2026-09-16T10:10")));
        cola.add(new Paciente("Nora", 10, LocalDateTime.parse("2026-09-16T10:11")));
        cola.add(new Paciente("Oscar", 1, LocalDateTime.parse("2026-09-16T10:12")));
        cola.add(new Paciente("Belen", 7, LocalDateTime.parse("2026-09-16T10:13")));
        cola.add(new Paciente("Victor", 5, LocalDateTime.parse("2026-09-16T10:14")));
        cola.add(new Paciente("Paula", 9, LocalDateTime.parse("2026-09-16T10:15")));
        cola.add(new Paciente("Sergio", 4, LocalDateTime.parse("2026-09-16T10:16")));
        cola.add(new Paciente("Irene", 6, LocalDateTime.parse("2026-09-16T10:17")));
        cola.add(new Paciente("Tomas", 8, LocalDateTime.parse("2026-09-16T10:18")));
        cola.add(new Paciente("Laura", 3, LocalDateTime.parse("2026-09-16T10:19")));
        cola.add(new Paciente("Ruben", 7, LocalDateTime.parse("2026-09-16T10:20")));
        cola.add(new Paciente("Pilar", 10, LocalDateTime.parse("2026-09-16T10:21")));
        cola.add(new Paciente("Andres", 2, LocalDateTime.parse("2026-09-16T10:22")));
        cola.add(new Paciente("Carla", 9, LocalDateTime.parse("2026-09-16T10:23")));
        cola.add(new Paciente("Mario", 6, LocalDateTime.parse("2026-09-16T10:24")));
        cola.add(new Paciente("Elena", 8, LocalDateTime.parse("2026-09-16T10:25")));
        cola.add(new Paciente("Fabian", 4, LocalDateTime.parse("2026-09-16T10:26")));
        cola.add(new Paciente("Rosa", 5, LocalDateTime.parse("2026-09-16T10:27")));
        cola.add(new Paciente("Silvia", 3, LocalDateTime.parse("2026-09-16T10:29")));
        cola.add(new Paciente("Hector", 9, LocalDateTime.parse("2026-09-16T10:30")));
    }
}
