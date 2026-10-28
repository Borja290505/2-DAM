package org.iesch.ad.demoSpring1.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;

    @OneToMany(mappedBy = "cliente")
//            @JoinColumn(name = "order_id")
    List<Orden> listaOrdenes;
}
