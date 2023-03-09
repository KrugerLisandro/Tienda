package ar.com.LabJava.Model;

import java.time.LocalDate;

import ar.com.LabJava.Interface.ProductoComestible;
import ar.com.LabJava.Interface.ProductoConDescuento;

/**
 * CLASE ABSTRACTA EXTENDEMOS DE LA CLASE PRODUCTO
 * IMPLEMENTAMOS LAS INTERFACES PRODUCTO_COMESTIBLE Y PRODUCTO_CON_DESCUENTO
 * DEFINIMOS LOS METODOS DE LAS INTERFACES COMO ABSTRACTA PARA QUE VAN A SOBREESCRITAS
 * EN CADA CLASE CONCRETA ENVASADO Y BEBIDA.
 */

public abstract class Comestible extends Producto implements ProductoComestible, ProductoConDescuento {
	
	//ATRIBUTOS.
	protected double calorias;
	protected LocalDate fechaVencimiento;
	protected boolean importado;
	
	//CONSTRUCTORES.
	public Comestible() {
		super();
	}

	public Comestible(String identificador, String descripcion, double precioUnidad, int cantStock, double porcentajeGanancia) {
		super(identificador, descripcion, precioUnidad, cantStock, porcentajeGanancia);
		this.importado = false;
	}
	
	//POR DEFECTO ES FALSE.
	public boolean isImportado() {
		return this.importado;
	}
	
	//SI ES TRUE, SE LE APLICA UN IMPUESTO DEL 10%.
	public void setImportado(boolean importado) {

		if (importado == true) {

			this.precioUnidad += (this.precioUnidad * 0.10);
		}
		
		this.importado = importado;
	}
	
	//METODOS QUE VAN A SER SOBREESCRITOS EN CADA CLASE CONCRETA.
	public abstract void setFechaVencimiento(LocalDate fecha);
		
	public abstract LocalDate getFechaVencimiento();

	public abstract void setCantidadDeCalorias(double calorias);
		
	public abstract double getCantidadDeCalorias();
	
	public abstract void setPorcentajeDescuento(double porcentajeDescuento);
		
	public abstract double getPorcentajeDescuento();
		
	public abstract double getPrecioConDescuento();

	@Override
	public String toString() {
		return super.toString();
	}

}
