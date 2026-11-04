package org.iesch.ad.demoSpring1.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;

    @ToString.Exclude //Evitar stackoverflow
    @ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "cursos") //Nombre de la variable en la otra entidad
    //cascade = CascadeType.ALL Peligroso, ya que si borramos un curso,
    //se puede dar el caso q borres al padre(estudiante)
    // y tmb al resto de curso del estudiante
    //Se recomienda: CascadeType.PERSIST y MERGE
    //cON PERSIST al guardar se guardaria el padre
    //Con MERGE al actualizar se actualiza el padre

    private Set<Student> estudientes = new HashSet<>();

}
