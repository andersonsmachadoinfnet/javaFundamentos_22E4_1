<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cl�nica ++</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
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
                <a class="nav-link inactive" aria-current="page" href="#">In�cio</a>
              </li>
              <li class="nav-item">
                <a class="nav-link inactive" aria-current="page" href="#">Exames</a>
              </li>
              <li class="nav-item">
                <a class="nav-link inactive" aria-current="page" href="#">M�dicos</a>
              </li>
              <li class="nav-item">
                <a class="nav-link inactive" aria-current="page" href="#">Sobre n�s</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/usuario/lista">Usu�rios</a>
              </li> 
            </ul>
          </div>
        </div>
      </nav>
      
    

	<div class="container-fluid bg-white">
	
        <div class="container">
        
        <div class="alert alert-warning alert-dismissible fade show" role="alert">
		  <strong>Fase: </strong>Site em constru��o, feature 2 do Projeto de bloco: Desenvolvimento Java.</br>
		  Clique em Cadastrar Usu�rios.
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
        
        <div class="row d-flex align-items-center">
            <div class="col-md-6">
                <h2>Exames</h2>
                <p>Os exames mais confi�veis do mercado!</br>
                  Mussum Ipsum, cacilds vidis litro abertis. Casamentiss faiz malandris se pirulit�.Nullam volutpat risus nec leo commodo, ut interdum diam laoreet. Sed non consequat odio.Nec orci ornare consequat. Praesent lacinia ultrices consectetur. Sed non ipsum felis.Copo furadis � disculpa de bebadis, arcu quam euismod magna.
                </p>
            </div>
            <div class="col-md-6">
                <img src="./banner.jpg" alt="" srcset="" class="w-auto" height="320px" width="auto">
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