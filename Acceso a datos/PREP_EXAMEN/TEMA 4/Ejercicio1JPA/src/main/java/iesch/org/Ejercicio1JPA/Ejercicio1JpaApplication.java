package iesch.org.Ejercicio1JPA;

import iesch.org.Ejercicio1JPA.modelo.Categoria;
import iesch.org.Ejercicio1JPA.modelo.Libro;
import iesch.org.Ejercicio1JPA.repositorio.CategoriaRepositorio;
import iesch.org.Ejercicio1JPA.repositorio.LibroRepositorio;
import iesch.org.Ejercicio1JPA.servicio.BiblioteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Ejercicio1JpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio1JpaApplication.class, args);
	}


    @Autowired
    BiblioteService service = new BiblioteService();

    @Autowired
    CategoriaRepositorio categoriaRepositorio;

    @Autowired
    LibroRepositorio libroRepositorio;

    @Override
    public void run(String... args) {
        Categoria cat1 = Categoria.builder().nombre("Acción").build();
        Libro libro1 = Libro.builder().autor("Lozano").titulo("Madurando").categoria(cat1).build();



        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("\nBIBLIOTECA: 1 Crear categoría | 2 Crear libro | 3 Listar | 4 Cambiar categoría | 5 Borrar libro | 6 Borrar categoría | 0 Salir");
            String opcion = in.nextLine().trim();
            if (opcion.equals("0")) return;
            try {
                switch (opcion) {
                    case "1" -> { System.out.print("Nombre: "); service.crearCategoria(in.nextLine()); }

                    case "2" -> {
                        System.out.print("Título: "); String titulo = in.nextLine();
                        System.out.print("Autor: "); String autor = in.nextLine();
                        System.out.print("Id de categoría: "); service.crearLibro(titulo, autor, Long.parseLong(in.nextLine()));
                    }

                    case "3" -> {
                        System.out.print("Id de categoría (vacío = todos): "); String id = in.nextLine().trim();
                        if (id.isEmpty()) service.listarCategorias().forEach(c -> System.out.printf("Categoría %d: %s%n", c.getId(), c.getNombre()));
                        service.listarLibros(id.isEmpty() ? null : Long.parseLong(id)).forEach(l -> System.out.printf(
                                "Libro %d: %s — %s [categoría %d: %s]%n", l.getId(), l.getTitulo(), l.getAutor(),
                                l.getCategoria().getId(), l.getCategoria().getNombre()));
                    }

                    case "4" -> { System.out.print("Id libro: "); Long libro = Long.parseLong(in.nextLine()); System.out.print("Id nueva categoría: "); service.cambiarCategoria(libro, Long.parseLong(in.nextLine())); }
                    case "5" -> { System.out.print("Id libro: "); service.borrarLibro(Long.parseLong(in.nextLine())); }
                    case "6" -> { System.out.print("Id categoría: "); service.borrarCategoria(Long.parseLong(in.nextLine())); }
                    default -> System.out.println("Opción no válida.");
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("No se pudo completar la operación: " + e.getMessage());
            }
        }
    }
}
