package org.iesch.ad.demoSpring1.modelo;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.jdbc.Size;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
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
    private LocalDateTime createAt;

    @OneToOne(cascade = CascadeType.ALL)
    Coche coche;

    @PrePersist
    public void preGuardar(){
        this.createAt = LocalDateTime.now();
    }

    @PostPersist
    public void postGuardar(){
        System.out.println("Se guarda la persona con id:" + this.id);
    }
}
