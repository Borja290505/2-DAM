package iesch.org.modelo;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Revision {
    @Id
    private String codigo;
    private boolean cambio_filtro;
    private boolean cambio_aceite;

    @Column(nullable = false,precision = 12,scale = 2)
    private BigDecimal coste;

    @ManyToOne(optional = false)
    @JoinColumn(name = "coche_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "")
    private Coche coche;
}
