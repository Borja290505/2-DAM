package ORG.IESCH.AD.demoCarga.modelo;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private String estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_envio_id", nullable = false, unique = true)
    private DireccionEnvio direccionEnvio;
}
