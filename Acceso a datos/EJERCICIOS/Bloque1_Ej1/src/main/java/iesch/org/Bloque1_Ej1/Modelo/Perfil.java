package iesch.org.Bloque1_Ej1.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String fotoPerfil;
    private String descripcion;
    private LocalDate fechaNacimiento;

    @OneToOne
    @JoinColumn(name = "usuario_id",nullable = false,unique = true)
    private Usuario usuario; // No puede existir un perfil sin un usuario relacionado

    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", fotoPerfil='" + fotoPerfil + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", usuario=" + usuario.getId() + " " + usuario.getNombre() + " " + usuario.getPassword() +
                '}';
    }
}
