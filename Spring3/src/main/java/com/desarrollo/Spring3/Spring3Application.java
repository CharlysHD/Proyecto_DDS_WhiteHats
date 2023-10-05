package com.desarrollo.Spring3;


import com.desarrollo.Spring3.entities.*;
import com.desarrollo.Spring3.enums.*;
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
public class Spring3Application {

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

			//Configuracion fecha
			SimpleDateFormat formatoFecha = new SimpleDateFormat ("yyyy-MM-dd");
			String fechaString = "2023-10-04";
			//Parsear la cadena en un objeto Date
			Date fecha = formatoFecha.parse(fechaString);

			//Creamos instancias de detalle factura
			DetalleFactura detalleFactura1 = DetalleFactura.builder()
					.cantidad(3)
					.subtotal(BigDecimal.valueOf(3678.50))
					.build();

			//Creamos instancias de rubro
			Rubro rubro1 = Rubro.builder()
					.denominacion("Hamburguesas")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();
			Rubro rubro2 = Rubro.builder()
					.denominacion("Pizzas")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();

			//Creamos instancias de ArticuloInsumo
			ArticuloInsumo articuloInsumo1 = ArticuloInsumo.builder()
					.denominacion("Condimentos")
					.precioCompra(BigDecimal.valueOf(99.00))
					.stockActual(BigDecimal.valueOf(15))
					.stockMinimo(BigDecimal.valueOf(5))
					.urlImagen("https://mejorconsalud.as.com/wp-content/uploads/2020/09/condimentos.jpg")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();
			ArticuloInsumo articuloInsumo2 = ArticuloInsumo.builder()
					.denominacion("Panes")
					.precioCompra(BigDecimal.valueOf(35.99))
					.stockActual(BigDecimal.valueOf(39))
					.stockMinimo(BigDecimal.valueOf(20))
					.urlImagen("https://www.lamardecookies.com/wp-content/uploads/2016/08/pan-de-hamburguesa-sin-gluten-y-sin-lactosa.jpg")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();

			//Creamos instancias de Producto
			Producto producto1 = Producto.builder()
					.costo(BigDecimal.valueOf(100))
					.denominacion("Hamburguesa con cheddar")
					.descripcion("Con mucho cheddar")
					.precioVenta(BigDecimal.valueOf(350))
					.tiempoEstimadoCocina(45)
					.urlImagen("https://noticiasmercedinas.com/site/wp-content/uploads/2021/04/MOSTAZA_-MEGA-BOOM_1-1024x671.jpg")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();

			//Creamos instancias de detalleProducto
			DetalleProducto detalleProducto1 = DetalleProducto.builder()
					.cantidad(BigDecimal.valueOf(3))
					.ratingInsumo(Rating.ARTICULO_RATING)
					.receta("Pan, carne y cheddar")
					.build();

			//Agregar productos al detalle
			//Agregar detalles al rubro
			rubro1.agregarDetalleProducto(detalleProducto1);
			//Agregar articulos al rubro
			rubro1.agregarArticulos(articuloInsumo2);
			rubro1.agregarArticulos(articuloInsumo1);
			rubro2.agregarArticulos(articuloInsumo1);
			//Agregar rubro al detalle factura




		};
	}
}
