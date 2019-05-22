package com.zubiri;

public class Camion extends Vehiculo {
	private String carga = "";
	private String tipoMercancia = "";

	/**
	 * Constructor
	 * 
	 * @param matricula
	 * @param numBastidor
	 * @param color
	 * @param numeroAsientos
	 * @param precio
	 * @param marca
	 * @param modelo
	 * @param fecha
	 * @param carga
	 * @param tipoMercancia
	 */
	public Camion(String matricula, String numBastidor, String color, int numeroAsientos, int precio, String marca,
			String modelo, String fecha, String carga, String tipoMercancia) {
		super(matricula, numBastidor, color, numeroAsientos, precio, marca, modelo, fecha);
		this.carga = carga;
		this.tipoMercancia = tipoMercancia;

	}

	/**
	 * Devuelve la carga
	 * 
	 * @return carga
	 */
	public String getCarga() {
		return carga;
	}

	/**
	 * Cambia el valor de la carga
	 * 
	 * @param carga
	 */
	public void setCarga(String carga) {
		this.carga = carga;
	}

	/**
	 * Devuelve el tipo de mercancia
	 * 
	 * @return tipo de mercancia
	 */
	public String getTipoMercancia() {
		return tipoMercancia;
	}

	/**
	 * Cambia el tipo de mercancia
	 * @param tipoMercancia
	 */
	public void setTipoMercancia(String tipoMercancia) {
		this.tipoMercancia = tipoMercancia;
	}

}
