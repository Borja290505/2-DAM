package Ejercicio3_Personas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class main {
    static void main(String[] args) {
        List<Persona> personas = new ArrayList<>(Arrays.asList(
                new Persona("Ana", 25),
                new Persona("Luis", 34),
                new Persona("Marta", 19),
                new Persona("Pedro", 42),
                new Persona("Lucía", 31),
                new Persona("Javier", 28)
        ));
        double edadMedia = personas.stream().mapToInt(Persona::getEdad).average().orElse(0);

        Persona personaMasJoven = personas.stream().min(Comparator.comparing(Persona::getEdad)).orElseThrow();

        List<String> personasMayores30 = personas.stream().filter(p-> p.getEdad() > 30).map(Persona::getNombre).toList();

        System.out.println("-- EDAD MEDIA -- ");
        System.out.println(edadMedia);
        System.out.println("-- PERSONA MAS JOVEN -- ");
        System.out.println(personaMasJoven);
        System.out.println("-- MAYORES DE 30 -- ");
        System.out.println(personasMayores30);

    }
}
