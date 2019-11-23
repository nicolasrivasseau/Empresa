package ar.edu.unlam.pb2.ejercicioEmpresa;

public abstract class Item {

	private Long idItem;
	private String descripcion;
	
	
	
	public Item(Long idItem, String descripcion) {
		this.idItem = idItem;
		this.descripcion = descripcion;
	}
	
	public Long getIdItem() {
		return idItem;
	}
	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
