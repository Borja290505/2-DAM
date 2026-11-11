package iesch.org.Bloque1_Ej1;

import iesch.org.Bloque1_Ej1.Modelo.Perfil;
import iesch.org.Bloque1_Ej1.Modelo.Usuario;
import iesch.org.Bloque1_Ej1.Reposotorio.PerfilRepositorio;
import iesch.org.Bloque1_Ej1.Reposotorio.UsuarioRepositorio;
import iesch.org.Bloque1_Ej1.Servicios.Usuario_servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class Bloque1Ej1Application implements CommandLineRunner {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    PerfilRepositorio perfilRepositorio;

    @Autowired
    Usuario_servicio usuarioServicio;

    public static void main(String[] args) {
        SpringApplication.run(Bloque1Ej1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-".repeat(30));

        //Creamos el perfil
        /*
            Perfil perfil = new Perfil();
            perfil.setFotoPerfil("/img/juan.jpg");
            perfil.setDescripcion("Estudiante de SMR 2");
            perfil.setFechaNacimiento(LocalDate.of(2005,05,29));


            //Creamos el usuario
            Usuario usuario = new Usuario();
            usuario.setNombre("Juan");
            usuario.setPassword("QWERTY");


            usuario.setPerfil(perfil);
            //perfil.setUsuario(usuario);
            usuarioRepositorio.save(usuario);

            Optional<Usuario> user = usuarioRepositorio.findById(1L);

            if (user.isPresent()){
                Usuario usuario = user.get();
                System.out.println(usuario);

                usuarioServicio.cambiarPerfil(usuario);
            }

         */
        System.out.println("Borrar usuario");
        /*
            Optional<Usuario> userTmp = usuarioRepositorio.findById(2L);
            if (userTmp.isPresent()){
                Usuario usuario = userTmp.get();
                usuarioRepositorio.delete(usuario);
            }
         */
    }
}