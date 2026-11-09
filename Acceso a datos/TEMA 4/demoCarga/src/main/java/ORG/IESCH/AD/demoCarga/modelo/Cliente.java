package ORG.IESCH.AD.demoCarga.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    // Al añadir cascade, los pedidos se guardarán solos al guardar el cliente
    // orphanRemoval asegura que si quitas un pedido de la lista, se borre de la BD
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cliente_id")
    private List<Pedido> pedidos;

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pedidos=" + pedidos +
                '}';
    }
}
