package com.zubiri;

import java.sql.*;

public class Conn {
	public static Connection conn = null;

	/**
	 * Inicia la conexion
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void startConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		String oracleURL = "jdbc:mysql://localhost/challenge?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

		conn = DriverManager.getConnection(oracleURL, "dw18", "dw18");
	}

	/**
	 * Devuelve la lista de coches en una tabla
	 * 
	 * @return lista de coches
	 * @throws SQLException
	 */
	public String listarCoches() throws SQLException {
		PreparedStatement pst = conn.prepareStatement(
				"select s.id_serie,v.matricula,v.numero_bastidor,v.color,v.numero_asientos,v.precio,s.marca,s.modelo,s.fecha_fabricacion,c.numero_puertas,c.capacidad_maletero from vehiculos v,serie s,coches c where s.id_serie=v.id_serie and v.matricula=c.matricula and v.disponibilidad=true order by s.id_serie;");
		ResultSet result = pst.executeQuery();
		String text = "<center><h3>Coches</h3><table>" + "<tr>"
				+ "<th>Id serie</th><th>Matricula</th><th>Numero de bastidor</th><th>Color</th><th>Numero de Asientos</th><th>Precio</th><th>Marca</th><th>Modelo</th><th>Fecha de fabricación</th><th>Número de puertas</th><th>Capacidad maletero</th></tr>";
		while (result.next()) {
			text = text + "<tr><td>" + result.getInt(1) + "</td><td>" + result.getString(2) + "</td><td>"
					+ result.getString(3) + "</td><td>" + result.getString(4) + "</td><td>" + result.getInt(5)
					+ "</td><td>" + result.getInt(6) + "</td><td>" + result.getString(7) + "</td><td>"
					+ result.getString(8) + "</td><td>" + result.getDate(9) + "</td><td>" + result.getInt(10)
					+ "</td><td>" + result.getInt(11) + "</td><td><a href='Pintar.jsp?matricula=" + result.getString(2)
					+ "'>Pintar</a></td><td><a href='Vender.jsp?matricula=" + result.getString(2)
					+ "'>Vender</a></td></tr>";
		}
		text = text + "</table><br><a href='ComprarCoche.jsp'>Comprar un nuevo coche</a></center>";

		return text;
	}

	/**
	 * Devuelve la lista de camiones en una tabla
	 * 
	 * @return lista de camiones
	 * @throws SQLException
	 */
	public String listarCamiones() throws SQLException {
		PreparedStatement pst = conn.prepareStatement(
				"select s.id_serie,v.matricula,v.numero_bastidor,v.color,v.numero_asientos,v.precio,s.marca,s.modelo,s.fecha_fabricacion,c.carga,c.tipo_mercancia from vehiculos v,serie s,camiones c where s.id_serie=v.id_serie and v.matricula=c.matricula and v.disponibilidad=true order by s.id_serie;");
		ResultSet result = pst.executeQuery();
		String text = "<center><h3>Camiones</h3><table>" + "<tr>"
				+ "<th>Id serie</th><th>Matricula</th><th>Numero de bastidor</th><th>Color</th><th>Numero de Asientos</th><th>Precio</th><th>Marca</th><th>Modelo</th><th>Fecha de fabricación</th><th>Carga</th><th>Tipo de mercancia</th></tr>";
		while (result.next()) {
			text = text + "<tr><td>" + result.getInt(1) + "</td><td>" + result.getString(2) + "</td><td>"
					+ result.getString(3) + "</td><td>" + result.getString(4) + "</td><td>" + result.getInt(5)
					+ "</td><td>" + result.getInt(6) + "</td><td>" + result.getString(7) + "</td><td>"
					+ result.getString(8) + "</td><td>" + result.getDate(9) + "</td><td>" + result.getInt(10)
					+ "</td><td>" + result.getString(11) + "</td><td><a href='Pintar.jsp?matricula="
					+ result.getString(2) + "'>Pintar</a></td><td><a href='Vender.jsp?matricula=" + result.getString(2)
					+ "'>Vender</a></td></tr>";
		}
		text = text + "</table><br><a href='ComprarCamion.jsp'>Comprar un nuevo camion</a></center>";
		return text;
	}

	/**
	 * Devuelve el color de un coche dada la matricula
	 * 
	 * @param matricula
	 * @return color del coche
	 * @throws SQLException
	 */
	public String getColor(String matricula) throws SQLException {
		String color = "";
		PreparedStatement pst = conn.prepareStatement("select color from vehiculos where matricula=?; ");
		pst.setString(1, matricula);
		ResultSet result = pst.executeQuery();
		while (result.next()) {
			color = result.getString(1);
		}
		return color;

	}

	/**
	 * Cambia el color de un coche dada la matricula
	 * 
	 * @param matricula
	 * @param color
	 * @return 1 si ha funcionado, 0 si no
	 * @throws SQLException
	 */
	public int pintarVehiculo(String matricula, String color) throws SQLException {

		PreparedStatement pst;
		pst = conn.prepareStatement("update vehiculos set color=? where matricula=?;");
		pst.setString(1, color);
		pst.setString(2, matricula);
		return pst.executeUpdate();

	}

	/**
	 * Devuelve el id de una serie
	 * 
	 * @param marca
	 * @param modelo
	 * @param fecha
	 * @return id de la serie, 0 si no se ha encontrado
	 * @throws SQLException
	 */
	public int buscarSerie(String marca, String modelo, String fecha) throws SQLException {
		PreparedStatement pst = conn
				.prepareStatement("select * from serie where marca=? and modelo=? and fecha_fabricacion=?;");

		pst.setString(1, marca);
		pst.setString(2, modelo);
		pst.setString(3, fecha);
		ResultSet result = pst.executeQuery();
		if (result.next()) {
			return result.getInt(1);
		} else {
			return 0;
		}
	}

	/**
	 * Añade una serie
	 * 
	 * @param marca
	 * @param modelo
	 * @param fecha
	 * @return 1 si ha funcionado, 0 si no
	 * @throws SQLException
	 */
	public int añadirSerie(String marca, String modelo, String fecha) throws SQLException {
		PreparedStatement pst = conn
				.prepareStatement("insert into serie(marca,modelo,fecha_fabricacion) values(?,?,?);");
		pst.setString(1, marca);
		pst.setString(2, modelo);
		pst.setString(3, fecha);
		return pst.executeUpdate();
	}

	/**
	 * Añade un nuevo coche
	 * 
	 * @param coche
	 * @throws SQLException
	 */
	public void comprarCoche(Coche coche) throws SQLException {
		if (buscarSerie(coche.getMarca(), coche.getModelo(), coche.getFechaFabricacion()) == 0) {
			añadirSerie(coche.getMarca(), coche.getModelo(), coche.getFechaFabricacion());
		}

		int id_serie = buscarSerie(coche.getMarca(), coche.getModelo(), coche.getFechaFabricacion());

		PreparedStatement pst = conn.prepareStatement("insert into vehiculos values(?,?,?,?,?,?,?);");
		pst.setString(1, coche.getMatricula());
		pst.setString(2, coche.getNumeroBastidor());
		pst.setString(3, coche.getColor());
		pst.setInt(4, coche.getNumeroAsientos());
		pst.setInt(5, id_serie);
		pst.setInt(6, coche.getPrecio());
		pst.setBoolean(7, true);
		pst.executeUpdate();

		PreparedStatement pst2 = conn.prepareStatement("insert into coches values(?,?,?);");
		pst2.setString(1, coche.getMatricula());
		pst2.setInt(2, coche.getNumeroPuertas());
		pst2.setString(3, coche.getCapacidadMaletero());
		pst2.executeUpdate();
	}

	/**
	 * Añade un nuevo camion
	 * 
	 * @param camion
	 * @throws SQLException
	 */
	public void comprarCamion(Camion camion) throws SQLException {
		if (buscarSerie(camion.getMarca(), camion.getModelo(), camion.getFechaFabricacion()) == 0) {
			añadirSerie(camion.getMarca(), camion.getModelo(), camion.getFechaFabricacion());
		}

		int id_serie = buscarSerie(camion.getMarca(), camion.getModelo(), camion.getFechaFabricacion());

		PreparedStatement pst = conn.prepareStatement("insert into vehiculos values(?,?,?,?,?,?,?);");
		pst.setString(1, camion.getMatricula());
		pst.setString(2, camion.getNumeroBastidor());
		pst.setString(3, camion.getColor());
		pst.setInt(4, camion.getNumeroAsientos());
		pst.setInt(5, id_serie);
		pst.setInt(6, camion.getPrecio());
		pst.setBoolean(7, true);
		pst.executeUpdate();

		PreparedStatement pst2 = conn.prepareStatement("insert into camiones values(?,?,?);");
		pst2.setString(1, camion.getMatricula());
		pst2.setString(2, camion.getCarga());
		pst2.setString(3, camion.getTipoMercancia());
		pst2.executeUpdate();
	}

	/**
	 * Comprueba si el formato de la matricula es correcto
	 * 
	 * @param matricula
	 * @return true si es correcto, false si es incorrecto
	 */
	public boolean comprobarMatricula(String matricula) {
		boolean result = true;
		if (matricula.length() == 7) {
			char[] ma = matricula.toCharArray();
			for (int i = 0; i < 4; i++) {
				if (!Character.isDigit(ma[i])) {
					result = false;
				}
			}
			for (int i = 4; i < 7; i++) {
				if (!Character.isLetter(ma[i])) {
					result = false;
				} else if (!Character.isUpperCase(ma[i])) {
					result = false;
				}
			}
		} else {
			result = false;
		}

		return result;
	}

	/**
	 * Comprueba que el formato del numero de bastidor es correcto
	 * 
	 * @param bastidor
	 * @return true si es correcto, false si es incorrecto
	 */
	public boolean comprobarNumeroBastidor(String bastidor) {
		boolean result = true;

		if (bastidor.length() == 17) {
			if (!bastidor.matches("[A-Z0-9]+")) {
				result = false;
			}
		} else {
			result = false;
		}

		return result;

	}

	/**
	 * Comprueba que un String esta solo formada por digitos
	 * 
	 * @param num
	 * @return true si es correcto, false si es incorrecto
	 */
	public boolean comprobarNumero(String num) {
		boolean result = true;
		char[] numero = num.toCharArray();
		for (int i = 0; i < numero.length; i++) {
			if (!Character.isDigit(numero[i])) {
				result = false;
			}
		}
		return result;
	}

	/**
	 * Comprueba si el formato de la fecha es correcto
	 * 
	 * @param fecha
	 * @return
	 */
	public boolean comprobarFecha(String fecha) {
		boolean result = true;
		if (fecha.length() == 10) {
			char[] date = fecha.toCharArray();
			for (int i = 0; i < 4; i++) {
				if (!Character.isDigit(date[i])) {
					result = false;
				}
			}
			for (int i = 5; i < 7; i++) {
				if (!Character.isDigit(date[i])) {
					result = false;
				}
			}
			for (int i = 8; i < 10; i++) {
				if (!Character.isDigit(date[i])) {
					result = false;
				}
			}
		} else {
			result = false;
		}

		return result;
	}

	/**
	 * Comprueba si ls mercancia es de los tipos disponibles
	 * 
	 * @param mercancia
	 * @return true si es correcto, false si es incorrecto
	 */
	public boolean comprobarMercancia(String mercancia) {
		boolean result = true;
		if (!mercancia.equals("G") && !mercancia.equals("A") && !mercancia.equals("P")) {
			result = false;
		}
		return result;
	}

	/**
	 * Comprueba que todos los atributos son correctos utilizando los metodos
	 * anteriores
	 * 
	 * @param matricula
	 * @param numBastidor
	 * @param numeroAsientos
	 * @param precio
	 * @param fecha
	 * @param numeroPuertas
	 * @return true si es correcto, false si es incorrecto
	 */
	public boolean comprobarCoche(String matricula, String numBastidor, String numeroAsientos, String precio,
			String fecha, String numeroPuertas) {
		if (comprobarMatricula(matricula) && comprobarNumeroBastidor(numBastidor) && comprobarNumero(numeroAsientos)
				&& comprobarNumero(precio) && comprobarFecha(fecha) && comprobarNumero(numeroPuertas)) {
			return true;
		}

		else {
			return false;
		}

	}

	/**
	 * Comprueba que todos los atributos son correctos utilizando los metodos
	 * anteriores
	 * 
	 * @param matricula
	 * @param numBastidor
	 * @param numeroAsientos
	 * @param precio
	 * @param fecha
	 * @param carga
	 * @param tipoMercancia
	 * @return true si es correcto, false si es incorrecto
	 */
	public boolean comprobarCamion(String matricula, String numBastidor, String numeroAsientos, String precio,
			String fecha, String carga, String tipoMercancia) {

		if (comprobarMatricula(matricula) && comprobarNumeroBastidor(numBastidor) && comprobarNumero(numeroAsientos)
				&& comprobarNumero(precio) && comprobarFecha(fecha) && comprobarNumero(carga)
				&& comprobarMercancia(tipoMercancia)) {
			return true;
		}

		else {
			return false;
		}

	}

	/**
	 * Vende un coche dada la matricula
	 * 
	 * @param matricula
	 * @return 1 si es correcto, 0 si es incorrecto
	 * @throws SQLException
	 */
	public int venderVehiculo(String matricula) throws SQLException {
		PreparedStatement pst;
		pst = conn.prepareStatement("update vehiculos set disponibilidad=? where matricula=?;");
		pst.setBoolean(1, false);
		pst.setString(2, matricula);
		return pst.executeUpdate();

	}

	/**
	 * Devuelve la lista de coches en una tabla dado un color
	 * 
	 * @param color
	 * @return lista de coches
	 * @throws SQLException
	 */
	public String listarCochesColor(String color) throws SQLException {
		String c = color;
		PreparedStatement pst = conn.prepareStatement(
				"select s.id_serie,v.matricula,v.numero_bastidor,v.color,v.numero_asientos,v.precio,s.marca,s.modelo,s.fecha_fabricacion,c.numero_puertas,c.capacidad_maletero from vehiculos v,serie s,coches c where s.id_serie=v.id_serie and v.matricula=c.matricula and v.disponibilidad=true and v.color=? order by s.id_serie;");
		pst.setString(1, c);
		ResultSet result = pst.executeQuery();
		String text = "<center><h3>Coches</h3><table>" + "<tr>"
				+ "<th>Id serie</th><th>Matricula</th><th>Numero de bastidor</th><th>Color</th><th>Numero de Asientos</th><th>Precio</th><th>Marca</th><th>Modelo</th><th>Fecha de fabricación</th><th>Número de puertas</th><th>Capacidad maletero</th></tr>";
		while (result.next()) {
			text = text + "<tr><td>" + result.getInt(1) + "</td><td>" + result.getString(2) + "</td><td>"
					+ result.getString(3) + "</td><td>" + result.getString(4) + "</td><td>" + result.getInt(5)
					+ "</td><td>" + result.getInt(6) + "</td><td>" + result.getString(7) + "</td><td>"
					+ result.getString(8) + "</td><td>" + result.getDate(9) + "</td><td>" + result.getInt(10)
					+ "</td><td>" + result.getInt(11) + "</td><td><a href='Pintar.jsp?matricula=" + result.getString(2)
					+ "'>Pintar</a></td><td><a href='Vender.jsp?matricula=" + result.getString(2)
					+ "'>Vender</a></td></tr>";
		}
		text = text + "</table>";

		return text;
	}

	/**
	 * Devuelve la lista de camiones dado un color
	 * 
	 * @param color
	 * @return lista de camiones
	 * @throws SQLException
	 */
	public String listarCamionesColor(String color) throws SQLException {
		String c = color;
		PreparedStatement pst = conn.prepareStatement(
				"select s.id_serie,v.matricula,v.numero_bastidor,v.color,v.numero_asientos,v.precio,s.marca,s.modelo,s.fecha_fabricacion,c.carga,c.tipo_mercancia from vehiculos v,serie s,camiones c where s.id_serie=v.id_serie and v.matricula=c.matricula and v.disponibilidad=true and v.color=? order by s.id_serie;");
		pst.setString(1, c);
		ResultSet result = pst.executeQuery();
		String text = "<center><h3>Camiones</h3><table>" + "<tr>"
				+ "<th>Id serie</th><th>Matricula</th><th>Numero de bastidor</th><th>Color</th><th>Numero de Asientos</th><th>Precio</th><th>Marca</th><th>Modelo</th><th>Fecha de fabricación</th><th>Carga</th><th>Tipo de mercancia</th></tr>";
		while (result.next()) {
			text = text + "<tr><td>" + result.getInt(1) + "</td><td>" + result.getString(2) + "</td><td>"
					+ result.getString(3) + "</td><td>" + result.getString(4) + "</td><td>" + result.getInt(5)
					+ "</td><td>" + result.getInt(6) + "</td><td>" + result.getString(7) + "</td><td>"
					+ result.getString(8) + "</td><td>" + result.getDate(9) + "</td><td>" + result.getInt(10)
					+ "</td><td>" + result.getString(11) + "</td><td><a href='Pintar.jsp?matricula="
					+ result.getString(2) + "'>Pintar</a></td><td><a href='Vender.jsp?matricula=" + result.getString(2)
					+ "'>Vender</a></td></tr>";
		}
		text = text + "</table><br><a href='Lista.jsp'>Volver a la lista completa</a></br>";

		return text;
	}

	public String cocheCamion(String matricula) throws SQLException {
		PreparedStatement pst = conn.prepareStatement("select * from coches where matricula=?;");
		pst.setString(1, matricula);
		ResultSet result = pst.executeQuery();
		if (result.next()) {
			return "coche";
		} else {
			return "camion";
		}

	}

	public Camion buscarCamion(String matricula) throws SQLException {
		PreparedStatement pst = conn.prepareStatement(
				"select v.matricula,v.numero_bastidor,v.color,v.numero_asientos,v.precio,s.marca,s.modelo,s.fecha_fabricacion,c.carga,c.tipo_mercancia from vehiculos v,serie s,camiones c where s.id_serie=v.id_serie and v.matricula=c.matricula and v.matricula=?;");
		pst.setString(1, matricula);
		ResultSet result = pst.executeQuery();
		if (result.next()) {
			Camion camion = new Camion(result.getString(1), result.getString(2), result.getString(3), result.getInt(4),
					result.getInt(5), result.getString(6), result.getString(7), result.getString(8),
					result.getString(9), result.getString(10));
			return camion;
		}

		return null;

	}

	public Coche buscarCoche(String matricula) throws SQLException {
		PreparedStatement pst = conn.prepareStatement(
				"select v.matricula,v.numero_bastidor,v.color,v.numero_asientos,v.precio,s.marca,s.modelo,s.fecha_fabricacion,c.numero_puertas,c.capacidad_maletero from vehiculos v,serie s,coches c where s.id_serie=v.id_serie and v.matricula=c.matricula and v.matricula=?;");
		pst.setString(1, matricula);
		ResultSet result = pst.executeQuery();
		if (result.next()) {
			Coche coche = new Coche(result.getString(1), result.getString(2), result.getString(3), result.getInt(4),
					result.getInt(5), result.getString(6), result.getString(7), result.getString(8), result.getInt(9),
					result.getString(10));
			return coche;
		}

		return null;

	}

}
