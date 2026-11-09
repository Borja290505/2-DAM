package ORG.IESCH.AD.demoCarga;

import ORG.IESCH.AD.demoCarga.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoCargaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoCargaApplication.class, args);
	}

	@Autowired
	ClienteServicio clienteServicio;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Datos del cliente 1");
		clienteServicio.mostrarDatos(1L);

		System.out.println("Muestro todos");
		clienteServicio.mostrarTodos();

		//Arreglo N+1 consultas:
		System.out.println("\n".repeat(20));
		clienteServicio.arregloN1();



	}
}
