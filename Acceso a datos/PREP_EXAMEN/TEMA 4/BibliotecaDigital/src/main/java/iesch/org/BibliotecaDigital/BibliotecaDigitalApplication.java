package iesch.org.BibliotecaDigital;

import iesch.org.BibliotecaDigital.modelos.Perfil;
import iesch.org.BibliotecaDigital.modelos.Usuario;
import iesch.org.BibliotecaDigital.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class BibliotecaDigitalApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaDigitalApplication.class, args);
	}
    @Autowired
    public UsuarioRepositorio usuarioRepositorio;
    @Override
    public void run(String... args) throws Exception {
        Perfil perfil = new Perfil("borja.jpg", "Estudiante de DAM", LocalDate.of(2005, 3, 10));
        Usuario u = new Usuario("Borja");

        u.setPerfil(perfil);
        usuarioRepositorio.save(u);

        usuarioRepositorio.findAll().forEach(x->
                System.out.println(x.getNombre() + " -> " + x.getPerfil().getDescripcion())
        );

    }
}
