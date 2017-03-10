<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de produtos</title>
</head>
<body>
	
		<form:form action="${spring:mvcUrl('PC#save').build()}"  method="post" commandName="product">
			<div>
				<label for="title">T�tulo</label>
				<input type="text" name="title" id="title"/>			
				<form:errors path="title"/>
			</div>
			<div>
				<label for="description">Descri��o</label>
				<textarea rows="10" cols="10" name="description" id="description"></textarea>			
				<form:errors path="description"/>
			</div>
			<div>
				<label for="pages">N�mero de p�ginas</label>
				<input type="text" name="pages" id="pages"/>				
				<form:errors path="pages"/>				
			</div>
			
			<c:forEach items="${types}" var="bookType" varStatus="status">
			
				<div>
					<label for="price_${bookType}">${bookType}</label>
					<input type="text" name="prices[${status.index }].value" id="price_${bookType}">
					<input type="hidden" name="prices[${status.index}].bookType" value="${bookType}" />
				</div>
			
			</c:forEach>
			
			<div>
				<input type="submit" value="Enviar" />
			</div>
		</form:form>
		

</body>
</html>