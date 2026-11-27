package Ejercicio_PriorityQueue;

import java.util.Comparator;

public class Comparacion implements Comparator<Paciente> {
    @Override
    public int compare(Paciente o1, Paciente o2) {
        int r = Integer.compare(o2.getGravedad(), o1.getGravedad());
        if (r != 0){
            return r;
        }else{
            return o1.getLlegada().compareTo(o2.getLlegada());
        }
    }
}
