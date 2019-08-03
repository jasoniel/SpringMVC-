<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<p>
		${sucesso}
	</p>

	<table>
		<tr>
			<td>Titulo</td>
			<td>Valores</td>
			<td>Sumario</td>
		</tr>
		
		<c:forEach items="${products}" var="product">
			<tr>
				<td><a href="${spring:mvcUrl('PC#show').arg(0,product.id).build()}">${product.title}</a></td>

					<c:forEach items="${product.prices}" var="price">
						[ ${price.value} - ${price.bookType} ]
					</c:forEach>
				</td>
				<td>
					<a href="${product.summaryPath}">Sumário</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>