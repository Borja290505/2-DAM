package org.iesch.ad.demoSpring1.repositorio;

import org.iesch.ad.demoSpring1.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoReporsitorio extends JpaRepository<Curso,Long> {
}
