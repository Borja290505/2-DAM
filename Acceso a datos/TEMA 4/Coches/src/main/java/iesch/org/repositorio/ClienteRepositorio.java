package iesch.org.repositorio;

import iesch.org.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ClienteRepositorio extends JpaRepository<ClienteRepositorio,Long> {

    List<Cliente> findDistincByCochesColorIgnoreCase(String color);
    List<Cliente> findDistincByCochesPrecioGreaterThan(BigDecimal precio);

    @Query("SELECT c FROM  Cliente c ORDER BY SIZE(c.coches) DESC LIMIT 1")
    Cliente clienteConMasCoches();
}
