#PARTE I – MODELO DEL SISTEMA.

Producto(abstract)
	*identificador; 
	*descripcion;  
	*precioUnidad;
	*precioVenta;
	*cantStock;
	*porcentajeGanancia;
	*porcentajeDescuento;
	*disponible;
			
Comestible (abstract) extends Producto implements ProductoComestible, ProductoConDescuento
	*calorias;
	*fechaVencimiento;
	*importado;
			-> Envasado (Clase concreta)
				*propiedadesEnvase
			-> Bebida (Clase concreta)
				*graduacionAlcoh
	-> Limpieza
		*tipoDeAplicacion
	-> TipoDeAplicacion (Enum)
	
Tienda
	*nombre
	*stockMaximo
	*saldoEnCaja
			
ProductoComestible (Interface)
ProductoConDescuento (Interface)

TestTienda (Main)

#PARTE II – OPERACIONES DE LA TIENDA.

Metodo compra de producto ().

Defino don colecciones de tipo Map productosComestible y productosDeLimpieza.
Por defecto todos los productos estaran disponibles para la venta.
Por cada producto agregado actualizo el saldo en la caja. Si el saldo en la caja no resulta suficiente para cubrir dicho monto muestro un mensaje "El producto no podrá ser agregado a la tienda por saldo insuficiente en la caja"
No se podrán agregar mas productos a la tienda una vez que se haya  alcanzado  el  máximo  de  stock  habilitado. En este caso voy disminuyendo el valor del Stock Maximo hasta llegar a 0 que indica que ya no tenemos mas lugar en la ttienda para mas productos.

Metodo Venta de Productos().

Valido que solo se imprima un maximo de 3 productos de cualquier tipo y por cada producto un maximo de 10 unidades.
Imprimo  el  detalle: identificador, descripción, cantidad de unidades y precio de venta por unidad para cada producto y al final el total de la venta.
Ejemplo de la impresión de una venta: 
AB122 CAFÉ 2 x 1,50 
AB455 ACEITE 2 x 20 
TOTAL VENTA: 64,50
En el caso de que el número de unidades vendidas de alguno de los productos sea mayor al que se  tenga en stock, se venderá solo el número de unidades  disponibles y actualizo el producto para que quede fuera de venta.
Solo podrán venderse productos que estén habilitados para la venta, caso contrario muestro un mensaje “El producto AB122 CAFÉ no se encuentra disponible”.

#Consideraciones especiales.
Para las bebidas, las calorías se calcularán de la siguiente manera: si la graduación alcohólica está entre 0 y 2, será el valor ingresado, si está entre 2,1 y 4,5 será el valor ingresado por 1,5 y si es mayor a 4,6 será el valor ingresado por 2 - El  porcentaje  de  ganancia  de  los  productos  comestibles  no  podrá  superar  el  20%  y el  de los productos de limpieza no podrá ser menor del 10% ni mayor al 25%, excepto los de tipo ROPA y MULTIUSO que no tendrán mínimo. - El porcentaje de descuento de las bebidas no podrá superar el 15%, el de los envasados el 20% y el de los productos de limpieza el 25% - Para los productos importados se aplicará un impuesto del 10% sobre el precio de venta.

#PARTE III – REQUERIMIENTO ADICIONAL.
Se  desea  conocer la  lista  de  productos comestibles  NO  importados cuyo  descuento sea menor  a  un determinado porcentaje. Para ello se pide implementar un método llamado obtenerComestiblesConMenorDescuento(porcentaje_descuento) que devolverá  una  lista de productos comestibles (descripción) NO  importados cuyo  descuento  sea  menor  al  porcentaje  pasado  como parámetro.  
La lista deberá devolverse ordenada en forma ascendente de acuerdo con el precio de venta y con todas las descripciones en mayúsculas. Un resultado valido podría ser: “ACEITE, VINO, ARROZ”.
Utilizo la API STREAMS de Java y la coleccion que defini productosComestibles.

#PARTE IV - EJECUCION.
Ejecuto algunos caso de prueba en la clase TestTienda (Main) para probar el funcionamiento de la aplicación.			