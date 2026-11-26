package iesch.org.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nif;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String telefono;

    //Apunta al campo cliente de la clase coche
    //Un coche solo tiene un unico dueño, pero un dueño puede tener varios coches a su nombre
    @OneToMany(mappedBy = "cliente")
    private List<Coche> coches;

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", coches=" + coches +
                '}';
    }
}
