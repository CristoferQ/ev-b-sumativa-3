<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Evaluacion Sumativa 2 - Productos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="/categoria">Inicio</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
      	<li class="nav-item">
          <a class="nav-link" href="/categoria">Categorias</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/producto">Productos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="/categoria/busqueda">Busqueda por categoria</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/producto/busqueda">Busqueda de producto</a>
        </li>
      </ul>
      <form class="d-flex">
     <a class="btn btn-success" href="/carro" type="button">Ver Carrito</a>
      </form>
      <form class="d-flex"> 
     <a class="btn btn-danger mx-2" href="/desloguearse" type="button">Desloguearse</a>
      </form>
    </div>
  </div>
</nav>
<div class="d-flex justify-content-center">
	<div class="card col-md-6 mt-5 text-center">
  <div class="card-body">
    <h5 class="card-title">Busqueda de categoria</h5>
    <form action="/categoria/busqueda/buscar" method="POST">
	  <div class="mb-3">
	    <label for="nombre" class="form-label">Nombre de la categoria</label>
	    <input type="text" class="form-control" id="nombre" name="nombre">
	  </div>	  
	  <button type="submit" class="btn btn-primary">Buscar</button>
	</form>
  </div>
    <table class="table">
  <thead>
    <tr>
      <th scope="col">Id de la Categoria</th>
      <th scope="col">Nombre de la Categoria</th>
    </tr>
  </thead>
 <tbody>
		<c:forEach var="encontrado" items="${listaEncontrados}">		
			<tr>
			  <td><c:out value="${encontrado.id}"></c:out></td>
		      <td><c:out value="${encontrado.nombre}"></c:out></td>
		    </tr>
		</c:forEach>
  </tbody>
</table>
</div>

</div>

</body>
</html>