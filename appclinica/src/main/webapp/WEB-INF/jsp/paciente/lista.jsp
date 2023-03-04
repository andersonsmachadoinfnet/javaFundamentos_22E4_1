<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html  lang="pt-br">
<head>
  	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Pacientes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<div class="container">
		<form action="/paciente" method="get">
			<h3>Listagem de pacientes:</h3>

			<button type="submit">Novo</button>
		</form>

		<c:if test="${empty pacientes}">
			<h5>Não existem pacientes cadastrados!</h5>
		</c:if>
		<c:if test="${not empty pacientes}">
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>Nome</th>
			      <th>CPF</th>
			      <th>Email</th>
			      <th>DtNasc</th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach var="u" items="${pacientes}">
			  	<tr>
			      <td><c:out value="${u.nome}" /></td>
			      <td><c:out value="${u.cpf}" /></td>
			      <td><c:out value="${u.email}" /></td>
			      <td><c:out value="${u.dtNasc}" /></td>
			      <td><a href="/paciente/${u.id}/excluir">excluir</a></td>
			    </tr>
			  </c:forEach>
			  </tbody>
			</table>
			<h5>Total cadastrados: ${pacientes.size()}</h5>
		</c:if>
	</div>
	

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>