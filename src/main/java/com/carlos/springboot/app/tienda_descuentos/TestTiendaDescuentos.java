package com.carlos.springboot.app.tienda_descuentos;

import java.util.Scanner;

/**
 * @author Carlos Martínez
 *	Clase principal
 */
public class TestTiendaDescuentos {
	
	/**
	 * Para que los descuentos apliquen debe escogerse una de las siguientes áreas: frutas, verduras, carnes (tal y como están escritas)
	 * Si la compra total es menor o igual que $20 no se aplicará ningún descuento.
	 * Si la compra total es mayor que 20 y menor o igual a 50 se aplicará el %5 de descuento.
	 * Si la compra total es mayor que 50 se aplicará un descuento del 7%
	 */
	public static void main(String[] args) {
	
		String nombreCliente;
		String producto;
		double precio;
		int cantidad;
		String area;
		
		/**
		 * Instancia de objetos para capturar y guardar información
		 */
		TiendaDescuento tienda;
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		/**
		 * Captura y validación de datos
		 */
		System.out.println("Descuentos solo aplican para compras mayores de $20.\nEn las siguientes áreas: frutas, verduras y carnes.");
		System.out.println();
		
		System.out.println("Ingrese el nombre del cliente: ");
		nombreCliente = scanner.nextLine();
		
		System.out.println("Ingrese el área de compra: ");
		area = scanner.nextLine();
		
		System.out.println("Ingrese el producto: ");
		producto = scanner.nextLine();
		
		System.out.println("Ingrese el precio del producto: ");
		String precioValidar = scanner.nextLine();
		while ( !TiendaDescuento.validarPrecio(precioValidar) ) {
			System.out.println("Debe ingresar un precio válido: ");
			precioValidar = scanner.nextLine();
		}
		
		precio = Double.parseDouble(precioValidar);
		
		System.out.println("Ingrese la cantidad: ");
		String cantidadValidar = scanner.nextLine();
		while ( !TiendaDescuento.validarCantidad(cantidadValidar) ) {
			System.out.println("Debe ingresar una cantidad válida: ");
			cantidadValidar = scanner.nextLine();
		}
		
		cantidad = Integer.parseInt(cantidadValidar);
		
		/**
		 * Con los datos ya validados guardamos los datos en el objeto y se llaman los metodos-
		 * calcularTotal(args) e imprimirFactura(args)
		 */
		tienda = new TiendaDescuento(nombreCliente, producto, precio, cantidad);
		tienda.calcularTotal((cantidad * precio), area);
		tienda.imprimirFactura();
		
	}
		
}
