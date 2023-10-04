package com.desarrollo.Spring3;

import com.desarrollo.Spring3.entities.Cliente;
import com.desarrollo.Spring3.repositories.DetalleFacturaRepository;
import com.desarrollo.Spring3.repositories.DetallePedidoRepository;
import com.desarrollo.Spring3.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
pSpring3Application {

	@Autowired
	DetalleFacturaRepository detalleFacturaRepository;

	@Autowired
	DetallePedidoRepository detallePedidoRepository;

	@Autowired
	VentaRepository ventaRepository;

	public static void main(String[] args) {

		SpringApplication.run(Spring3Application.class, args);
		System.out.println("Estoy funcionando");
	}

	@Bean
	CommandLineRunner init(DetallePedidoRepository detallePedidoRepository1, DetalleFacturaRepository detalleFacturaRepository1, VentaRepository ventaRepository1) {
		return args -> {
			System.out.println("<-------Estoy funcionando------->");


		};
	}
}
