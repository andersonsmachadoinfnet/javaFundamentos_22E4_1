<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html  lang="pt-br">
<head>
  	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de usuários</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">Clínica ++</a>
          <button class="navbar-toggler" 
            type="button" 
            data-bs-toggle="collapse" 
            data-bs-target="#navbarSupportedContent" 
            aria-controls="navbarSupportedContent" 
            aria-expanded="false" 
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse d-flex justify-content-end" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ">
              <li class="nav-item">
                <a class="nav-link inactive" aria-current="page" href="#">Início</a>
              </li>
              <li class="nav-item">
                <a class="nav-link inactive" aria-current="page" href="#">Exames</a>
              </li>
              <li class="nav-item">
                <a class="nav-link inactive" aria-current="page" href="#">Médicos</a>
              </li>
              <li class="nav-item">
                <a class="nav-link inactive" aria-current="page" href="#">Sobre nós</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/usuario/lista">Usuários</a>
              </li> 
            </ul>
          </div>
        </div>
      </nav>
	<div class="container">
		<form action="/usuario" method="get">
			<h3>Listagem de Usuários:</h3>

			<button type="submit">Novo</button>
		</form>

		<c:if test="${empty usuarios}">
			<h5>Não existem usuários cadastrados!</h5>
		</c:if>
		<c:if test="${not empty usuarios}">
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>Nome</th>
			      <th>E-mail</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach var="u" items="${usuarios}">
			  	<tr>
			      <td><c:out value="${u.nome}" /></td>
			      <td><c:out value="${u.email}" /></td>
			    </tr>
			  </c:forEach>
			  </tbody>
			</table>
			<h5>Total cadastrados: ${usuarios.size()}</h5>
		</c:if>
	</div>
	

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>