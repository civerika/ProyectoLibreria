<%@page import="beans.Pedido"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
body{
background-color:#9FEAD9

}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head><center>
<h2>BUSQUEDA DE PEDIDOS POR FECHA</h2><br/>
<%List<Pedido> listapedidofecha =(List<Pedido>) request.getAttribute("listapedidofecha");%>
<form  action="GestionAdmon?opcion=pedidosfecha"method="post">

<input type="date" name="fecha"><br/>
<input type="submit" name="boton" value="Enviar"><br/>

</form>
<a href=Admon.jsp>Volver a vista Administrador</a><br/>
</center><body>

</body>
</html>