package Ejercicio_PriorityQueue;

import java.time.LocalDateTime;
import java.util.PriorityQueue;

public class Main {
    static void main(String[] args) {
        PriorityQueue<Paciente> cola = new PriorityQueue<>(new Comparacion());
        cola.add(new Paciente("Ana",5, LocalDateTime.parse("2026-09-16T10:01")));
        cola.add(new Paciente("Juan",9, LocalDateTime.parse("2026-09-16T10:02")));
        cola.add(new Paciente("Luis",6, LocalDateTime.parse("2026-09-16T10:01")));
        cola.add(new Paciente("Borja",10, LocalDateTime.parse("2026-09-16T11:01")));

        System.out.println(cola);
        while (!cola.isEmpty()){
            System.out.println(cola.poll());
        }
    }
}
