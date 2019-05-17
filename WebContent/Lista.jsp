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
	<%
		
		Conn co = new Conn();
	co.startConnection();
	String coches=co.listarCoches();
	String camiones=co.listarCamiones();
		
	%> 
	<%=coches %>
	<%=camiones %>
	</body>
</html>