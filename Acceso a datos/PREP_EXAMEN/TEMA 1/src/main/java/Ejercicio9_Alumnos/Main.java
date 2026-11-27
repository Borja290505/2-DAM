package Ejercicio9_Alumnos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static void main(String[] args) {
        List<Alumno> listaAlumnos = new ArrayList<>();
        listaAlumnos.add(new Alumno(1, "1717213183", "Javier", "Molina Cano", "Java 8", 7, 28));
        listaAlumnos.add(new Alumno(2, "1717456218", "Ana", "Gómez Álvarez", "Java 8", 10, 33));
        listaAlumnos.add(new Alumno(3, "1717328901", "Pedro", "Marín López", "Java 8", 8.6, 15));
        listaAlumnos.add(new Alumno(4, "1717567128", "Emilio", "Duque Gutiérrez", "Java 8", 10, 13));
        listaAlumnos.add(new Alumno(5, "1717902145", "Alberto", "Sáenz Hurtado", "Java 8", 9.5, 15));
        listaAlumnos.add(new Alumno(6, "1717678456", "Germán", "López Fernández", "Java 8", 8, 34));
        listaAlumnos.add(new Alumno(7, "1102156732", "Oscar", "Murillo González", "Java 8", 10, 32));
        listaAlumnos.add(new Alumno(8, "1103421907", "Antonio Jesús", "Palacio Martínez", "PHP", 9.5, 17));
        listaAlumnos.add(new Alumno(9, "1717297015", "César", "González Martínez", "Java 8", 8, 26));
        listaAlumnos.add(new Alumno(10, "1717912056", "Gloria", "González Castaño", "PHP", 10, 28));
        listaAlumnos.add(new Alumno(11, "1717912058", "Jorge", "Ruiz Ruiz", "Python", 8, 22));
        listaAlumnos.add(new Alumno(12, "1717912985", "Ignacio", "Duque García", "Java Script", 9.4, 32));
        listaAlumnos.add(new Alumno(13, "1717913851", "Julio", "González Castaño", "C Sharp", 10, 22));
        listaAlumnos.add(new Alumno(14, "1717986531", "Gloria", "Rodas Carretero", "Ruby", 7, 18));
        listaAlumnos.add(new Alumno(15, "1717975232", "Jaime", "Jiménez Gómez", "Java Script", 10, 18));


        System.out.println("-- TODOS CON REFERENCIA A METODO --");
        listaAlumnos.forEach(System.out::println);

        System.out.println(" -- APELLIDO EMPIEZA POR L O G");
        listaAlumnos.stream().filter(a-> a.getApellidos().startsWith("L") || a.getApellidos().startsWith("G")).forEach(System.out::println);

        System.out.println(" -- NUMERO DE ALUMNOS --");
        long n = listaAlumnos.stream().count();
        System.out.println("Hay " + n + " alumnos");

        System.out.println(" -- ALUMNO CON NOTA >9 Y CURSO PHP --");
        listaAlumnos.stream().filter(a->a.getNota()>9 && a.getNombreCurso().equals("PHP")).forEach(System.out::println);

        System.out.println(" -- 2 PRIMEROS ALUMNOS DE LA LISTA --");
        listaAlumnos.stream().limit(2).forEach(System.out::println);

        System.out.println("-- ALUMNO CON MENOR EDAD -- ");
        listaAlumnos.stream().min(Comparator.comparing(Alumno::getEdad)).ifPresent(System.out::println);

        System.out.println("-- ALUMNO CON MAYOR EDAD -- ");
        listaAlumnos.stream().max(Comparator.comparing(Alumno::getEdad)).ifPresent(System.out::println);

        System.out.println("-- PRIMER ALUMNO --");
        listaAlumnos.stream().findFirst().ifPresent(System.out::println);

        System.out.println(" -- ALUMNO CURSO CON A --");
        listaAlumnos.stream().filter(a-> a.getNombreCurso().toLowerCase().contains("a")).forEach(System.out::println);

        System.out.println(" -- ALUMNOS CON 10 LETRAS NOBMRE -- ");
        listaAlumnos.stream().filter(a-> a.getNombre().length()> 10).forEach(System.out::println);

        System.out.println(" -- ALUMNOS CON CURSO QUE EMPIEZE POR P Y MAS CORTO QUE 6 --");
        listaAlumnos.stream().filter(a->a.getNombreCurso().startsWith("P") && a.getNombreCurso().length()<=6).forEach(System.out::println);

        System.out.println(" -- NUEVA LISTA --");
        List<Alumno> listaNueva = listaAlumnos.stream().filter(a->a.getNombreCurso().startsWith("P") && a.getNombreCurso().length()<=6).collect(Collectors.toList());
        System.out.println(listaNueva);
    }
}
