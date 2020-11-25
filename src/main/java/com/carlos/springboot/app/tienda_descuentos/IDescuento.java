package com.carlos.springboot.app.tienda_descuentos;

/**
 * @author Carlos Martínez
 *	
 *	Interface con declaración de métodos principales
 */
public interface IDescuento {

	/**
	 * Porcentajes para los descuentos del 5% y el 7%
	 */
	public static final double DESC_1 = 0.05;
	public static final double DESC_2 = 0.07;
	
	/**
	 * calcularTotal(args)
	 * @return void
	 */
	public void calcularTotal(double compra, String areaCompra);
	
	/**
	 * imprimirFactura(args)
	 * @return void
	 */
	public void imprimirFactura();
	
}
