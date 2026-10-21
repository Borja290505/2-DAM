package org.iesch.ad.demoSpring1;

import lombok.RequiredArgsConstructor;
import org.iesch.ad.demoSpring1.modelo.Persona;
import org.iesch.ad.demoSpring1.repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	public static void main(String[] args) {
		SpringApplication.run(DemoSpring1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola mundo");

//		Persona p = Persona.builder().nombre("Borja").apellidos("Ros Perez").email("brosp@iesch.org").dni("18459985R").build();
//		Persona p1 = Persona.builder().nombre("Antonio").apellidos("Perales Arenere").email("aperalesa@iesch.org").dni("18459986R").build();
//		Persona p2 = Persona.builder().nombre("Laura").apellidos("Toran Iranzo").email("ltorani@iesch.org").dni("18459987R").build();
//		Persona p3 = Persona.builder().nombre("Jaime").apellidos("Perez Monforte").email("jperezm@iesch.org").dni("18459988R").build();


//		List<Persona> personaList = new ArrayList<>(Arrays.asList(p1,p2,p3));
//		personaRepositorio.saveAll(personaList);
		List<Persona> personaList1 = personaRepositorio.findAll();
		System.out.println(personaList1);
	}

}
