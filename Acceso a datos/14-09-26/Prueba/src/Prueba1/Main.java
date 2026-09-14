package Prueba1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static void main(String[] args) {
        Contendor<String> stringContendor = new Contendor<>("Hola mundo");
        Contendor<Integer> integerContendor = new Contendor<>(110);
        imprimir(stringContendor);
        imprimir(integerContendor);
        imprimirConMultiplicador(integerContendor,50);
        imprimirDoble(integerContendor);

        List<String> miLista = new ArrayList<>(Arrays.asList("Coche", "Casa","Bebe","Antonio"));
        System.out.print(miLista.stream().sorted().toList());

        System.out.println();

        List<Coche> miListaCoche = new ArrayList<>();

        Coche coche1 = new Coche("9780KKL", "242rf3wr423r23r2r3", "Borja", 150);
        Coche coche2 = new Coche("48155KKL", "242r242f3w523r2r3", "Antonio", 880);

        miListaCoche.addAll(Arrays.asList(coche1,coche2));
        System.out.println(miListaCoche.stream().sorted());
    }

    public static void imprimir(Contendor<?> c){
        System.out.println(c.getObjecto());
    }

    public static void imprimirConMultiplicador(Contendor<? extends Number> c, int multiplicador){
        System.out.println(c.getObjecto().intValue() * multiplicador);
    }

    public static void imprimirDoble(Contendor<? extends Number> c){
        System.out.println(c.getObjecto().intValue() * 2);
    }


}