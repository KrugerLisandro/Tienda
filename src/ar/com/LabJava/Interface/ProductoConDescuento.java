package ar.com.LabJava.Interface;

public interface ProductoConDescuento {
	
	//SETEAR Y OBTENER EL PORCENTAJE DE DESCUENTO
	void setPorcentajeDescuento(double porcentajeDescuento);
	
	double getPorcentajeDescuento();
	
	//OBTENER EL PRECIO DE VENTA CON DESCUENTO
	double getPrecioConDescuento();
}
