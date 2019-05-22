package com.zubiri;

public class Coche extends Vehiculo {
	private int numeroPuertas=0;
	private String capacidadMaletero="";
	 
	/**
	 * Constructor
	 * @param matricula
	 * @param numBastidor
	 * @param color
	 * @param numeroAsientos
	 * @param precio
	 * @param marca
	 * @param modelo
	 * @param fecha
	 * @param numeroPuertas
	 * @param capacidadMaletero
	 */
	public Coche(String matricula,String numBastidor,String color,int numeroAsientos,int precio,String marca,String modelo,String fecha,int numeroPuertas,String capacidadMaletero) {
		super ( matricula, numBastidor, color, numeroAsientos, precio, marca, modelo, fecha);
		this.numeroPuertas=numeroPuertas;
		this.capacidadMaletero=capacidadMaletero;
	}

	/**
	 * Devuelve el numero de puertas
	 * @return numero de puertas
	 */
	public int getNumeroPuertas() {
		return numeroPuertas;
	}

	/**
	 * Cambia el valor de numero de puertas
	 * @param numeroPuertas
	 */
	public void setNumeroPuertas(int numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}

	/**
	 * Devuelve la capacidad del maletero
	 * @return capacidad del maletero
	 */
	public String getCapacidadMaletero() {
		return capacidadMaletero;
	}

	/**
	 * Cambia el valor de la capacidad del maletero
	 * @param capacidad del maletero
	 */
	public void setCapacidadMaletero(String capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}

}
