package ar.edu.unlam.pb2.ejercicioEmpresa;

import java.util.ArrayList;
import java.util.Date;

public class Venta {

	private Date fecha;
	private Long idVenta;
	private Integer cantidad;
	private Vendedor vendedorDeLaVenta;
	private ArrayList<Item> itemsVendidos;

	public Venta(Date fecha, Long idVenta, Integer cantidad, Vendedor vendedorNuevo) {
		this.fecha = fecha;
		this.idVenta = idVenta;
		this.cantidad = cantidad;
		this.vendedorDeLaVenta = vendedorNuevo;
		itemsVendidos = new ArrayList<Item>();
	}

	public ArrayList<Item> getItemsVendidos() {
		return itemsVendidos;
	}

	public void agregarItemALaVenta(Item itemsVendido) {
		itemsVendidos.add(itemsVendido);
	}

	public Vendedor getVendedor() {
		return vendedorDeLaVenta;
	}

	public void setVendedorNuevo(Vendedor vendedorNuevo) {
		this.vendedorDeLaVenta = vendedorNuevo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
