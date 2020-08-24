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
<div class="jumbotron jumbotron-fluid">
    <div class="container">
      <h1 class="display-4">${title}</h1>
      <div>
        <p class="lead">
          <a class="btn btn-primary btn-lg" href="presentarCliente" role="button">Cancelar</a>
        </p>
      </div>
    </div>
</div>
    <div class="container">
        <form:form id="clienteForm" action="/salvarCliente" method="post" modelAttribute="cliente" class="was-validated">
            <form:label path="CLnumero" pathfor="nombre">Registro #</form:label>
            <form:input class="form-control" readonly="true" path="CLnumero" id="CLnumero" name="CLnumero"/>

            <form:label path="CLnombre" pathfor="nombre">Nombre</form:label>
            <form:input class="form-control" path="CLnombre" id="nombre" name="nombre" placeholder="Nombre" required="required"/>
            <div class="invalid-feedback">
                Nombre no puede ir vacio
            </div>

            <form:label path="CLapellido" pathfor="apellido">Apellido</form:label>
            <form:input class="form-control" path="CLapellido" id="apellido" name="apellido" placeholder="Apellido" required="required"/>
            <div class="invalid-feedback">
                Apellido no puede ir vacio
            </div>

            <form:label path="CLid" pathfor="id">Identificación</form:label>
            <form:input class="form-control" path="CLid" id="id" name="id" placeholder="Identificación" required="required"/>
            <div class="invalid-feedback">
               Identifiación no puede ir vacio
            </div>

            <form:label path="CLtelefono" pathfor="telefono">Teléfono</form:label>
            <form:input class="form-control" path="CLtelefono" id="telefono" name="telefono" placeholder="Teléfono" required="required"/>
            <div class="invalid-feedback">
                Teléfono no puede ir vacio
             </div>
 

            <form:label path="CLdireccion" pathfor="direccion">Dirección</form:label>
            <form:input class="form-control" path="CLdireccion" id="direccion" name="direccion" placeholder="Dirección" required="required"/>
            <div class="invalid-feedback">
                Dirección no puede ir vacio
             </div>

            <form:label path="CLactividad" pathfor="actividad">Actividad</form:label>
            <form:input class="form-control" path="CLactividad" id="actividad" name="actividad" placeholder="Actividad" required="required"/>
            <div class="invalid-feedback">
               Actividad no puede ir vacio
             </div>

             <br/>
            <div class="form-group">
                <button class="btn btn-primary " name="submit" type="submit">Salvar</button>
            </div>
        </form:form>
	</div>
<body>
</body>
</html>