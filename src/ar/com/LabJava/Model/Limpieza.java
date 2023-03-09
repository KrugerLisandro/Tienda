package ar.com.LabJava.Model;

import ar.com.LabJava.Interface.ProductoConDescuento;

//CLASE CONCRETA
public class Limpieza extends Producto implements ProductoConDescuento {
	
	//ATRIBUTO.
	private TipoDeAplicacion tipoDeAplicacion;
	
	//CONTRUCTORES
	public Limpieza() {
		super();
	}

	public Limpieza(String identificador, String descripcion, double precioUnidad, int cantStock, double porcentajeGanancia,
			TipoDeAplicacion tipoDeAplicacion) {
		super(identificador, descripcion, precioUnidad, cantStock, porcentajeGanancia);
		this.tipoDeAplicacion = tipoDeAplicacion;
	}
	
	//GETTERS Y SETTERS
	public TipoDeAplicacion getTipoDeAplicacion() {
		return tipoDeAplicacion;
	}

	public void setTipoDeAplicacion(TipoDeAplicacion tipoDeAplicacion) {
		this.tipoDeAplicacion = tipoDeAplicacion;
	}
	
	//METODOS SOBREESCRITOS
	@Override
	public void setPorcentajeGanancia(double porcentajeGanancia) {

		if ((this.tipoDeAplicacion == TipoDeAplicacion.ROPA || this.tipoDeAplicacion == TipoDeAplicacion.MULTIUSO)
				&& porcentajeGanancia <= 25) {
			this.porcentajeGanancia = porcentajeGanancia;
		} 
		else if (porcentajeGanancia >= 10 && porcentajeGanancia <= 25) {
			this.porcentajeGanancia = porcentajeGanancia;
		} 
		else {
			System.out.println("¡Los productos de limpieza no podrá ser menor del 10% ni mayor al 25%, "
					+ "excepto los de tipo ROPA y MULTIUSO que no tendrán mínimo!");
		}
		
	}
	
	@Override
	public double getPorcentajeGanancia() {

		return this.porcentajeGanancia;
	}
	
	@Override
	public void setPorcentajeDescuento(double porcentajeDescuento) {

		if(porcentajeDescuento <= 25) {
			this.porcentajeDescuento = porcentajeDescuento;
		}
		else {
			System.out.println("¡El porcentaje de descuento de los productos de limpieza no podrá superar el 25%!");
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
		return "Limpieza [ " + super.toString() + " ]";
	}

}
