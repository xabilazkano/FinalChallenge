<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="com.zubiri.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pintar</title>
</head>
<body style="text-align:center">

	<%
		Conn co = new Conn();
		co.startConnection();
		if (request.getParameter("submit") != null) {

			String matricula = request.getParameter("matricula");
			String color = request.getParameter("color");
			if (co.pintarVehiculo(matricula, color) > 0) {
	%>

	Has cambiado el color del vehiculo
	<%=matricula%>
	a
	<%=color%><br>
	<a href="Lista.jsp">Enseñar lista de vehiculos</a>
	<%
		}

		} else {
			String matricula = request.getParameter("matricula");
			String color = co.getColor(matricula);
	%>
	<form action="Pintar.jsp" method="get">
		Nuevo color <input type="text" name="color" value="<%=color%>"> <input
			type="hidden" name="matricula" value="<%=matricula%>"> <input
			type="submit" name="submit" value="Pintar">
	</form>
	<%
		}
	%>
	
</body>
</html>