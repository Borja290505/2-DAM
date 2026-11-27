package iesch.org.Ejercicio1JPA.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String nombre;

    @OneToMany(mappedBy = "categoria")
    private List<Libro> libros = new ArrayList<>();

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
