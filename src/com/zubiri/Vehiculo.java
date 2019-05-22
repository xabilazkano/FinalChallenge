package com.zubiri;

public class Vehiculo {
	private String matricula = "";
	private String numeroBastidor = "";
	private String color = "";
	private int numeroAsientos = 0;
	private int precio = 0;
	private String marca = "";
	private String modelo = "";
	private String fechaFabricacion = "";
	 
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
	 */
	public Vehiculo(String matricula,String numBastidor,String color,int numeroAsientos,int precio,String marca,String modelo,String fecha) {
		this.matricula=matricula;
		this.numeroBastidor=numBastidor;
		this.color=color;
		this.numeroAsientos=numeroAsientos;
		this.precio=precio;
		this.marca=marca;
		this.modelo=modelo;
		this.fechaFabricacion=fecha;
	}

	/**
	 * Devuelve la matricula
	 * @return matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Cambia la matricula
	 * @param matricula
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * Devuelve el numero de bastidor
	 * @return numero de bastidor
	 */
	public String getNumeroBastidor() {
		return numeroBastidor;
	}

	/**
	 * Cambia el numero de bastidor
	 * @param numeroBastidor
	 */
	public void setNumeroBastidor(String numeroBastidor) {
		this.numeroBastidor = numeroBastidor;
	}

	/**
	 * Devuelve el color
	 * @return color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Cambia el color
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Devuelve el numero de asientos
	 * @return numero de asientos
	 */
	public int getNumeroAsientos() {
		return numeroAsientos;
	}

	/**
	 * Cambia el numero de asientos
	 * @param numeroAsientos
	 */
	public void setNumeroAsientos(int numeroAsientos) {
		this.numeroAsientos = numeroAsientos;
	}

	/**
	 * Devuelve el precio
	 * @return precio
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * Cambia el precio
	 * @param precio
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	/**
	 * Devuelve la marca
	 * @return marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Cambia la marca
	 * @param marca
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Devuelve el modelo
	 * @return modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Cambia el modelo
	 * @param modelo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Devuelve la fecha de fabricacion
	 * @return decha de fabricacion
	 */
	public String getFechaFabricacion() {
		return fechaFabricacion;
	}

	/**
	 * Cambia la fecha de fabricacion
	 * @param fechaFabricacion
	 */
	public void setFechaFabricacion(String fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}
	
}
