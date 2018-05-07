<%@page import="beans.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{
background-color:#9FEAD9
}
</style>
</head>
<body><center>
<h2>DATOS CLIENTE</h2>
	<table border='1'>
<tr>
<th>Nombre</th><th>Apellido</th><th>Dirección</th><th>Fecha de alta</th><th>Contraseña</th><th>Tipo de Usuario</th>
</tr>

<tr>
<td><%=request.getAttribute("nombre") %></td>
<td><%=request.getAttribute("apellido") %></td>
<td><%=request.getAttribute("direccion")%></td>
<td><%=request.getAttribute("fechaAlta")%></td>
<td><%=request.getAttribute("password")%></td>
<td><%=request.getAttribute("tipoUsuario")%></td>
</tr>

</table>
</center></body>
</html>