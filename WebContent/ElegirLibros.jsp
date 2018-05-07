<%@page import="modelos.LibroDAO"%>
<%@page import="modelos.TemaDAO"%>
<%@page import="beans.Libro"%>
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
<h2>LISTA DE LIBROS</h2>

<%List<Libro> lista2 =(List<Libro>) request.getAttribute("libros");%>
<form action="ControlLibros?opcion=add" method="post">

<%for (Libro ele:lista2){%>
	<input type="checkbox" name="titulo" value="<%=ele.getIsbn()%>"> <%=ele.getTitulo()%><br/>

<%} %>
<input type="submit" name="boton" value="Enviar"><br/><br/>
</form>


<a href=ControlLibros?opcion=temas>Volver a ver Temas</a>


</center></body>
</html>