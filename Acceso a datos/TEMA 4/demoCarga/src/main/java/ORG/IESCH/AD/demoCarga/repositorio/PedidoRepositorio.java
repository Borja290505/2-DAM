package ORG.IESCH.AD.demoCarga.repositorio;

import ORG.IESCH.AD.demoCarga.modelo.Cliente;
import ORG.IESCH.AD.demoCarga.modelo.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido,Long> {
}
