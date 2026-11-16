package ORG.IESCH.AD.demoCarga;

import ORG.IESCH.AD.demoCarga.modelo.DireccionEnvio;
import ORG.IESCH.AD.demoCarga.modelo.Pedido;
import ORG.IESCH.AD.demoCarga.repositorio.PedidoRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class DemoCargaApplication implements CommandLineRunner {

	private final PedidoRepositorio pedidoRepositorio;

	public DemoCargaApplication(PedidoRepositorio pedidoRepositorio) {
		this.pedidoRepositorio = pedidoRepositorio;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoCargaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 1. Crear dirección y pedido
		DireccionEnvio direccion = new DireccionEnvio();
		direccion.setCalle("Calle Mayor, 12");
		direccion.setCiudad("Teruel");
		direccion.setPais("España");
		direccion.setCodigoPostal("44001");

		Pedido pedido = new Pedido();
		pedido.setFecha(LocalDate.now());
		pedido.setEstado("PENDIENTE");
		pedido.setDireccionEnvio(direccion);

		// 2. Guardar en BD (CascadeType.ALL guarda también la dirección)
		Pedido pedidoGuardado = pedidoRepositorio.save(pedido);

		// 3. Consultar el pedido y acceder a su dirección de envío
		Pedido pedidoConsultado = pedidoRepositorio.findById(pedidoGuardado.getId()).orElseThrow();
		System.out.println("Pedido ID: " + pedidoConsultado.getId() + " - Estado: " + pedidoConsultado.getEstado());
		System.out.println("Dirección de envío: " + pedidoConsultado.getDireccionEnvio().getCalle() + ", " + pedidoConsultado.getDireccionEnvio().getCiudad());
	}
}
