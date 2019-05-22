<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="com.zubiri.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Comprar Coche</title>
</head>
<body style="text-align:center">
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
	%>
	Has comprado un coche
	<%=marca%>
	<%=modelo%><br>
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
		<br> Precio <input type="text" name="precio"><br> <br>
		Marca <input type="text" name="marca"><br> <br>
		Modelo <input type="text" name="modelo"><br> <br>
		Fecha de fabricación <input type="text" name="fecha"><br>
		<br> Número de puertas <input type="text" name="numPuertas"><br>
		<br> Capacidad de maletero <input type="text" name="maletero"><br>
		<br> <input type="submit" name="submit" value="Comprar">
	</form>
	<%
		}
	%>
</body>
</html>