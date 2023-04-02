<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html  lang="pt-br">
<head>
  	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Paciente</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<div class="container">
		<c:if test="${empty paciente}">
			<form action="/paciente/cep" method="post">
				<div class="form-inline">
					<label>Consulta de CEP:</label>
					<input type="text" name="cep" value="" placeholder="Ex: 24000-000" class="form-control">
				</div>
				<button type="submit">Consultar</button>
			</form>
		</c:if>
		<form action="/paciente/incluir" method="post">
			<h3>Cadastro do Paciente</h3>
		
			<div class="form-group">
				<label>Nome:</label> 	
				<input type="text" name="nome" value="" placeholder="Ex: José, Maria" class="form-control" required>
			</div>
			
			<div class="form-group">
				<label>CPF:</label> 	
				<input type="text" name="cpf" value="" placeholder="12.345.678-90" class="form-control" required>
			</div>
			
			<div class="form-group">
				<label>E-mail:</label> 	
				<input type="email" name="email" value="" placeholder="Ex: fulano@gmail.com" class="form-control" required>
			</div>
			
			<!--  
			<div class="form-group">
				<label>Data de Nascimento:</label> 	
				<input type="date" name="dtNasc" value="" placeholder="01/01/2000" class="form-control" required>
			</div>
			-->
			
			<div class="form-group">
				<label>logradouro:</label>
				<input type="text" name="logradouro" value="${endereco.logradouro}" placeholder="Ex: Rua x" class="form-control">
			</div>
			
			<div class="form-group">
				<label>Bairro:</label>
				<input type="text" name="bairro" value="${endereco.bairro}" placeholder="Cascadura" class="form-control">
			</div>
			
			<div class="form-group">
				<label>Localidade:</label>
				<input type="text" name="localidade" value="${endereco.localidade}" placeholder="centro..." class="form-control">
			</div>
			
			<div class="form-group">
				<label>Complemento:</label>
				<input type="text" name="complemento" value="${endereco.complemento}" placeholder="Apto, casa xxx" class="form-control">
			</div>
			
			<div class="form-group">
				<label>UF:</label>
				<input type="text" name="uf" value="${endereco.uf}" placeholder="RJ, SP..." class="form-control">
			</div>
			
			
			<button type="submit">Cadastrar</button>
		</form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>