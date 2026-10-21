package org.iesch.ad.demoSpring1.modelo;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.jdbc.Size;

@Getter
@Setter
//@Builder
@ToString
@EqualsAndHashCode
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;
    String apellidos;
    @Column( length = 9)
    String dni;
    String email;
}
