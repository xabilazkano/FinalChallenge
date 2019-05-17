package com.zubiri;

public class Camion extends Vehiculo {
	private String carga="";
	private String tipoMercancia="";
	
	public Camion(String matricula,int numBastidor,String color,int numeroAsientos,int precio,String marca,String modelo,String fecha,String carga,String tipoMercancia) {
		super ( matricula, numBastidor, color, numeroAsientos, precio, marca, modelo, fecha);
		this.carga=carga;
		this.tipoMercancia=tipoMercancia;
		
	}

	public String getCarga() {
		return carga;
	}

	public void setCarga(String carga) {
		this.carga = carga;
	}

	public String getTipoMercancia() {
		return tipoMercancia;
	}

	public void setTipoMercancia(String tipoMercancia) {
		this.tipoMercancia = tipoMercancia;
	}
	
}
