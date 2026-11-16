package org.iesch.bloque1_Ej4;

import org.iesch.bloque1_Ej4.HabitacionRepositorio.HabitacionRepositorio;
import org.iesch.bloque1_Ej4.HabitacionRepositorio.ReservaRepositorio;
import org.iesch.bloque1_Ej4.modelos.Habitacion;
import org.iesch.bloque1_Ej4.modelos.Reserva;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Bloque1Ej4Application implements CommandLineRunner {

	private final HabitacionRepositorio habitacionRepositorio;
	private final ReservaRepositorio reservaRepositorio;

    public Bloque1Ej4Application(HabitacionRepositorio habitacionRepositorio, ReservaRepositorio reservaRepositorio) {
        this.habitacionRepositorio = habitacionRepositorio;
        this.reservaRepositorio = reservaRepositorio;
    }

    public static void main(String[] args) {
		SpringApplication.run(Bloque1Ej4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
			reservaRepositorio.deleteAll();
			habitacionRepositorio.deleteAll();


			//Metemos las habitaciones
			Habitacion h101 = new Habitacion();
			h101.setNumero(101);
			h101.setTipo("Doble");

			Habitacion h102 = new Habitacion();
			h102.setNumero(102);
			h102.setTipo("Suite");

			//Guardamos
			habitacionRepositorio.saveAll(Arrays.asList(h101,h102));

			//Misma reserva para la misma habitacion
			Reserva r1 = new Reserva();
			r1.setHabitacion(h101);
			r1.setFechaEntrada(LocalDate.of(2026,12,01));
			r1.setFechaSalida(LocalDate.of(2026,12,05));

			Reserva r2 = new Reserva();
			r2.setHabitacion(h101);
			r2.setFechaEntrada(LocalDate.of(2026,12,20));
			r2.setFechaSalida(LocalDate.of(2026,12,24));

			Reserva r3 = new Reserva();
			r3.setHabitacion(h101);
			r3.setFechaEntrada(LocalDate.of(2027,1,10));
			r3.setFechaSalida(LocalDate.of(2027,11,15));

			Reserva r4 = new Reserva();
			r4.setHabitacion(h102);
			r4.setFechaEntrada(LocalDate.of(2026,1,10));
			r4.setFechaSalida(LocalDate.of(2026,11,15));

			reservaRepositorio.saveAll(Arrays.asList(r1,r2,r3,r4));
		 */

		Optional<Habitacion> habitacionTmp = habitacionRepositorio.findByNumero(101);
		if (habitacionTmp.isPresent()){
			Habitacion habitacion = habitacionTmp.get();
			System.out.println(habitacion);

			Long idHabitacion = habitacion.getId();
			List<Reserva> reservaList = reservaRepositorio.findByHabitacion_Id(idHabitacion);
			System.out.println(reservaList);
		}

		System.out.println("Fecha de entrada en diciembre");
		List<Reserva> reservaList = reservaRepositorio.findByFechaEntradaBetween(LocalDate.of(2026,12,01),LocalDate.of(2026,12,31));
		System.out.println(reservaList       );



	}
}
