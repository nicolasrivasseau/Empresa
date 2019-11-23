package ar.edu.unlam.pb2.ejercicioEmpresa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Empresa {

	private String nombre;
	private List<Venta> ventasDeLaEmpresa;
	private List<Vendedor> vendedoresDeLaEmpresa;

	public Empresa(String nombre) {
		this.nombre = nombre;
		ventasDeLaEmpresa = new ArrayList<Venta>();
		vendedoresDeLaEmpresa = new ArrayList<Vendedor>();
	}

	public void hacerUnaVenta(Venta ventaNueva) {

		for (Vendedor vendedor1 : vendedoresDeLaEmpresa) {
			if (ventaNueva.getVendedor().equals(vendedor1))
			ventasDeLaEmpresa.add(ventaNueva);
			ventaNueva.getVendedor().agregarVenta(ventaNueva);

		}
	}

	
   public void AgregarNuevoVendedor(Long idVendedor, String nombre, String apellido, Double porcentajeComicion) {
		Vendedor vendedorNuevo = new Vendedor(idVendedor, nombre, apellido, porcentajeComicion);
		vendedoresDeLaEmpresa.add(vendedorNuevo);
	}

	public Double calcularComision(String nombre, String apellido) {
		Double ventaTotal = 0.0d;
		Double comisionTotal = 0.0d;
		Vendedor vendedor = null;
		
		
		
		vendedor = buscarVendedor(nombre, apellido);

		for (Venta ventasDelVendedor : vendedor.getVentasDelVendedor()) {
			for (Item itemsDeLaVentas : ventasDelVendedor.getItemsVendidos()) {

				if (itemsDeLaVentas instanceof Servicio) {
					ventaTotal += calcularPrecioServicio(itemsDeLaVentas.getIdItem());
				} else if (itemsDeLaVentas instanceof Producto) {
					ventaTotal += ((Producto) itemsDeLaVentas).getPrecio();
				}
			}
		}

		comisionTotal = (ventaTotal * vendedor.getPorcentajeComicion()) / 100;
		return comisionTotal;
	}

	private Vendedor buscarVendedor(String nombre, String apellido) {
		Vendedor vendedorBuscado = null;
		for (Venta ventas : ventasDeLaEmpresa) {
			if (ventas.getVendedor().getNombre().equals(nombre)
					&& ventas.getVendedor().getApellido().equals(apellido)) {
				vendedorBuscado = ventas.getVendedor();
			}
		}
		return vendedorBuscado;
	}
	
	public Vendedor buscarVendedorEnEmpresa(String nombre, String apellido) {
		Vendedor vendedorBuscado = null;
		for (Vendedor registroVendedor : vendedoresDeLaEmpresa) {
			if (registroVendedor.getNombre().equals(nombre)
					&& registroVendedor.getApellido().equals(apellido)) {
				vendedorBuscado = registroVendedor;
			}
		}
		return vendedorBuscado;
	}

	
	/*public Vendedor buscarVendedor1(String nombre, String apellido,Object objeto) {
		Vendedor vendedorBuscado=null;
		if(objeto instanceof Venta) {
			for (Venta ventas : ventasDeLaEmpresa) {
				if (ventas.getVendedor().getNombre().equals(nombre)
						&& ventas.getVendedor().getApellido().equals(apellido)) {
					vendedorBuscado = ventas.getVendedor();
				}
			}
		}
		else if(objeto instanceof Vendedor) {
			for (Vendedor registroVendedor : vendedoresDeLaEmpresa) {
				if (registroVendedor.getNombre().equals(nombre)
						&& registroVendedor.getApellido().equals(apellido)) {
					vendedorBuscado = registroVendedor;
				}
			}
		}
		
			
		
		
		
		
		return vendedorBuscado;
		
	}*/
	
	
	
	
	
	public Double calcularComisionPorDiaPorVentaProducto(Date fecha, Vendedor vendedor) {
		Double ventaTotal = 0.0d;
		Double comisionTotal = 0.0d;

		for (Venta ventas : vendedor.getVentasDelVendedor()) {
			if (ventas.getFecha().equals(fecha)) {
				for (Item itemDeVenta : ventas.getItemsVendidos())
					if (itemDeVenta instanceof Producto) {
						ventaTotal += ((Producto) itemDeVenta).getPrecio();
					}
					// preguntar si solo producto o si servicio tambien, quitar else en casa de que
					// no
					/*else if (itemDeVenta instanceof Servicio) {
						ventaTotal += calcularPrecioServicio(itemDeVenta.getIdItem());
					}*/
			}
		}

		comisionTotal = (ventaTotal * vendedor.getPorcentajeComicion()) / 100;
		return comisionTotal;
	}

	public Double calcularPrecioServicio(Long id) {
		Double precio = 0.0d;
		for (Venta ventaRealizada : ventasDeLaEmpresa) {
			for (Item tipoDeItem : ventaRealizada.getItemsVendidos())
				if (tipoDeItem instanceof Servicio && tipoDeItem.getIdItem().equals(id)) {
					precio = ((Servicio) tipoDeItem).getCantidadHora() * ((Servicio) tipoDeItem).getPrecioPorHora();
				}

		}

		return precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Venta> getVentasDeLaEmpresa() {
		return ventasDeLaEmpresa;
	}

	public void setVentasDeLaEmpresa(List<Venta> ventasDeLaEmpresa) {
		this.ventasDeLaEmpresa = ventasDeLaEmpresa;
	}
	
	

}
