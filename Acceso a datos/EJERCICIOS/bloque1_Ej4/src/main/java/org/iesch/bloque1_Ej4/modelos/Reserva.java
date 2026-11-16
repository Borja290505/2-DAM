package org.iesch.bloque1_Ej4.modelos;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;

    @ManyToOne(optional = false)
    @JoinColumn(name="habitacion_id")
    private Habitacion habitacion;
}
