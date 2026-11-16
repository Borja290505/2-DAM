package org.iesch.bloque1_Ej4.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private int numero;
    private String tipo;

}
