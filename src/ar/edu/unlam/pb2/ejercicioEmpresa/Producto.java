package ar.edu.unlam.pb2.ejercicioEmpresa;

public class Producto extends Item {

	private Double precio;

	public Producto(Long idItem, String descripcion, Double precio) {
		super(idItem, descripcion);
		this.precio = precio;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
	
}
