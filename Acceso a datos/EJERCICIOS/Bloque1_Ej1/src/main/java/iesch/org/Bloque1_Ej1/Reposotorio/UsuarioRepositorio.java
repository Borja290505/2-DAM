package iesch.org.Bloque1_Ej1.Reposotorio;

import iesch.org.Bloque1_Ej1.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {
}
