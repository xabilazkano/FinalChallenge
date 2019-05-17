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
<body style="text-align:center">

	<%
		Conn co = new Conn();
		co.startConnection();
		String matricula=request.getParameter("matricula");
		if (co.venderCoche(matricula)>0){
			%>
			
			Has vendido el vehiculo con la matricula <%=matricula%><br>
			<a href="Lista.jsp">Ver lista de vehiculos</a>
			
			<%
			
			
		}
	%>
	
</body>
</html>