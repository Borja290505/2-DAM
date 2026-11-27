package iesch.org.Ejercicio1JPA.repositorio;

import iesch.org.Ejercicio1JPA.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria,Long> {
}
