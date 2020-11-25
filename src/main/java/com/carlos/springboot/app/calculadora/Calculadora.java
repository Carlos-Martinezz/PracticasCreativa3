package com.carlos.springboot.app.calculadora;

/**
 * @author Carlos Martínez
 * Interface Calculadora con declaración de métodos
 */
public abstract class Calculadora {

	public abstract int suma(int num1, int num2);
	public abstract int resta(int num1, int num2);
	public abstract int multiplicacion(int num1, int num2);
	public abstract int division(int num1, int num2);
	
}
