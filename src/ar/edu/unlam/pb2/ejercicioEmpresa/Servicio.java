package ar.edu.unlam.pb2.ejercicioEmpresa;

public class Servicio extends Item {

	private Double precioPorHora;
	private Double cantidadHora;
	
	
	public Servicio(Long idItem, String descripcion, Double precioPorHora, Double cantidadHora) {
		super(idItem, descripcion);
		this.precioPorHora = precioPorHora;
		this.cantidadHora = cantidadHora;
	}

 
	public Double getPrecioPorHora() {
		return precioPorHora;
	}

	public void setPrecioPorHora(Double precioPorHora) {
		this.precioPorHora = precioPorHora;
	}

	public Double getCantidadHora() {
		return cantidadHora;
	}

	public void setCantidadHora(Double cantidadHora) {
		this.cantidadHora = cantidadHora;
	}

	
}
