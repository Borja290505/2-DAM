package ORG.IESCH.AD.demoCarga.repositorio;

import ORG.IESCH.AD.demoCarga.modelo.Cliente;
import ORG.IESCH.AD.demoCarga.modelo.DireccionEnvio;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DireccionEnvioRepositorio extends JpaRepository<DireccionEnvio,Long> {
}
