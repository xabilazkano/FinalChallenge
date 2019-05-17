package com.zubiri;

import java.sql.SQLException;

public class Proba {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Conn co = new Conn();
		co.startConnection();
		System.out.println(co.comprobarMercancia("L"));
	}

}
