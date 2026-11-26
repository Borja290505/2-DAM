package org.iesch.demoSpringDataMongoProductos;

import lombok.RequiredArgsConstructor;
import org.iesch.demoSpringDataMongoProductos.modelos.Producto;
import org.iesch.demoSpringDataMongoProductos.repositorio.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoSpringDataMongoProductosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringDataMongoProductosApplication.class, args);
	}

	private final ProductoRepository productoRepository;

	@Override
	public void run(String... args) throws Exception {
		/*Producto producto = Producto.builder().sku("BY1258XCAy")
			.nombre("Coche juguete").categoria("Juguetes").precio(15.99).stock(12).build();
		productoRepository.save(producto);
		*/

		/*
		List<Producto> productoList = productoRepository.findAll();
		System.out.println(productoList);
		 */

		//Update
		Producto producto = productoRepository.findById("6b0727c0f59f202771b06567").get();
		System.out.println(producto);
		productoRepository.deleteById("6b0727c0f59f202771b06567");

	}

}
