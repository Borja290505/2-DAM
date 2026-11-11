package iesch.org.Bloque1_Ej1.Servicios;

import iesch.org.Bloque1_Ej1.Modelo.Perfil;
import iesch.org.Bloque1_Ej1.Modelo.Usuario;
import iesch.org.Bloque1_Ej1.Reposotorio.UsuarioRepositorio;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class Usuario_servicio {

    private final UsuarioRepositorio usuarioRepositorio;

    public void cambiarPerfil(Usuario usuario){
        /*
            Perfil perfil = usuario.getPerfil();
            perfil.setFotoPerfil("/img/ana.jpg");
            perfil.setFechaNacimiento(LocalDate.of(2004,06,03));
            perfil.setDescripcion("Nuevo perfil DAM 1");

            usuarioRepositorio.save(usuario);
         */
        usuario.setPerfil(null);
        usuarioRepositorio.flush();

        Perfil perfil = usuario.getPerfil();
        perfil.setFotoPerfil("/img/jose.jpg");
        perfil.setFechaNacimiento(LocalDate.of(2004,06,03));
        perfil.setDescripcion("Nuevo perfil DAM 1");

        usuario.setPerfil(perfil);

        usuarioRepositorio.save(usuario);


    }
}
