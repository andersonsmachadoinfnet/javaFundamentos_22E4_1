<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html  lang="pt-br">
<head>
  	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Medicamentos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<div class="container">
		<form action="/medicamento/incluir" method="post">
			<h3>Cadastro de medicamentos</h3>
		
			<div class="form-group">
				<label>Descrição:</label> 	
				<input type="text" name="descricao" value="" placeholder="Ex: Novalgina Gotas 20ml" class="form-control" required>
			</div>
			
			<div class="form-group">
				<label>Valor:</label>
				<input type="number" name="valor" value="" placeholder="Ex: 4,99" class="form-control" required>
			</div>
			
			<div class="form-group">
				<label>Bula:</label>
				<textarea name="bula" value="" placeholder="Ex: Procedimento para retirada das amígdalas e indicado para paciêntes com crizes constantes" class="form-control"></textarea>
			</div>
			
			<button type="submit">Cadastrar</button>
		</form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>