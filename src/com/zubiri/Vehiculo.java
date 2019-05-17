package com.zubiri;

public class Vehiculo {
	private String matricula = "";
	private int numeroBastidor = 0;
	private String color = "";
	private int numeroAsientos = 0;
	private int precio = 0;
	private String marca = "";
	private String modelo = "";
	private String fechaFabricacion = "";
	
	public Vehiculo(String matricula,int numBastidor,String color,int numeroAsientos,int precio,String marca,String modelo,String fecha) {
		this.matricula=matricula;
		this.numeroBastidor=numBastidor;
		this.color=color;
		this.numeroAsientos=numeroAsientos;
		this.precio=precio;
		this.marca=marca;
		this.modelo=modelo;
		this.fechaFabricacion=fecha;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getNumeroBastidor() {
		return numeroBastidor;
	}

	public void setNumeroBastidor(int numeroBastidor) {
		this.numeroBastidor = numeroBastidor;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumeroAsientos() {
		return numeroAsientos;
	}

	public void setNumeroAsientos(int numeroAsientos) {
		this.numeroAsientos = numeroAsientos;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFechaFabricacion() {
		return fechaFabricacion;
	}

	public void setFechaFabricacion(String fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}
	
}
