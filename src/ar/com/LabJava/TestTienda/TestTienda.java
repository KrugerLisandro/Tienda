package ar.com.LabJava.TestTienda;

import java.util.List;

import ar.com.LabJava.Model.*;

public class TestTienda {

	public static void main(String[] args) {

		//testTiendaPrueba1();		
		
		//testTiendaPrueba2();
		
		testTiendaPrueba3();
		
		System.out.println("\nFin Programa.\n");
	}

	private static void testTiendaPrueba1() {
		
		System.out.println("Test Tienda Prueba 1:");
		
		Tienda tienda = new Tienda("Walmart", 351L, 230300D);
		
		tienda.comprarProducto(new Envasado("AB111", "Yerba Amanda 1Kg", 859.99D, 50, 15D));
		tienda.comprarProducto(new Bebida("AC111", "Cerveza Heineken 1L", 999.99D, 70, 16D));
		tienda.comprarProducto(new Limpieza("AZ111", "Detergente Magistral 750 ml", 749.9D, 55,9D,TipoDeAplicacion.MULTIUSO));
		tienda.comprarProducto(new Envasado("AB112", "Azúcar 1Kg", 249.99D, 30, 15D));
		tienda.comprarProducto(new Bebida("AC112", "Coca cola 2L", 499.99D, 80, 16D));
		tienda.comprarProducto(new Limpieza("AZ112", "Lavandina 1L", 339.99D, 20, 11D, TipoDeAplicacion.BAÑO));
		
		System.out.println("Stock Actual Disponible: " + tienda.getStockMaximo() + " - " + "Saldo Actual Disponible: " + tienda.getSaldoEnCaja());
		
		try {
			System.out.println("CASO 1:");
			//PRODUCTO NO PUEDE SER AGREGADO A LA TIENDA POR FALTA DE SALDO EN CAJA.
			tienda.comprarProducto(new Envasado("AB113", "Arroz 1Kg", 569.99D, 45, 15D));
			System.out.println("CASO 2:");
			//STOCK MAXIMO SUPERADO.
			tienda.comprarProducto(new Limpieza("AZ113", "ALA - Suavizante para ropas", 50.00D, 100, 15D, TipoDeAplicacion.ROPA));
			System.out.println("CASO 3:");
			//NO CUMPLE CON NINGUNA DE LAS DOS CONDICIONES.
			tienda.comprarProducto(new Bebida("AC113", "Agua Mineral 5L", 100.00, 1000, 16D));
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void testTiendaPrueba2() {
		
		System.out.println("\nTest Tienda Prueba 2:");
		
		Tienda tienda = new Tienda("Mercado Libre", 30L, 50000.0D);
		
		Envasado aceite = new Envasado("AB212", "Aceite Girasol 1L", 959.99D, 10, 18D);
		aceite.setImportado(true);
		aceite.setPorcentajeDescuento(18);
		System.out.println(aceite.getDescripcion() + ", precio con descuento es: " + aceite.getPrecioConDescuento());
		
		Bebida aguaMineral = new Bebida("AC212", "Agua Mineral 5L", 249.99D, 10, 14D);
		aguaMineral.setImportado(true);
		aguaMineral.setPorcentajeDescuento(15);
		System.out.println(aguaMineral.getDescripcion() + ", precio con descuento es: " + aguaMineral.getPrecioConDescuento());
		
		Limpieza jabonLiq = new Limpieza("AZ212", "Jabon Liquido 3L", 99.99D, 10, 8D, TipoDeAplicacion.MULTIUSO);
		jabonLiq.setPorcentajeDescuento(25);
		System.out.println(jabonLiq.getDescripcion() + ", precio con descuento es: " + jabonLiq.getPrecioConDescuento());
		
		tienda.comprarProducto(aceite);
		tienda.comprarProducto(aguaMineral);
		tienda.comprarProducto(jabonLiq);
		System.out.println("Stock Actual Disponible: " + tienda.getStockMaximo() + " - " + "Saldo Actual Disponible: " + tienda.getSaldoEnCaja());
		
		try {
			System.out.println("CASO 1:");
			tienda.carritoVentaDeProductos(new String[] {"AB212", "AC212", "AZ212","AB212"}, new int[] {10, 10, 10});
			
			System.out.println("CASO 2:");
			tienda.carritoVentaDeProductos(new String[] {"AB212", "AC212", "AZ212"}, new int[] {10, 10, 15});
			
			System.out.println("CASO 3:");
			tienda.carritoVentaDeProductos(new String[] {"AB212", "AC212", "AZ212"}, new int[] {10, 10, 10});
			System.out.println("Stock Actual Disponible: " + tienda.getStockMaximo() + " - " + "Saldo Actual Disponible: " + tienda.getSaldoEnCaja());
		} catch (NullPointerException e) {
			
			System.out.println("Nose se encontro ningun producto con ese codigo: " + e.getMessage());
		}
		
	}
	
	private static void testTiendaPrueba3() {
		
		System.out.println("\nTest Tienda Prueba 3:");
		
		Envasado envasado1 = new Envasado("AB111", "Cafe", 100.0D, 10, 20D);
		envasado1.setImportado(false);
		envasado1.setPorcentajeDescuento(10);
		
		Envasado envasado2 = new Envasado("AB112", "Arroz", 100.0D, 10, 20D);
		envasado2.setImportado(true);
		envasado1.setPorcentajeDescuento(10);
		
		Envasado envasado3 = new Envasado("AB114", "Yerba", 56.99D, 10, 20D);
		envasado1.setImportado(false);
		envasado1.setPorcentajeDescuento(10);
		
		Envasado envasado4 = new Envasado("AB113", "Fideos", 100.0D, 100, 20D);
		envasado3.setImportado(false);
		envasado3.setPorcentajeDescuento(15);
		
		Envasado envasado5 = new Envasado("AB115", "Polenta", 449.99D, 80, 20D);
		envasado1.setImportado(false);
		envasado1.setPorcentajeDescuento(10);
		
		Bebida bebida1 = new Bebida("AC111", "Leche", 39.99D, 150, 15D);
		bebida1.setImportado(false);
		bebida1.setPorcentajeDescuento(10);
		
		Bebida bebida2 = new Bebida("AC112", "Agua Mineral", 100.00D, 145, 15D);
		bebida2.setImportado(true);
		bebida2.setPorcentajeDescuento(10);
		
		Bebida bebida3 = new Bebida("AC114", "Vino", 89.99D, 66, 15D);
		bebida1.setImportado(false);
		bebida1.setPorcentajeDescuento(10);
		
		Bebida bebida4 = new Bebida("AC113", "Cerveza", 100.00D, 87, 15D);
		bebida3.setImportado(false);
		bebida3.setPorcentajeDescuento(15);
		
		Bebida bebida5 = new Bebida("AC115", "Coca cola", 299.99D, 91, 15D);
		bebida1.setImportado(false);
		bebida1.setPorcentajeDescuento(10);
		
		Tienda tienda = new Tienda("Mercado Libre", 3000L, 200000.0D);
		
		System.out.println(envasado1.toString());
		tienda.comprarProducto(envasado1);
		System.out.println(envasado2.toString());
		tienda.comprarProducto(envasado2);
		System.out.println(envasado3.toString());
		tienda.comprarProducto(envasado3);
		System.out.println(envasado4.toString());
		tienda.comprarProducto(envasado4);
		System.out.println(envasado5.toString());
		tienda.comprarProducto(envasado5);
		System.out.println(bebida1.toString());
		tienda.comprarProducto(bebida1);
		System.out.println(bebida2.toString());
		tienda.comprarProducto(bebida2);
		System.out.println(bebida3.toString());
		tienda.comprarProducto(bebida3);
		System.out.println(bebida4.toString());
		tienda.comprarProducto(bebida4);
		System.out.println(bebida5.toString());
		tienda.comprarProducto(bebida5);
		
		try {
			System.out.println("Stock Actual Disponible: " + tienda.getStockMaximo() + " - " + "Saldo Actual Disponible: " + tienda.getSaldoEnCaja());
			
			List<String> productos = tienda.obtenerComestiblesConMenorDescuento(11D);
			
			System.out.println(productos.toString());
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}

}
