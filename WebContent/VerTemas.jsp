<%@page import="modelos.LibroDAO"%>
<%@page import="modelos.TemaDAO"%>
<%@page import="beans.Tema"%>
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
<%List<Tema> lista =(List<Tema>) request.getAttribute("temas");%>
<h2>LISTA DE TEMAS</h2>
<form action="ControlLibros?opcion=libros" method="post">

<%for (Tema ele:lista){%>
	<input type="Radio" name="idtema" value="<%=ele.getIdTema() %>" checked> <%=ele.getDescTema() %><br/>
		
<%} %>
 
<br/>
<input type="submit" name="boton" value="Enviar"><br/><br/>
</form>
 
<a href="MenuCliente.jsp">Volver menu cliente</a>



</center></body>
</html>