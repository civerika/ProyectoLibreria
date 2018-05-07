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
 <% Object[] estadisticas = (Object[])request.getAttribute("estadisticas"); %>
 <h4>Estadisticas de Cliente</h4>
 <Table border="5">
 <th>Libros comprados</th><th>Temas distintos</th><th>Importe Total</th>
 </th>
 <th>
 <%for(int i=0; i<estadisticas.length;i++){%>
 <td align"center"> <%=estadisticas[i]%></td>
	
 <%}%>
  </th>
 </Table>
<a href=Admon.jsp>Volver a vista Administrador</a><br/>

</center></body>
</html>