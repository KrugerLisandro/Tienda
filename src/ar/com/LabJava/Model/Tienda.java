package ar.com.LabJava.Model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//CLASE CONCRETA.
public class Tienda {

	// ATRIBUTOS.
	private String nombre;
	private long stockMaximo;
	private double saldoEnCaja;

	// COLECCIONES.
	private Map<String, Comestible> productosComestibles = new HashMap<String, Comestible>();
	private Map<String, Limpieza> productosDeLimpieza = new HashMap<String, Limpieza>();

	// CONTRUCTORES.
	public Tienda() {
	}

	public Tienda(String nombre, long stockMaximo, double saldoCaja) {
		this.nombre = nombre;
		this.stockMaximo = stockMaximo;
		this.saldoEnCaja = saldoCaja;
	}

	// GETTERS Y SETTERS.
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getStockMaximo() {
		return stockMaximo;
	}

	public void setStockMaximo(long stockMaximo) {
		this.stockMaximo = stockMaximo;
	}

	public double getSaldoEnCaja() {

		return Math.round(this.saldoEnCaja * 100) / 100d;
	}

	public void setSaldoEnCaja(double saldoEnCaja) {
		this.saldoEnCaja = saldoEnCaja;
	}

	public Map<String, Comestible> getProductosComestibles() {
		return productosComestibles;
	}

	public void setProductosComestibles(Map<String, Comestible> productosComestibles) {
		this.productosComestibles = productosComestibles;
	}

	public Map<String, Limpieza> getProductosDeLimpieza() {
		return productosDeLimpieza;
	}

	public void setProductosDeLimpieza(Map<String, Limpieza> productosDeLimpieza) {
		this.productosDeLimpieza = productosDeLimpieza;
	}

	// AGREGAR UN PRODUCTO COMESTIBLE A LA COLECCIONES DE PRODUCTOS_COMESTIBLES.
	public void comprarProducto(Comestible producto) {
		String clave = producto.getIdentificador();
		int cantidadActual = 0;

		boolean maxStockHabilitado = maximoDeStockHabilitado(producto.getCantStock());
		boolean saldoActualizado = actualizarElSaldoEnLaCaja(producto.getCantStock(), producto.getPrecioUnidad());

		if (productosComestibles.containsKey(clave) && maxStockHabilitado && saldoActualizado) {
			cantidadActual = this.productosComestibles.get(clave).getCantStock();
			this.productosComestibles.get(clave).setCantStock(cantidadActual + producto.getCantStock());

			this.saldoEnCaja -= (producto.getCantStock() * producto.getPrecioUnidad());
		} else if (maxStockHabilitado && saldoActualizado) {
			this.productosComestibles.put(producto.getIdentificador(), producto);

			this.saldoEnCaja -= (producto.getCantStock() * producto.getPrecioUnidad());
		}
	}

	// AGREGAR UN PRODUCTO DE LIMPIEZA A LA COLECCION PRODUCTOS_DE_LIMPIEZA.
	public void comprarProducto(Limpieza producto) {
		String clave = producto.getIdentificador();
		int cantidadActual = 0;

		boolean maxStockHabilitado = maximoDeStockHabilitado(producto.getCantStock());
		boolean saldoActualizado = actualizarElSaldoEnLaCaja(producto.getCantStock(), producto.getPrecioUnidad());

		if (productosDeLimpieza.containsKey(clave) && maxStockHabilitado && saldoActualizado) {
			cantidadActual = this.productosDeLimpieza.get(clave).getCantStock();
			this.productosDeLimpieza.get(clave).setCantStock(cantidadActual + producto.getCantStock());

			this.saldoEnCaja -= (producto.getCantStock() * producto.getPrecioUnidad());
		} else if (maxStockHabilitado && saldoActualizado) {
			this.productosDeLimpieza.put(producto.getIdentificador(), producto);

			this.saldoEnCaja -= (producto.getCantStock() * producto.getPrecioUnidad());
		}
	}

	// CONSULTAMOS SI NO SUPERAMOS EL STOCK MAXIMO.
	private boolean maximoDeStockHabilitado(int cantidadDeStock) {

		boolean band = false;

		if ((this.stockMaximo - cantidadDeStock) >= 0) {
			this.stockMaximo -= cantidadDeStock;
			band = true;
		} else {
			System.out.println("¡El stock máximo ha sido superado!");
		}

		return band;
	}

	// CONSULTAMOS SI TENEMOS SALDO SUFICIENTE EN LA CAJA.
	private boolean actualizarElSaldoEnLaCaja(int cantidadDeStock, double precioUnidad) {

		boolean band = true;

		if ((cantidadDeStock * precioUnidad) > this.saldoEnCaja) {
			System.out.println("¡El producto no puede ser agregado a la tienda por falta de saldo en caja!");
			band = false;
		}

		return band;
	}

	// ANTES DE IMPRIMIR LA VENTA CONSULTAMOS SI TENEMOS HASTA 3 PRODUCTOS Y POR
	// CADA PRODUCTO UN MAXIMO DE 10 UNIDADES.
	public void carritoVentaDeProductos(String[] identificadores, int[] unidadesPorProducto) {
		if (maximoTresProducto(identificadores) == true && maximoDiezUnidadesPorProducto(unidadesPorProducto) == true) {
			imprimirVentaDeProductos(identificadores, unidadesPorProducto);
		}
	}

	// VERIFICAMOS LA CANIDAD DE PRODUCTOS POR VENTA
	private boolean maximoTresProducto(String[] identificadores) {

		boolean band = false;

		if (identificadores.length > 0 && identificadores.length <= 3) {
			band = true;
		}

		if (band == false) {
			System.out.println("¡Debe haber al menos 1 y maximo 3 productos por venta!");
		}
		return band;
	}

	// VERIFICA SI NO EXCEDE EL MAXIMO DE 10 UNIDADES POR PRODUCTO.
	private boolean maximoDiezUnidadesPorProducto(int[] unidadesPorProducto) {
		boolean band = true;

		for (int i = 0; i < unidadesPorProducto.length; i++) {
			if (unidadesPorProducto[i] > 10) {
				band = false;
			}
		}

		if (band == false) {
			System.out.println("¡No se permiten mas de 10 Unidades por Producto!");
		}
		return band;
	}

	// IMPRIMIMOS LA VENTA.
	private void imprimirVentaDeProductos(String[] identificadores, int[] unidadesPorProducto) {
		double totalVenta = 0.0;
		boolean StockMenorAlSolicitado = false;

		for (int i = 0; i < identificadores.length; i++) {

			Producto producto = this.obtenerUnProducto(identificadores[i]);
			int cantidadSolicitada = Math.min(unidadesPorProducto[i], producto.getCantStock());
			producto.setCantStock(producto.getCantStock() - cantidadSolicitada);

			if (producto.isDisponible()) {
				System.out.println(producto.getIdentificador() + " " + producto.getDescripcion() + " "
						+ cantidadSolicitada + " x " + String.format("%.2f", producto.getPrecioVenta()));
				this.stockMaximo += cantidadSolicitada;
				totalVenta += (producto.getPrecioVenta() * cantidadSolicitada);

			} else {
				System.out.println("El producto " + producto.getIdentificador() + " " + producto.getDescripcion()
						+ " no se encuentra disponible");
			}

			if (cantidadSolicitada < unidadesPorProducto[i]) {
				StockMenorAlSolicitado = true;
				producto.setDisponible(false);
			}
		}

		System.out.println("Total Venta: " + String.format("%.2f", totalVenta));
		this.saldoEnCaja += totalVenta;

		if (StockMenorAlSolicitado) {
			System.out.println("¡Hay productos con stock disponible menor al solicitado!");
		}
	}

	// OBTENEMOS UN PRODUCTO A PARTIR DE SU IDENTIFICADOR.
	private Producto obtenerUnProducto(String identificador) {

		Producto obtenerProducto = null;

		for (Map.Entry<String, Comestible> producto : productosComestibles.entrySet()) {

			if (producto.getKey() == identificador) {
				obtenerProducto = producto.getValue();
			}
		}

		for (Map.Entry<String, Limpieza> producto : productosDeLimpieza.entrySet()) {

			if (producto.getKey() == identificador) {
				obtenerProducto = producto.getValue();
			}
		}

		return obtenerProducto;
	}

	// USO DE LA API STREAM.
	public List<String> obtenerComestiblesConMenorDescuento(double porcentaje_descuento) {
		return productosComestibles.values().stream()
				.filter(c -> !c.isImportado() && c.getPorcentajeDescuento() < porcentaje_descuento)
				.sorted(Comparator.comparingDouble(Comestible::getPrecioUnidad))
				.map(c -> c.getDescripcion().toUpperCase()).collect(Collectors.toList());
	}
}
