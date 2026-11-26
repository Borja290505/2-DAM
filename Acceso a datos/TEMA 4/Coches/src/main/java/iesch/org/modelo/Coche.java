package iesch.org.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Coche {
    @Id
    private String matricula;
    private String marca;
    private String modelo;
    private String color;

    @Column(precision = 12,scale = 2)
    private BigDecimal precio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id",nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "coche")
    List<Revision> revisiones;

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", precio=" + precio +
                ", cliente=" + cliente.getNombre() +
                ", revisiones=" + revisiones +
                '}';
    }
}
