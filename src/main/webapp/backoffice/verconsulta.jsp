<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/templates/head.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- Sacamos en pantalla los datos recibidos en este caso la localidad -->

<c:forEach items="${localidad}" var="localidad">

<h1 class="text-center">Resultado de la busqueda de codigo postal:</h1>

<h3 class="text-center">El codigo postal pertenece a la localidad de:</h3>

<h4 class="text-center"><c:out value="${localidad}" /></h4>

</c:forEach>


</body>
</html>