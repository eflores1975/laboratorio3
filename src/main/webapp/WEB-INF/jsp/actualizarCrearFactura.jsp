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
    <script type="text/javascript">
        $(document).ready(function() {
            $("#facturaForm").validate({
                rules: {
                    dateMeasured: {
                        required: true,
                        date: true
                    }
                }
            })
        });
    </script>

</head>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
      <h1 class="display-4">Actualizar Factura</h1>
      <div>
        <p class="lead">
          <a class="btn btn-primary btn-lg" href="../presentarFacturas/${cliente.CLnumero}" role="button">Cancelar</a>
        </p>
      </div>
    </div>
</div>
    <div class="container">
        <form:form id="facturaForm" action="/salvarFactura" method="post" modelAttribute="factura" class="was-validated">
            <form:label path="FAnumero" pathfor="nombre">Registro #</form:label>
            <form:input class="form-control" readonly="true" path="FAnumero" id="FAnumero" name="FAnumero"/>

            <form:label path="FAproveedor" pathfor="proveedor">Proveedor</form:label>
            <form:input class="form-control" path="FAproveedor" id="proveedor" name="proveedor" placeholder="Proveedor" required="required"/>
            <div class="invalid-feedback">
                Proveedor no puede ir vacio
            </div>

            <form:label path="FAfecha" pathfor="inputDate">Fecha</form:label>
                <form:input class="form-control" path="FAfecha" id="FAfecha" name="FAfecha" placeholder="MM/dd/AAAA" type="text" required="required"/>
                    
            <div class="invalid-feedback">
                Por favor brinde una fecha valida en formato MM/DD/AAAA
            </div>

            <form:label path="FAarticulo" pathfor="articulo">Articulo</form:label>
            <form:input class="form-control" path="FAarticulo" id="articulo" name="articulo" placeholder="articulo" required="required"/>
            <div class="invalid-feedback">
                articulo no puede ir vacio
            </div>

            <form:label path="FAcantidad" pathfor="id">Cantidad</form:label>
            <form:input class="form-control" path="FAcantidad" id="id" name="id" placeholder="Cantidad"  type="number" required="required"/>
            <div class="invalid-feedback">
               Cantidad no puede ir vacio
            </div>

            <form:label path="FAunidad" pathfor="unidad">Unidad</form:label>
            <form:input class="form-control" path="FAunidad" id="unidad" name="unidad" placeholder="0" required="required"/>
            <div class="invalid-feedback">
                Unidad no puede ir vacio
             </div>

            <form:label path="FAitbm" pathfor="unidad">Itbm</form:label>
            <form:input class="form-control" path="FAitbm" id="itbm" name="itbm" placeholder="0" type="number" step="0.01" required="required"/>
            <div class="invalid-feedback">
                Itbm no puede ir vacio
            </div>

            <form:label path="FAtotal" pathfor="total">Total</form:label>
            <form:input class="form-control" path="FAtotal" id="total" name="total" placeholder="0" type="number" step="0.01" required="required"/>
            <div class="invalid-feedback">
                Total no puede ir vacio
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