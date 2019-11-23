package ar.edu.unlam.pb2.ejercicioEmpresa;

import java.util.ArrayList;

public class Vendedor {

	private Long idVendedor;
	private String nombre;
	private String apellido;
	private Double porcentajeComicion;
	private ArrayList<Venta> ventasDelVendedor;
	
	
	public Vendedor(Long idVendedor, String nombre, String apellido, Double porcentajeComicion) {
		this.idVendedor = idVendedor;
		this.nombre = nombre;
		this.apellido = apellido;
		this.porcentajeComicion = porcentajeComicion;
		ventasDelVendedor = new ArrayList<Venta>();
	}
	
	public ArrayList<Venta> getVentasDelVendedor() {
		return ventasDelVendedor;
	}

	

	protected void agregarVenta(Venta venta) {
		ventasDelVendedor.add(venta);
	}
	
	public Long getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(Long idVendedor) {
		this.idVendedor = idVendedor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Double getPorcentajeComicion() {
		return porcentajeComicion;
	}
	public void setPorcentajeComicion(Double porcentajeComicion) {
		this.porcentajeComicion = porcentajeComicion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((idVendedor == null) ? 0 : idVendedor.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (idVendedor == null) {
			if (other.idVendedor != null)
				return false;
		} else if (!idVendedor.equals(other.idVendedor))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	
	
}
