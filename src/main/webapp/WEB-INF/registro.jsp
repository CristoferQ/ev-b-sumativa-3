<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Evaluacion Sumativa 2 - Registro</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">Inicio</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <form class="d-flex">
     <a class="btn btn-success" href="usuario/registro" type="button">Registrarse</a>
        
      </form>
  </div>
</nav>
<div class="d-flex justify-content-center">
	<div class="card col-md-6 mt-5 text-center">
  <div class="card-body">
    <h5 class="card-title">Registro de usuario</h5>
    <form action="/registrar" method="POST">
	  <div class="mb-3">
	    <label for="email" class="form-label">Email</label>
	    <input type="email" class="form-control" id="email" name="email">
	  </div>
	  <div class="mb-3">
	    <label for="password" class="form-label">Contraseña</label>
	    <input type="password" class="form-control" id="password" name="password">
	  </div>
	 	<div class="mb-3">
		  	<select class="form-select"" id="vip" name="vip">
			  <option value="0" selected>Usuario normal</option>
			  <option value="1">Usuario VIP</option>
			</select>
		</div>
	  <button type="submit" class="btn btn-primary">Registrarse</button>
	</form>
  </div>
</div>
</div>

</body>
</html>