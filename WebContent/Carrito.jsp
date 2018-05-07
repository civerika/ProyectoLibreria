<%@page import="beans.LineaPedido"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body{
background-color:#9FEAD9
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><center>
<h2>CARRITO</h2><br/>

	<table border='1'>
<tr>
<th>Libro</th><th>Cantidad</th><th>Precio Venta</th><th>Importe</th><th>Eliminar libro</th>
</tr>
<%List<LineaPedido>lista3 = (List<LineaPedido>)session.getAttribute("lista3"); 
  double producto=0, acumulador=0;%>
<% %>
<%for (LineaPedido ele: lista3){ %>
	<%producto=ele.getCantidad().multiply(ele.getPrecioVenta()).doubleValue(); %>
<tr>
<td><%=ele.getLibro().getTitulo() %></td>
<td><%=ele.getCantidad()%></td>
<td><%=ele.getPrecioVenta()%></td>
<td><%=producto%></td>
<td><a href="GestionCarrito?opcion=eliminar&isbn=<%=lista3.indexOf(ele) %>">Eliminar</a></td>
</tr>
<%acumulador += producto; %>
<%} %>

</table>

<h3>Total Importe <%=acumulador %></h3>

	<a href="GestionCarrito?opcion=comprar"">Comprar</a><br/>
	<a href="GestionCarrito?opcion=borrarCarrito">Vaciar carrito</a><br/>
	<a href="ControlLibros?opcion=temas">Ver temas</a><br/>
	<a href="MenuCliente.jsp">Volver menu cliente</a><br/>
  	<a href="Index.html">Cerrar sesión</a>
</center></body>
</html>