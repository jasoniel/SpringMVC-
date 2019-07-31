<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de produtos</title>
</head>
<body>

		
<!-- 

	<c:forEach items="${requestScope['org.springframework.validation.BindingResult.product'].allErrors}"
			   var="error">
			${error.code}<br />
	</c:forEach>
 -->
		<form:form method="post" action="/casadocodigo/produtos" commandName="product">
			<div>
				<label for="title"> Titulo</label>
				<form:input path="title" />
				<form:errors path="title" />
			</div>
			
			<div>
				<label for="description">Descrição</label>
				<form:textarea path="description" rows="10" cols="20" />
				<form:errors path="description" />
			</div>
			<div>
				<label for="pages">Número de paginas</label>
				<input type="text" name="pages" id="pages">
				<form:errors path="pages" />
			</div>
					
			
			<c:forEach items="${types}" var="bookType" varStatus="status">
				<div>
					<label for="price_${bookType}">${bookType}</label>
					<input type="text" name="prices[${status.index}].value" id="price_${bookType}">
					<input type="hidden" name="prices[${status.index}].bookType" value="${bookType}" />
				</div>
				
			</c:forEach>
			
			<div>
			
				<label for="releaseDate">Data de Lançamento</label>
				<input type="date" name="releaseDate" />
				<form:errors path="releaseDate" />
			</div>
			
			<div>
				<input type="submit" value="Enviar">
			</div>
		</form:form>
</body>
</html>