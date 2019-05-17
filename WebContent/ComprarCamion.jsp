<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		<%@page import="java.sql.*"%>
	<%@page import="com.zubiri.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Comprar Camión</title>
</head>
<body style="text-align:center">
	<%
		if (request.getParameter("submit") != null) {
			
			
			
			Conn co = new Conn();
			co.startConnection();
			if(co.comprobarCamion(request.getParameter("matricula"),request.getParameter("numBastidor"),request.getParameter("numAsientos"),request.getParameter("precio"),request.getParameter("fecha"),request.getParameter("carga"),request.getParameter("mercancia"))){
			String marca=request.getParameter("marca");
			String modelo=request.getParameter("modelo");
			Camion camion=new Camion(request.getParameter("matricula"),Integer.parseInt(request.getParameter("numBastidor")),request.getParameter("color"),Integer.parseInt(request.getParameter("numAsientos")),Integer.parseInt(request.getParameter("precio")),request.getParameter("marca"),request.getParameter("modelo"),request.getParameter("fecha"),request.getParameter("carga"),request.getParameter("mercancia"));
			co.comprarCamion(camion);
			%>
			Has comprado un camion <%=marca%> <%=modelo%><br>
			<a href="Lista.jsp">Ver lista de vehiculos</a>
			<%

		}
			else{
				%>
				Algun dato es erroneo<br>
				<a href="ComprarCamion.jsp">Volver al formulario</a>
				<%
			}
		
		} else {
	
	%>
	<form action="ComprarCamion.jsp" method="get">
		Matricula <input type="text" name="matricula"><br> <br> 
		Número de bastidor <input type="number" name="numBastidor">  <br> <br> 
		Color <input type="text" name="color"><br> <br> 
		Número de asientos <input type="number" name="numAsientos"><br> <br> 
		Precio <input type="text" name="precio"><br> <br> 
		Marca <input type="text" name="marca"><br> <br> 
		Modelo <input type="text" name="modelo"><br> <br> 
		Fecha de fabricación (aaaa-mm-dd) <input type="text" name="fecha"><br><br>  
		Carga <input type="text" name="carga"><br> <br> 
		Tipo de mercancia <input list="tipo" name="mercancia">
		<datalist id="tipo">
			<option value="G">
			<option value="A">
			<option value="P">
		</datalist><br> <br> 		
		<input type="submit" name="submit" value="Comprar">
	</form>
	<%
		}
	%>
</body>
</html>