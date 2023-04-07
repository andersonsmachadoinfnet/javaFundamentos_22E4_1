<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html  lang="pt-br">
<head>
  	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de medicamentos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<div class="container">
	    <c:if test="${not empty mensagem}">
			<div class="alert alert-danger" role="alert">
			  ${mensagem} 
			</div>
		</c:if>
		<form action="/medicamento" method="get">
			<h3>Listagem de Medicamentos:</h3>

			<button type="submit">Novo</button>
		</form>

		<c:if test="${empty medicamentos}">
			<h5>Não existem medicamentos cadastrados!</h5>
		</c:if>
		<c:if test="${not empty medicamentos}">
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>Exame</th>
			      <th>Valor R$</th>
			      <c:if test="${usuario.tipo==0}">
			      	<th></th>
			      </c:if>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach var="u" items="${medicamentos}">
			  	<tr>
			      <td><c:out value="${u.descricao}" /></td>
			      <td><c:out value="${u.valor}" /></td>
			      <td><c:out value="${u.bula}" /></td>
			      <c:if test="${usuario.tipo==0}">
			      	<td><a href="/medicamento/${u.id}/excluir">excluir</a></td>
			      </c:if>
			    </tr>
			  </c:forEach>
			  </tbody>
			</table>
			<h5>Total cadastrados: ${medicamentos.size()}</h5>
		</c:if>
	</div>
	

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>