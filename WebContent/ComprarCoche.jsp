<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="com.zubiri.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Comprar Coche</title>
</head>
<h3>COMPRAR COCHE</h3>
<body>
	<%
		if (request.getParameter("submit") != null) {
			Conn co = new Conn();
			co.startConnection();
			if (co.comprobarCoche(request.getParameter("matricula"), request.getParameter("numBastidor"),
					request.getParameter("numAsientos"), request.getParameter("precio"),
					request.getParameter("fecha"), request.getParameter("numPuertas"))) {
				String marca = request.getParameter("marca");
				String modelo = request.getParameter("modelo");
				Coche coche = new Coche(request.getParameter("matricula"),
						request.getParameter("numBastidor"), request.getParameter("color"),
						Integer.parseInt(request.getParameter("numAsientos")),
						Integer.parseInt(request.getParameter("precio")), request.getParameter("marca"),
						request.getParameter("modelo"), request.getParameter("fecha"),
						Integer.parseInt(request.getParameter("numPuertas")), request.getParameter("maletero"));
				co.comprarCoche(coche);
				String cocheString = coche.cocheString();
	%>
	Has comprado un coche
	<%=cocheString %><br>
	<a href="Lista.jsp">Ver lista de vehiculos</a>
	<%
		}
			else{
				%>
				Algun dato es erroneo<br>
				<a href="ComprarCoche.jsp">Volver al formulario</a>
				<%
			}
		} else {
	%>
	<form action="ComprarCoche.jsp" method="get">
		Matricula <input type="text" name="matricula"><br> <br>
		Número de bastidor <input type="text" name="numBastidor"> <br>
		<br> Color <input type="text" name="color"><br> <br>
		Número de asientos <input type="text" name="numAsientos"><br>
		<br> Precio (&euro;) <input type="text" name="precio"><br> <br>
		Marca <input type="text" name="marca"><br> <br>
		Modelo <input type="text" name="modelo"><br> <br>
		Fecha de fabricación (aaaa-mm-dd) <input type="text" name="fecha"><br>
		<br> Número de puertas <input type="text" name="numPuertas"><br>
		<br> Capacidad de maletero (L) <input type="text" name="maletero"><br>
		<br> <input type="submit" name="submit" value="Comprar">
	</form>
	<%
		}
	%>
</body>
</html>