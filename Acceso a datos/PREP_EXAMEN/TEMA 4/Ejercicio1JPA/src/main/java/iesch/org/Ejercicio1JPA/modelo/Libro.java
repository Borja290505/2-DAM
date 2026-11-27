package iesch.org.Ejercicio1JPA.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String autor;
    String titulo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public void setCategoria(Categoria nueva) {
        if (categoria != null){
            categoria.getLibros().remove(this);
        }

        categoria = nueva;
        if (nueva != null){
            nueva.getLibros().add(this);
        }
    }

    public long getId() {
        return id;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
