package iesch.org.Ejercicio1JPA.repositorio;

import iesch.org.Ejercicio1JPA.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro,Long> {
    List<Libro> findByCategoriaId(long categoriaId);

}
