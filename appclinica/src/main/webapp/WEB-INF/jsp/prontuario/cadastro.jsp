<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html  lang="pt-br">
<head>
  	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro do Prontuário</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<div class="container">
		<form action="/prontuario/incluir" method="post">
			<h3>Cadastro do Prontuário</h3>
		
			<div class="form-group">
				<label>Descrição:</label> 	
				<input type="text" name="descricao" value="Descrição do prontuário..." class="form-control">
			</div>
			
			<div class="form-group">
				<label>Características:</label>
			    <div class="form-check">
			      <label class="form-check-label">
			        <input type="checkbox" name="web" value="true" class="form-check-input" > Atendimento Web
			      </label>
			    </div>
			</div>
			
<!-- 			<div class="form-group"> -->
<!-- 				<label>Data:</label> 	 -->
<!-- 				<input type="text" name="data" value="16/03/2023" class="form-control"> -->
<!-- 			</div> -->
			
			<div class="form-group">
				<c:if test="${not empty pacientes}">
					<label>Pacientes:</label>
					<select name="paciente.id" class="form-control">
						<c:forEach var="p" items="${pacientes}">
							<option value="${p.id}">${p.nome}</option>
						</c:forEach>
					</select>
				</c:if>
				<c:if test="${empty pacientes}">
					<c:set var="botao" value="disabled"/>
					<label>Não existem pacientes cadastrados!</label>
				</c:if>
			</div>
			
			<div class="form-group">
				<c:if test="${not empty procedimentos}">
					<label>Procedimentos:</label>
				    <c:forEach var="p" items="${procedimentos}">
				    <div class="form-check">
				      <label class="form-check-label">
			        		<input type="checkbox" name="procedimentos" value="${p.id}" class="form-check-input"> ${p.descricao}. Valor: R$ ${p.valor}
				      </label>
				    </div>
				    </c:forEach>
				</c:if>
				<c:if test="${empty procedimentos}">
					<c:set var="botao" value="disabled"/>
					<label>Não existem procedimentos cadastrados!</label>
				</c:if>
			</div>
			
			<button type="submit">Cadastrar</button>
		</form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>