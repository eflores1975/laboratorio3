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
	<title>Mantenimiento de factura Factura</title>
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
			<h1 class="display-4">Facturas del cliente ${cliente.CLnombre} ${cliente.CLapellido}</h1>
			<div>
				<p class="lead">
                  <a class="btn btn-primary btn-lg" href="../presentarCliente" role="button">Regresar</a>
                  <a class="btn btn-primary btn-lg" href="/actualizarCrearFactura/0" role="button">Agregar factura</a>
				</p>
			  </div>
		</div>
    </div>
    <div class="container">
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Proveedor</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Artículo</th>
                    <th scope="col">Cantidad</th>
                    <th scope="col">Unidad</th>
                    <th scope="col">Itbm</th>
                    <th scope="col">Total</th>
                    <th scope="col">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="factura" items="${facturas}">
                    <tr>
                        <td>${factura.FAnumero}</td>
                        <td>${factura.FAproveedor}</td>
                        <td><fmt:formatDate pattern = "dd-MMM-yyyy" value = "${factura.FAfecha}"/></td>
                        <td>${factura.FAarticulo}</td>
                        <td>${factura.FAcantidad}</td>
                        <td>${factura.FAunidad}</td>
                        <td>${factura.FAitbm}</td>
                        <td>${factura.FAtotal}</td>
                        <td width="16%">
                            <a class="btn btn-primary" href="/actualizarCrearFactura/${factura.FAnumero}" role="button"><i href=""class="fa fa-edit"></i></a>
                            <a class="btn btn-danger" href="/eliminarFactura/${factura.FAnumero}" role="button"><i href=""class="fa fa-trash"></i></a>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>	
</body>
</html>