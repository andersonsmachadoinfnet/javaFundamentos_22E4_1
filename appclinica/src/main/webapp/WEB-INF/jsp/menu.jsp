<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

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
          <a class="nav-link active" aria-current="page" href="/home">Início</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Procedimentos
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#">Exames</a></li>
            <li><a class="dropdown-item" href="#">Medicamentos</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Cirurgias</a></li>
          </ul>
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
      <ul class="nav navbar-nav navbar-right">
  <li class="nav-item">
  	<a class="nav-link active" aria-current="page" href="/usuario"><i class="bi bi-person-fill"></i> Sign Up</a>
  </li>
  <li class="nav-item">
  	<a class="nav-link active" aria-current="page" href="/login"><i class="bi bi-box-arrow-in-right"></i> Login</a>
  </li>
</ul>
    </div>
  </div>
</nav>