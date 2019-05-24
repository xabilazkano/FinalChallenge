<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="com.zubiri.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vender vehiculo</title>
</head>
<body style="text-align: center">

	<%
		Conn co = new Conn();
		co.startConnection();
		String camionString = "";
		String cocheString = "";
		String matricula = request.getParameter("matricula");
		if (co.venderVehiculo(matricula) > 0) {
			if (co.cocheCamion(matricula).equals("coche")) {
				Coche coche = co.buscarCoche(matricula);
				cocheString = coche.cocheString();
	%>

	Has vendido el coche
	<%=cocheString%><br>
	<a href="Lista.jsp">Ver lista de vehiculos</a>

	<%
		} else {
				Camion camion = co.buscarCamion(matricula);
				camionString = camion.camionString();
	%>

	Has vendido el camion
	<%=camionString%><br>
	<a href="Lista.jsp">Ver lista de vehiculos</a>

	<%
		}
		}
	%>

</body>
</html>