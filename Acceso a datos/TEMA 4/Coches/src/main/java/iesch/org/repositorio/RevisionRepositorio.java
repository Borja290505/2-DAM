package iesch.org.repositorio;

import iesch.org.modelo.Revision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevisionRepositorio extends JpaRepository<Revision,String> {
}
