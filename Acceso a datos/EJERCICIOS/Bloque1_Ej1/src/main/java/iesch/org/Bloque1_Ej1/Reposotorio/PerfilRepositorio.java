package iesch.org.Bloque1_Ej1.Reposotorio;

import iesch.org.Bloque1_Ej1.Modelo.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepositorio extends JpaRepository<Perfil,Long> {
}
