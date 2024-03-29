<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Cl�nica ++</a>
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
          <a class="nav-link active" aria-current="page" href="/home">In�cio</a>
        </li>
        <c:if test="${not empty usuario}">
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            Procedimentos
	          </a>
	          <ul class="dropdown-menu active" aria-labelledby="navbarDropdown">
	            <li><a class="dropdown-item" href="/exame/lista">Exames</a></li>
	            <li><a class="dropdown-item" href="/medicamento/lista">Medicamentos</a></li>
	            <li><hr class="dropdown-divider"></li>
	            <li><a class="dropdown-item" href="/cirurgia/lista">Cirurgias</a></li>
	          </ul>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="/paciente/lista">Pacientes</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="/prontuario/lista">Prontu�rios</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link inactive" aria-current="page" href="#">Sobre n�s</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="/usuario/lista">Usu�rios</a>
	        </li>
	    </c:if>    
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<c:if test="${empty usuario}">
		  <li class="nav-item">
		  	<a class="nav-link active" aria-current="page" href="/usuario"><i class="bi bi-person-fill"></i> Sign Up</a>
		  </li>
		  <li class="nav-item">
		  	<a class="nav-link active" aria-current="page" href="/login"><i class="bi bi-box-arrow-in-right"></i> Login</a>
		  </li>
		 </c:if>
		<c:if test="${not empty usuario}">
	      <li>
	      	<a class="nav-link active" aria-current="page" href="/logout"><i class="bi bi-door-closed"></i>Sair, ${usuario.nome}</a>
	      </li>
	    </c:if>
	  </ul>
    </div>
  </div>
</nav>