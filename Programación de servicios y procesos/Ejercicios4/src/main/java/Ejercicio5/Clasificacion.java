package Ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class Clasificacion {
    private final List<String> llegadas = new ArrayList<>();
    private int ultimaPosicion = 0;


    public synchronized int registrarLlegada(String corredor) {
        int posicion = ultimaPosicion + 1;
        llegadas.add(corredor);
        ultimaPosicion = posicion;
        return posicion;
    }

    public synchronized List<String> getLlegadas() {
        return new ArrayList<>(llegadas);
    }
}