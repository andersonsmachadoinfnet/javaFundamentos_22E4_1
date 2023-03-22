<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TP1</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<div class="container-fluid bg-white">
	
        <div class="container">
        
        <div class="alert alert-warning alert-dismissible fade show" role="alert">
		  Site desenvolvido para o TESTE DE PERFORMANCE - TP3, 
		  disciplina Desenvolvimento de Serviços em Nuvem com Java [23E1_4].</br>
		  Prof. Rubens Lopes de Oliveira
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
        
	</div>
	
        </div>
    </div>
    
    <footer class="bg-light py-5">
      <div class="container px-4 px-lg-5">
        <div class="small text-center text-muted">
          <strong>INSTITUTO INFNET</strong></br>
          Copyright &copy; 2023 - Anderson Machado
        </div>
      </div>
    </footer>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>