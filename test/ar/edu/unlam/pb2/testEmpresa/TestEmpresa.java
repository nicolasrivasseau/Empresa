package ar.edu.unlam.pb2.testEmpresa;

import java.sql.Date;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.unlam.pb2.ejercicioEmpresa.Empresa;
import ar.edu.unlam.pb2.ejercicioEmpresa.Item;
import ar.edu.unlam.pb2.ejercicioEmpresa.Producto;
import ar.edu.unlam.pb2.ejercicioEmpresa.Servicio;
import ar.edu.unlam.pb2.ejercicioEmpresa.Vendedor;
import ar.edu.unlam.pb2.ejercicioEmpresa.Venta;

public class TestEmpresa {

	@Test
	public void crearUnaEmpresa() {
		Empresa empresaNueva = new Empresa("MiEmpresa");

		Assert.assertNotNull(empresaNueva);

	}

	@Test
	public void calcularComisionDeVendedor() {
		Date nuevaFecha = null;

		Empresa empresaNueva = new Empresa("MiEmpresa");
		empresaNueva.AgregarNuevoVendedor(400L, "Juan", "Perez", 10.0);
		Item productoNuevo = new Producto(200L, "COCACOLA", 100.0d);
		Item servicioNuevo = new Servicio(2001L, "entrega a domicilio", 50.0, 2.0);
		Venta ventaNueva = new Venta(nuevaFecha, 1000L, 10, empresaNueva.buscarVendedorEnEmpresa("Juan", "Perez"));
		ventaNueva.agregarItemALaVenta(servicioNuevo);
		ventaNueva.agregarItemALaVenta(productoNuevo);

		empresaNueva.hacerUnaVenta(ventaNueva);

		Double valorEsperado = 20.0;
		Double valorObtenido = empresaNueva.calcularComision("Juan", "Perez");

		Assert.assertEquals(valorEsperado, valorObtenido);
		
	}



	@Test
	public void calcularComisionDeVendedorPorDia() {
		Date nuevaFecha = new Date(2000L);

		Empresa empresaNueva = new Empresa("MiEmpresa");
		empresaNueva.AgregarNuevoVendedor(2000L, "Juan", "Perez", 10.0);
		Venta ventaNueva = new Venta(nuevaFecha, 1000L, 10, empresaNueva.buscarVendedorEnEmpresa("Juan", "Perez"));
		Item productoNuevo = new Producto(200L, "COCACOLA", 100.0d);
		Item servicioNuevo = new Servicio(2001L, "entrega a domicilio", 50.0, 2.0);
		ventaNueva.agregarItemALaVenta(servicioNuevo);
		ventaNueva.agregarItemALaVenta(productoNuevo);

		empresaNueva.hacerUnaVenta(ventaNueva);

		Double valorEsperado = 10.0;
		Double valorObtenido = empresaNueva.calcularComisionPorDiaPorVentaProducto(nuevaFecha, empresaNueva.buscarVendedorEnEmpresa("Juan", "Perez"));

		Assert.assertEquals(valorEsperado, valorObtenido);

	}
	
	@Test
	public void calcularPrecioDeServicio() {
		Date nuevaFecha = new Date(2000L);
		
		Empresa empresaNueva = new Empresa("MiEmpresa");
		empresaNueva.AgregarNuevoVendedor(2000L, "Juan", "Perez", 10.0);
		Venta ventaNueva = new Venta(nuevaFecha, 1000L, 10, empresaNueva.buscarVendedorEnEmpresa("Juan", "Perez"));
		Item productoNuevo = new Producto(200L, "COCACOLA", 100.0d);
		Item servicioNuevo = new Servicio(2001L, "entrega a domicilio", 50.0, 2.0);
	
		ventaNueva.agregarItemALaVenta(servicioNuevo);
		ventaNueva.agregarItemALaVenta(productoNuevo);
		empresaNueva.hacerUnaVenta(ventaNueva);
		
		Double valorEsperado = 100.0d;
		Double valorObtenido = empresaNueva.calcularPrecioServicio(2001L);
		
		Assert.assertEquals(valorEsperado, valorObtenido);
		
	}
	
	
}
