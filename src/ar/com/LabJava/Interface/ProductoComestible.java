package ar.com.LabJava.Interface;

import java.time.LocalDate;

public interface ProductoComestible {
	
	//SETEAR Y OBTENER LA FECHA DE VENCIMIENTO
	void setFechaVencimiento(LocalDate fecha);
	
	LocalDate getFechaVencimiento();
	
	//SETEAR Y OBTENER LAS CALORÍAS
	void setCantidadDeCalorias(double calorias);
	
	double getCantidadDeCalorias();
}
