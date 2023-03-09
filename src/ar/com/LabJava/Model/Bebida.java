package ar.com.LabJava.Model;

import java.time.LocalDate;

//CLASE CONCRETA.
public class Bebida extends Comestible{
	
	//ATRIBUTO.
	private double graduacionAlcoh;
	
	//CONTRUCTORES.
	public Bebida() {
		super();
	}

	public Bebida(String identificador, String descripcion, double precioUnidad, int cantStock, double porcentajeGanancia) {
		super(identificador, descripcion, precioUnidad, cantStock, porcentajeGanancia);
		
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

	public double getGraduacionAlcoh() {
		return graduacionAlcoh;
	}

	public void setGraduacionAlcoh(Integer graduacionAlcoh) {
		this.graduacionAlcoh = graduacionAlcoh;
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
		
		if(this.graduacionAlcoh >= 0 && this.graduacionAlcoh <= 2) {
			this.setCantidadDeCalorias(this.graduacionAlcoh);
		}
		else if(this.graduacionAlcoh >= 2.1 && this.graduacionAlcoh <= 4.5) {
			this.setCantidadDeCalorias(this.graduacionAlcoh * 1.5);
		}
		else if(this.graduacionAlcoh >= 4.6) {
			this.setCantidadDeCalorias(this.graduacionAlcoh * 2);
		}
		
		return this.calorias;
	}
	
	@Override
	public void setPorcentajeDescuento(double porcentajeDescuento) {

		if(porcentajeDescuento <= 15) {
			this.porcentajeDescuento = porcentajeDescuento;
		}
		else {
			System.out.println("¡El porcentaje de descuento de las bebidas no podrá superar el 15%!");
		}
	}

	@Override
	public double getPorcentajeDescuento() {
		
		return this.porcentajeDescuento;
	}

	@Override
	public double getPrecioConDescuento() {
		
		double precioConDescuento = this.getPrecioVenta() - (this.getPrecioVenta() * this.getPorcentajeDescuento() / 100);		
		return Math.round(precioConDescuento * 100) / 100d;
	}
	
	@Override
	public String toString() {
		return "Bebida [ " + super.toString() + " ]";
	}
	
}
