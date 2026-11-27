package Ejercicio_PriorityQueue;

import java.time.LocalDateTime;

public class Paciente {
    String nombre;
    int gravedad;
    LocalDateTime llegada;

    public Paciente(String nombre, int gravedad, LocalDateTime llegada) {
        this.nombre = nombre;
        this.gravedad = gravedad;
        this.llegada = llegada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGravedad() {
        return gravedad;
    }

    public void setGravedad(int gravedad) {
        this.gravedad = gravedad;
    }

    public LocalDateTime getLlegada() {
        return llegada;
    }

    public void setLlegada(LocalDateTime llegada) {
        this.llegada = llegada;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", gravedad=" + gravedad +
                ", llegada=" + llegada +
                '}';
    }
}
