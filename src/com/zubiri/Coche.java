package com.zubiri;

public class Coche extends Vehiculo {
	private int numeroPuertas=0;
	private String capacidadMaletero="";
	
	public Coche(String matricula,int numBastidor,String color,int numeroAsientos,int precio,String marca,String modelo,String fecha,int numeroPuertas,String capacidadMaletero) {
		super ( matricula, numBastidor, color, numeroAsientos, precio, marca, modelo, fecha);
		this.numeroPuertas=numeroPuertas;
		this.capacidadMaletero=capacidadMaletero;
	}

	public int getNumeroPuertas() {
		return numeroPuertas;
	}

	public void setNumeroPuertas(int numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}

	public String getCapacidadMaletero() {
		return capacidadMaletero;
	}

	public void setCapacidadMaletero(String capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}

}
