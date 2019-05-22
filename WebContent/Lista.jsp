<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="java.sql.*"%>
	<%@page import="com.zubiri.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar vehiculos</title>
</head>
<body style="text-align:center">

	<form action="Lista.jsp" method="get">
		Color a elegir <input type="text" name="color"> <input
			type="submit" name="submit" value="Filtrar">
	</form>
	<%
		Conn co = new Conn();
		co.startConnection();
		String coches = "";
		String camiones = "";
		if (request.getParameter("submit") != null) {
			String color = request.getParameter("color");
			coches = co.listarCochesColor(color);
			camiones = co.listarCamionesColor(color);
		} else {

			coches = co.listarCoches();
			camiones = co.listarCamiones();
		}
	%>
	<%=coches%>
	<%=camiones%>

	</body>
</html>