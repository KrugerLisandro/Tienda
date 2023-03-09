package ar.com.LabJava.Model;

import java.time.LocalDate;

//CLASE CONCRETA.
public class Envasado extends Comestible{
	
	//ATRIBUTO.
	private String propiedadesEnvase;
	
	//CONTRUCTORES.
	public Envasado() {
		super();
	}

	public Envasado(String identificador, String descripcion, double precioUnidad, int cantStock, double porcentajeGanancia) {
		super(identificador, descripcion, precioUnidad, cantStock, porcentajeGanancia);
	}
	
	//GETTERS Y SETTERS
	public String getPropiedadesEnvase() {
		return propiedadesEnvase;
	}

	public void setPropiedadesEnvase(String propiedadesEnvase) {
		this.propiedadesEnvase = propiedadesEnvase;
	}
	
	//METODOS SOBREESCRITOS.
	@Override
	public double getPorcentajeGanancia() {
		
		return this.porcentajeGanancia;
	}

	@Override
	public void setPorcentajeGanancia(double porcentajeGanancia) {

		if(porcentajeGanancia <= 20) {
			this.porcentajeGanancia = porcentajeGanancia;
		}
		else {
			System.out.println("¡Los  productos  comestibles  no  podrá  superar  el  20%!");
		}
		
	}
	
	@Override
	public void setFechaVencimiento(LocalDate fecha) {
		
		this.fechaVencimiento = fecha;
	}

	@Override
	public LocalDate getFechaVencimiento() {
		
		return this.fechaVencimiento;
	}

	@Override
	public void setCantidadDeCalorias(double calorias) {
		
		this.calorias = calorias;
	}

	@Override
	public double getCantidadDeCalorias() {
		
		return this.calorias;
	}
	
	@Override
	public void setPorcentajeDescuento(double porcentajeDescuento) {
		
		if(porcentajeDescuento <= 20) {
			this.porcentajeDescuento = porcentajeDescuento;
		}
		else {
			System.out.println("¡El porcentaje de descuento de los envasados no podrá superar el 20%!");
		}
	}

	@Override
	public double getPorcentajeDescuento() {
		
		return this.porcentajeDescuento;
	}

	@Override
	public double getPrecioConDescuento() {
		
		double precioConDescuento = this.getPrecioVenta();		
		return Math.round(precioConDescuento * 100) / 100d;
	}
	
	@Override
	public String toString() {
		return "Envasado [ " + super.toString() + " ]";
	}

}
