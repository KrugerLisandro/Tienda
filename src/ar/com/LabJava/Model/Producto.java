package ar.com.LabJava.Model;

//CLASE ABSTRACTA.
public abstract class Producto {
	
	//ATRIBUTOS.
	protected String identificador; //ALFANUMÉRICO DE LONGITUD 5
	protected String descripcion;  
	protected double precioUnidad;
	protected double precioVenta;
	protected int cantStock;
	protected double porcentajeGanancia;
	protected double porcentajeDescuento;
	protected boolean disponible;
	
	//CONSTRUCTORES.
	public Producto() {
	}

	public Producto(String identificador, String descripcion, double precioUnidad, int cantStock, double porcentajeGanancia) {
		this.identificador = identificador;
		this.descripcion = descripcion;
		this.precioUnidad = precioUnidad;
		this.precioVenta = 0;
		this.cantStock = cantStock;
		this.porcentajeGanancia = porcentajeGanancia;
		this.porcentajeDescuento = 0;
		this.disponible = true;
	}
	
	//GETTERS Y SETTERS.
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}
	
	public double getPrecioVenta() {
		
		double ganancia = this.precioUnidad * this.porcentajeGanancia / 100;
		this.precioVenta = this.precioUnidad + ganancia;
		double descuento = this.precioVenta * this.porcentajeDescuento / 100;
		this.precioVenta -= descuento;
		return this.precioVenta;
	}

	public int getCantStock() {
		return cantStock;
	}

	public void setCantStock(int cantStock) {
		this.cantStock = cantStock;
	}
	
	/**
	 * GET/SET PORCENTAJEGANANCIA SON METODOS ABSTRACTOS PORQUE SE VAN A COMPORAR DE MANERA DIFERENTE
	 * DEPENDIENDO DE COMO LA VA A IMPLEMENTAR CADA CLASE ENVASADO, BEBIDA O LIMPIEZA.
	 */
	abstract public double getPorcentajeGanancia();

	abstract public void setPorcentajeGanancia(double porcentajeGanancia);
	
	//POR DEFECTO ES TRUE.
	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	@Override
	public String toString() {
		return "Producto [ " + this.identificador + " " + this.descripcion + " " +
				this.cantStock + " x " + this.precioUnidad + " ]";
	}
	
}
