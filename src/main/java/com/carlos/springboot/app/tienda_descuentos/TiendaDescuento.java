package com.carlos.springboot.app.tienda_descuentos;

import java.text.DecimalFormat;

/**
 * @author Carlos Martínez
 * Clase de implementación
 */
public class TiendaDescuento implements IDescuento {

	private String nombreCliente;
	private String producto;
	private double precio;
	private int cantidad;

	private double totalNormal;
	private double descuento;
	private double totalPagar;

	/**
	 * Constructores
	 */
	public TiendaDescuento() {

	}

	public TiendaDescuento(String nombreCliente, String producto, double precio, int cantidad) {
		this.nombreCliente = nombreCliente;
		this.producto = producto;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	/**
	 * Implmentación de métodos
	 * 
	 * calcularTotal(args): Devuelve el total a pagar, calculando si aplica o no un descuento, y que tipo de descuento será
	 * @return void
	 * 
	 */
	@Override
	public void calcularTotal(double compra, String areaCompra) {
		
		if (areaCompra.equals("frutas") || areaCompra.equals("verduras") || areaCompra.equals("carnes")) {
			if (compra > 20 && compra <= 50) {
				setDescuento(compra * IDescuento.DESC_1);
				setTotalPagar(compra - descuento);
				setTotalNormal(compra);
			} else if (compra > 50) {
				setDescuento(compra * IDescuento.DESC_2);
				setTotalPagar(compra - descuento);
				setTotalNormal(compra);
			} else {
				setDescuento(0);
				setTotalPagar(compra);
				setTotalNormal(compra);
			}
		} else {
			setDescuento(0.0);
			setTotalPagar(compra);
			setTotalNormal(compra);
		}
		
	}
	
	/**
	 * imprimirFactura(args): Imprime por consola una factura, indicando toda la información de la compra
	 * @return void
	 * 
	 */
	public void imprimirFactura() {
		
		//Formateador para decimales
		DecimalFormat df = new DecimalFormat("#.00");
		
		System.out.println("Nombre del Cliente: ".concat(getNombreCliente()));
		System.out.println("Producto: ".concat(getProducto()));
		System.out.println("Precio: $" + df.format(getPrecio()));
		System.out.println("Cantidad: " + getCantidad());
		System.out.println("Total sin Descuento: $" + getTotalNormal());
		
		if(getDescuento() > 0) {
			System.out.println("Descuento: $" + df.format(getDescuento()));
		} else {
			System.out.println("Descuento: $0");
		}
		
		System.out.println("Total a Pagar: $" + getTotalPagar());
	}
	
	/**
	 * validarCantidad(args): Valida que la cantidad de producto ingresada sea válida (Esta debe ser un entero)
	 * @return boolean
	 * 
	 */
	public static boolean validarCantidad(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	/**
	 * validarPrecio(args): Valida que el precio sea válido (Este debe ser un decimal o un entero que pueda convertirse en decimal)
	 * @return boolean
	 * 
	 */
	public static boolean validarPrecio(String cadena) {
		try {
			Double.parseDouble(cadena);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	/**
	 * Métodos Setters & Getters
	 * 
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}
	
	public double getTotalNormal() {
		return totalNormal;
	}

	public void setTotalNormal(double totalNormal) {
		this.totalNormal = totalNormal;
	}

}
