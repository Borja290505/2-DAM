package org.iesch.bloque1_Ej4.HabitacionRepositorio;

import org.iesch.bloque1_Ej4.modelos.Habitacion;
import org.iesch.bloque1_Ej4.modelos.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepositorio extends JpaRepository<Reserva,Long> {
    List<Reserva> findByHabitacion_Id(Long id);
    List<Reserva> findByFechaEntradaBetween(LocalDate e1, LocalDate e2);
}
