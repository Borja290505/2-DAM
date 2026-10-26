package org.iesch.ad.demoSpring1.repositorio;

import jakarta.persistence.PostPersist;
import org.iesch.ad.demoSpring1.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona,Long> {

    @Query("select p from Persona p") //HQL
    List<Persona> buscaTodasPersonas();

    @NativeQuery("select * from Persona p") //Nativo
    List<Persona> buscaTodasPersonasNat();

    List<Persona> findByNombreStartingWith(char c);

    List<Persona> findByDniContainingAndApellidosContaining(char c,String j);

    List<Persona> findByDniContainingOrEmailNull(String c);

}
