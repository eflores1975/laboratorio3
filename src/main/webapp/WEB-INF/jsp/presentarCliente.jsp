<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="es">

<head>
	<meta charset="UTF-8">
	<title>Mantenimiento de Cliente Factura</title>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">Información clientes y total de facturas</h1>
			<div>
				<p class="lead">
				  <a class="btn btn-primary btn-lg" href="actualizarCliente" role="button">Agregar nuevo cliente</a>
				</p>
			  </div>
		</div>
	</div>
	<div class="container">
		<form id="actualizarCliente" action="actualizarCliente" method="POST">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Nombre</th>
					<th scope="col">Apellido</th>
					<th scope="col">ID</th>
					<th scope="col">Teléfono</th>
					<th scope="col">Dirección</th>
					<th scope="col">Actividad</th>
					<th scope="col">Total facturas</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cliente" items="${clientes}">
					<tr>
						<td>${cliente.CLnumero}</td>
						<td>${cliente.CLnombre}</td>
						<td>${cliente.CLapellido}</td>
						<td>${cliente.CLid}</td>
						<td>${cliente.CLtelefono}</td>
						<td>${cliente.CLdireccion}</td>
						<td>${cliente.CLactividad}</td>
						<td align="center">${cliente.CLtotalFacturas}</td>
						<td width="16%">
							<button type="submit" name="updateCLnumero" value="${cliente.CLnumero}" class="btn btn-primary"><i class="fa fa-edit"></i></button>
							<button type="submit" name="deleteCLnumero" value="${cliente.CLnumero}" class="btn btn-danger"><i href=""class="fa fa-trash"></i></button>
							<a class="btn btn-primary" href="presentarFacturas/${cliente.CLnumero}" role="button"><i href=""class="fa fa-eye"></i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
	</div>
</body>
</html>