<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
<main class="container mt-6">

	<c:if test="${errores != null }" >
		<div class="columns is-centered mb-6">
			<div class="column is-6">
				<div class="notification is-danger">
					<h6>Existen Errores en el formulario</h6>
					<div class="content">
						<ul>
							<c:forEach var="error" items="${errores}">
								<li>${error}</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	
	</c:if>
	<div class="columns is-centered">
		<div class="column is-6">
			<form method="POST" action="AgregarSolicitudController.do">
				<div class="card">
					<div class="card-header has-background-primary">
						<span class="card-header-title is-centered">Ingreso Solicitud</span>
					</div>
					<div class="card-content">
						<div class="field">
							<label class="label" for="nombre-txt">Rut</label>
							<div class="control">
								<input type="text" class="input" autocomplete="off" id="rut-txt"
									name="rut-txt" />
							</div>
						</div>
						<div class="field">
							<label class="label" for="nombre-txt">Nombre y Apellido</label>
							<div class="control">
								<input type="text" class="input" autocomplete="off" id="nombre-txt"
									name="nombre-txt" />
							</div>
						</div>
						<div class="field">
							<label class="label" for="solicitud-select">Tipo Solicitud</label>
							<div class="control">
								<div class="select">
									<select name="solicitud-select" id="solicitud-select">
										<option>Solicitud C�dula de Identidad</option>
										<option>Retiro de C�dula de Identidad</option>
										<option>Solicitud de Certificado de Nacimiento</option>
										<option>Solicitud de Certificado de Defunci�n</option>
									</select>
								</div>
							</div>
						</div>
						<div class="field">
							<label class="label" for="numeroSolicitudOriginal-txt">N�mero de Solicitud Original para retiro de C�dula de Identidad</label>
							<div class="control">
								<input type="number" name="numeroSolicitudOriginal-txt" id="numeroSolicitudOriginal-txt"
									class="input" />
							</div>
						</div>
					</div>
					<div class="card-footer has-text-centered">
						<div class="card-footer-item">
							<button type="submit" class="button is-primary" >Ingresar Solicitud</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

</main>

<html>
</html>
