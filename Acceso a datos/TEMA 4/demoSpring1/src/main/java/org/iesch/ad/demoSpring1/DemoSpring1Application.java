package org.iesch.ad.demoSpring1;

import org.iesch.ad.demoSpring1.modelo.Coche;
import org.iesch.ad.demoSpring1.modelo.Persona;
import org.iesch.ad.demoSpring1.repositorio.CocheRepositorio;
import org.iesch.ad.demoSpring1.repositorio.OrdenRepositorio;
import org.iesch.ad.demoSpring1.repositorio.PersonaRepositorio;
import org.iesch.ad.demoSpring1.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.util.Optional;

@SpringBootApplication
//@RequiredArgsConstructor
@PropertySource(value = "classpath:mi.properties", encoding = "UTF-8")
public class DemoSpring1Application implements CommandLineRunner {

	//@Autowired
	//List<Persona> listaPersona;

	/*
	PersonaRepositorio personaRepositorio;

	public DemoSpring1Application(PersonaRepositorio personaRepositorio) {
		this.personaRepositorio = personaRepositorio;
	}
	*/
	@Autowired
	PersonaRepositorio personaRepositorio;

	@Autowired
	CocheRepositorio cocheRepositorio;

	@Autowired
	ClienteRepositorio clienteRepositorio;

	@Autowired
	OrdenRepositorio ordenRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(DemoSpring1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola mundo");
		/*
		Persona p = Persona.builder().nombre("Borja").apellidos("Ros Perez").email("brosp@iesch.org").dni("18459985R").build();
		Persona p1 = Persona.builder().nombre("Antonio").apellidos("Perales Arenere").email("aperalesa@iesch.org").dni("18459986R").build();
		Persona p2 = Persona.builder().nombre("Laura").apellidos("Toran Iranzo").email("ltorani@iesch.org").dni("18459987R").build();
		Persona p3 = Persona.builder().nombre("Jaime").apellidos("Perez Monforte").email("jperezm@iesch.org").dni("18459988R").build();



		List<Persona> personaList = new ArrayList<>(Arrays.asList(p1,p2,p3));
		personaRepositorio.saveAll(personaList);
		*/

//		Persona p = new Persona();
//		p.setNombre("Juanjo");
//		p.setApellidos("Zuñiga Anton");
//		personaRepositorio.save(p);
//
//		//CRUD
//		//READ
//		List<Persona> personaList1 = personaRepositorio.findAll();
//		System.out.println(personaList1);

		// select * from _____ where id=4
		//UPDATE
		/*
			Optional<Persona> personaEncontradaPorID = personaRepositorio.findById(2L);
			if (personaEncontradaPorID.isPresent()){
				System.out.println(personaEncontradaPorID.get());
				personaEncontradaPorID.get().setNombre("Tontoni");
				personaEncontradaPorID.get().setApellidos("Perez Castro");
				personaEncontradaPorID.get().setDni("99999999R");
				personaEncontradaPorID.get().setEmail("toni@aa.es");

				personaRepositorio.save(personaEncontradaPorID.get());
			}else{
				System.out.println("Persona no encontrada");
			}

			List<Persona> personaList2 = personaRepositorio.findAll();
			System.out.println(personaList2);
		 */


		//DELETE
		/*
			Optional<Persona> personaABorrar = personaRepositorio.findById(8L);
			if (personaABorrar.isPresent()){
				personaRepositorio.delete(personaABorrar.get());
			}

			Persona personatmp = new Persona();
			personatmp.setId(3L);
			personaRepositorio.delete(personatmp);
		 */

		//HQL
		/*
			List<Persona> listaPersonas = personaRepositorio.buscaTodasPersonas();
			System.out.println(listaPersonas);
		 */

		//NATIVO
		/*
			List<Persona> listaPersonas2 = personaRepositorio.buscaTodasPersonasNat();
			System.out.println(listaPersonas2);
		 */

		/*
			System.out.println("PSEUDO-LENGUAJE");
			//Buscamos las personas que empiezan por la letra J
			List<Persona> personaListComienzaPorLetra = personaRepositorio.findByNombreStartingWith('J');
			System.out.println(personaListComienzaPorLetra);

			//Buscamos las personas cuyo letra del DNI sea A y el apellido contenga la R
			List<Persona> personaDniLetraApellidoContieneLetra = personaRepositorio.findByDniContainingAndApellidosContaining('a',"r");
			System.out.println(personaDniLetraApellidoContieneLetra);

			//Buscamos DNI con un 9 o email null
			List<Persona> personaDni9EmailNulo = personaRepositorio.findByDniContainingOrEmailNull("9");
			System.out.println(personaDni9EmailNulo);
		*/

		System.out.println("ONE TO ONE");
		//Nueva persona
//		Persona persona = new Persona();
//		persona.setNombre("Pepelu");
//		persona.setApellidos("Corre Maratones");
//		persona.setDni("18466985R");
//		persona.setEmail("pepelu@aa.es");
//
//		Coche coche = new Coche();
//		coche.setMarca("Mercedes");
//		coche.setModelo("GLC COUPE");
//		coche.setMatricula("9780KKL");
//
//		persona.setCoche(coche);
//
//		//Guardamos en BBDD
//		personaRepositorio.save(persona);


		/*
			Optional<Persona> persona = personaRepositorio.findById(14L);
			if (persona.isPresent()){
				Persona p = persona.get();
				System.out.println(p);
			}else {
				System.out.println("No hay ninguna persona");
			}

			Optional<Coche> coche = cocheRepositorio.findById(1L);
			if (coche.isPresent()){
				Coche c = coche.get();
				System.out.println(c);
			}else {
				System.out.println("No hay ninguna coche");
			}
		 */

		System.out.println("OneToOne Bidireccional");

		/*
			Persona persona = new Persona();
			persona.setDni("18779900G");
			persona.setNombre("Pepito");
			persona.setApellidos("Perez Sanchez");
			persona.setEmail("pepitops@gmail.com");

			//personaRepositorio.save(persona);

			Coche coche = new Coche();
			coche.setMatricula("9988 NTP");

			//cocheRepositorio.save(coche);
			persona.setCoche(coche);
			coche.setPersona(persona);

			personaRepositorio.save(persona);
		 */

		System.out.println("Peta Bidireccional");
		Optional<Persona> persona = personaRepositorio.findById(15L);
		if (persona.isPresent()){
			Persona persona1 = persona.get();
			System.out.println(persona1);
		}

		Optional<Coche> coche = cocheRepositorio.findById(2L);
		if (coche.isPresent()){
			Coche coche1 = coche.get();
			System.out.println(coche1);
		}







	}

}
