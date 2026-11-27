package iesch.org.BibliotecaDigital.repositorio;

import iesch.org.BibliotecaDigital.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {
}
