package Ejercicio8_Canciones;

import java.util.*;
import java.util.stream.Collectors;

public class main {
    static void main(String[] args) {
        List<Cancion> canciones = new ArrayList<>(
                Arrays.asList(
                        new Cancion("Livin' on Prayer", "Bon Jovi"),
                        new Cancion("Long Hot Summer", "Keith Urban"),
                        new Cancion("It's my Life", "Bon Jovi"),
                        new Cancion("Dolor Fantasma", "Amadeus"),
                        new Cancion("Run To You", "Bryan Adams"),
                        new Cancion("Summer of 69", "Bryna Adams"),
                        new Cancion("Paranoid", "Black Sabbath"),
                        new Cancion("Cherokee", "Europe"),
                        new Cancion("River Bank", "Brad Paisley")
                ));

        System.out.println("-- BUCLE --");
        for (Cancion c : canciones){
            if (c.getCantante().equals("Bon Jovi")){
                System.out.println(c);
            }
        }

        System.out.println("-- FUNCIONAL --");
        canciones.stream().filter(cancion -> cancion.getCantante().equals("Bon Jovi")).forEach(System.out::println);


        System.out.println("-- FUNCIONAL GUARDANDO EN LISTA");
        List<Cancion> deBonJovi = canciones.stream().filter(c->c.cantante.equals("Bon Jovi")).toList();
        System.out.println(deBonJovi);

        System.out.println("-- CONTAR CANCIONES --");
        long n = canciones.stream().filter(c-> c.cantante.equals("Bon Jovi")).count();
        System.out.println("Hay "+ n + " canciones cantadas por Bon Jovi");

        System.out.println("-- AGRUPAR POR CANTANTE Y NUMERO CANCIONES");
        Map<String, Long> porCantante = canciones.stream().collect(Collectors.groupingBy(Cancion::getCantante, Collectors.counting()));
        System.out.println(porCantante);

        System.out.println("-- SIN DUPLICADOS");
        canciones.add(new Cancion("Summer of 69", "Bryna Adams"));

        canciones.stream().distinct().forEach(System.out::println);

    }
}
