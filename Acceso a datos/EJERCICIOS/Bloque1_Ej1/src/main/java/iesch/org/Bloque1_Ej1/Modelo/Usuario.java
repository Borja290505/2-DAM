package iesch.org.Bloque1_Ej1.Modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
//@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;
    String password;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Perfil perfil;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
        if (perfil!=null){
            perfil.setUsuario(this);
        }
    }
}
