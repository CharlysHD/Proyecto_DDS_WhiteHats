package com.desarrollo.Spring5;

import com.desarrollo.Spring5.entities.*;
import com.desarrollo.Spring5.enums.*;
import com.desarrollo.Spring5.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootApplication
public class Spring5Application {

	@Autowired
	ArticuloInsumoRepository articuloInsumoRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	DetalleFacturaRepository detalleFacturaRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	DetalleProductoRepository detalleProductoRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	EmpleadoRepository empleadoRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	VentaRepository ventaRepository;
	@Autowired
	RubroRepository rubroRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	UnidadMedidaRepository unidadMedidaRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	VentaFacturaRepository ventaFacturaRepository;


	public static void main(String[] args) {
		SpringApplication.run(Spring5Application.class, args);
		System.out.println("Estoy funcionando");
	}

	@Bean
	CommandLineRunner init(RubroRepository rubroRepository, ClienteRepository clienteRepository){
		return args -> {
			System.out.println("----------------ESTOY----FUNCIONANDO---------------------");

			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");


			Usuario usuario1 = Usuario.builder()
					.username("Blue")
					.rol(Rol.CLIENTE)
					.fechaAlta(format.parse("01-01-2000"))
					.fechaModificacion(format.parse("01-01-2020"))
					.fechaBaja(format.parse("01-01-2021"))
					.build();
			Usuario usuario = Usuario.builder()
					.username("Admin")
					.rol(Rol.EMPLEADO)
					.fechaAlta(format.parse("01-01-2000"))
					.fechaModificacion(format.parse("01-01-2020"))
					.fechaBaja(format.parse("01-01-2021"))
					.build();

			Cliente cliente = Cliente.builder()
					.nombre("Pedro")
					.apellido("Simpson")
					.email("pedrito@gmail.com")
					.telefono("2614816169")
					.fechaAlta(format.parse("07-10-2021"))
					.fechaModificacion(format.parse("08-10-2021"))
					.fechaBaja(format.parse("07-11-2021"))
					.usuario(usuario1)
					.build();

			Empleado empleado = Empleado.builder()
					.rolEmpleado(RolEmpleado.CAJERO)
					.nombre("Omar")
					.apellido("Lopez")
					.email("lopezo@live.com.ar")
					.telefono("156401630")
					.fechaAlta(format.parse("07-09-2020"))
					.fechaModificacion(format.parse("07-11-2021"))
					.fechaBaja(format.parse("14-11-2023"))
					.usuario(usuario)
					.build();

			UnidadMedida unidadMedida = UnidadMedida.builder()
					.denominacion("gramos")
					.abreviatura("gr")
					.fechaAlta(format.parse("01-01-2000"))
					.fechaModificacion(format.parse("01-01-2020"))
					.fechaBaja(format.parse("01-01-2021"))
					.build();

			Producto producto = Producto.builder()
					.denominacion("Pizza Tropical")
					.descripcion("Salsa de tomate, mozzarella, kiwi y banana")
					.tiempoEstimadoCocina(60)
					.precioVenta(BigDecimal.valueOf(2000))
					.costo(BigDecimal.valueOf(1200))
					.fechaAlta(format.parse("07-11-2021"))
					.fechaBaja(format.parse("07-11-2021"))
					.fechaModificacion(format.parse("07-11-2021"))
					.urlImagen("")
					.build();
			Producto producto1 = Producto.builder()
					.denominacion("Pizza Calabresa")
					.descripcion("Salsa de tomate, mozzarella y salami suave")
					.tiempoEstimadoCocina(60)
					.precioVenta(BigDecimal.valueOf(2000))
					.costo(BigDecimal.valueOf(1200))
					.fechaAlta(format.parse("07-11-2021"))
					.fechaBaja(format.parse("07-11-2021"))
					.fechaModificacion(format.parse("07-11-2021"))
					.urlImagen("")
					.build();

			Domicilio domicilio = Domicilio.builder()
					.calle("Rivas. L")
					.codigoPostal(5511)
					.numero(174)
					.localidad("Gral. Gutierrez")
					.fechaAlta(format.parse("07-11-2021"))
					.empleado(empleado)
					.build();
			Domicilio domicilio1 = Domicilio.builder()
					.calle("Catamarca")
					.codigoPostal(5500)
					.numero(251)
					.cliente(cliente)
					.pisoDpto(1)
					.numeroDpto(21)
					.localidad("Ciudad")
					.fechaAlta(format.parse("07-11-2021"))
					.build();

			Pedido pedido1 = Pedido.builder()
					.total(BigDecimal.valueOf(99999))
					.totalCosto(BigDecimal.valueOf(999999))
					.estado(EstadoPedido.ENTREGADO)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.formaPago(FormaPago.MERCADO_PAGO)
					.fechaPedido(format.parse("14-11-2023"))
					.domicilioEntrega(domicilio1)
					.cliente(cliente)
					.build();

			Pedido pedido = Pedido.builder()
					.total(BigDecimal.valueOf(99999))
					.totalCosto(BigDecimal.valueOf(99999))
					.estado(EstadoPedido.ENTREGADO)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.formaPago(FormaPago.MERCADO_PAGO)
					.domicilioEntrega(domicilio)
					.build();

			ArticuloInsumo articuloInsumo = ArticuloInsumo.builder()
					.denominacion("Queso")
					.urlImagen("https://www.lacasadelqueso.com.ar/wp-content/uploads/2017/08/queso-mozzarella.jpg")
					.receta("recetaCompletar")
					.stockActual(BigDecimal.valueOf(100))
					.stockMinimo(BigDecimal.valueOf(1))
					.precioCompra(BigDecimal.valueOf(230))
					.fechaAlta(format.parse("07-01-2000"))
					.unidadMedida(unidadMedida)
					.build();
			ArticuloInsumo articuloInsumo1 = ArticuloInsumo.builder()
					.denominacion("Azucar")
					.urlImagen("https://empresasiansa.cl/wp-content/uploads/2020/02/azucar.jpg")
					.receta("recetaCompletar")
					.stockActual(BigDecimal.valueOf(100))
					.stockMinimo(BigDecimal.valueOf(1))
					.precioCompra(BigDecimal.valueOf(230))
					.fechaAlta(format.parse("07-01-2000"))
					.fechaModificacion(format.parse("07-03-2000"))
					.fechaBaja(format.parse("07-09-2000"))
					.build();

			Factura factura = Factura.builder()
					.formaPago(FormaPago.EFECTIVO)
					.fechaFacturacion(format.parse("09-08-1995"))
					.fechaAlta(format.parse("09-08-1995"))
					.fechaModificacion(format.parse("10-09-2023"))
					.fechaBaja(format.parse("10-10-2023"))
					.totalVenta(BigDecimal.valueOf(2300))
					.pedido(pedido1)
					.build();
			Factura factura1 = Factura.builder()
					.formaPago(FormaPago.MERCADO_PAGO)
					.fechaAlta(format.parse("14-11-2023"))
					.fechaFacturacion(format.parse("14-11-2023"))
					.pedido(pedido)
					.build();

			DetalleProducto detalleProducto = DetalleProducto.builder()
					.rating(Rating.ARTICULO_RATING)
					.receta("recetaCompletan")
					.cantidad(BigDecimal.valueOf(10))
					.producto(producto1)
					.build();
			DetalleProducto detalleProducto1 = DetalleProducto.builder()
					.rating(Rating.ARTICULO_RATING)
					.receta("recetaCompletan")
					.cantidad(BigDecimal.valueOf(10))
					.producto(producto)
					.build();

			VentaFactura ventaFactura = VentaFactura.builder()
					.cantidadVentaFactura(10)
					.fechaDesde(format.parse("01-01-2021"))
					.fechaHasta(format.parse("01-01-2021"))
					.factura(factura)
					.build();
			VentaFactura ventaFactura1 = VentaFactura.builder()
					.cantidadVentaFactura(10)
					.fechaDesde(format.parse("01-01-2021"))
					.fechaHasta(format.parse("01-01-2021"))
					.factura(factura1)
					.build();

			Venta venta = Venta.builder()
					.codVenta(24)
					.importeTotal(2300)
					//.ventaFacturas(ventaFactura)
					.ventaFacturas(List.of(ventaFactura, ventaFactura1))
					.build();

			Rubro rubro = Rubro.builder()
					.denominacion("Pizza")
					.fechaAlta(format.parse("07-01-2000"))
					//.articuloInsumos(articuloInsumo)
					//.detalleProductos(detalleProducto)
					.articuloInsumos(List.of(articuloInsumo, articuloInsumo1))
					.detalleProductos(List.of(detalleProducto, detalleProducto1))
					.build();
			Rubro rubro1 = Rubro.builder()
					.denominacion("Batidos")
					.fechaAlta(format.parse("01-01-2000"))
					.fechaBaja(format.parse("07-11-2023"))
					.build();

			DetalleFactura detalleFactura = DetalleFactura.builder()
					.subtotal(BigDecimal.valueOf(2300))
					.cantidad(10)
					.factura(factura)
					.factura(factura1)
					.rubro(rubro)
					.producto(producto)
					.build();

			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(BigDecimal.valueOf(4000))
					.subtotalCosto(BigDecimal.valueOf(2000))
					.pedido(pedido)
					.producto(producto)
					.rubro(rubro1)
					.build();
			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(BigDecimal.valueOf(2200))
					.subtotalCosto(BigDecimal.valueOf(99999))
					.build();

// Primero, guarda las entidades que no tienen dependencias
			unidadMedidaRepository.save(unidadMedida);
			usuarioRepository.save(usuario);
			usuarioRepository.save(usuario1);

// Luego, guarda las entidades que dependen de unidadesMedida, usuario y usuario1
			productoRepository.save(producto);
			productoRepository.save(producto1);
			rubroRepository.save(rubro1);
			rubroRepository.save(rubro);
			clienteRepository.save(cliente);

			empleadoRepository.save(empleado);
			domicilioRepository.save(domicilio);
			domicilioRepository.save(domicilio1);

			//le agregue esto
			pedidoRepository.save(pedido1);
			pedidoRepository.save(pedido);
			detallePedidoRepository.save(detallePedido1);
			detallePedidoRepository.save(detallePedido2);
			facturaRepository.save(factura);
			facturaRepository.save(factura1);
			ventaRepository.save(venta);
			ventaFacturaRepository.save(ventaFactura);
			detalleFacturaRepository.save(detalleFactura);
			detalleProductoRepository.save(detalleProducto);
			articuloInsumoRepository.save(articuloInsumo);
			articuloInsumoRepository.save(articuloInsumo1);

		};
	}
}
