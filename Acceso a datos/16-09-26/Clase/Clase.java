package Clase;

import java.util.Arrays;
import java.util.List;

public class Clase {
    static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        /*
        Primero filtro los numeros que son pares con el filter
        Para elevar al cuadrado hacemos un map
        Luego lo metemos todo en una lista
         */

        List<Integer> cuadradoPares = numbers.stream().filter(n -> n % 2 == 0).map(n -> n*n).toList();

        System.out.println(cuadradoPares);


        List<Integer> numbers2 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //Va ha devolver false porque no todos los numeros cumplen el predicado
        System.out.println(numbers2.stream().allMatch(n -> n % 2 == 0));

        //Va ha devolver true porque hay un numero que si que cumple el predicado
        System.out.println(numbers2.stream().anyMatch(n -> n % 2 == 0));
    }
}
