<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../templates/header.jsp"></jsp:include>

<main class="container mt-6">
	<c:if test="${mensaje !=null}">
		<div class="columns is-centered">
			<div class="column is-8">
				<div class="notification is-primary">
					<p>${mensaje}</p>
				</div>
			</div>
		</div>

	</c:if>
	<div class="columns is-centered">
		<div class="column is-8">
			<c:if test="${solicitudes.size() > 0 || filtro == 1}">
			<form method="POST" action="AtenderSolicitudesController.do">
			<div class="columns">
					<div class="column is-12">
						<div class="field">
							<label class="label" for="solicitud-select">Filtrar tipo
								solicitud</label>
							<div class="control">
								<div class="select">
									<select name="solicitud-select" id="solicitud-select">
										<option>Todas las solicitudes</option>
										<option>Solicitud Cédula de Identidad</option>
										<option>Retiro de Cédula de Identidad</option>
										<option>Solicitud de Certificado de Nacimiento</option>
										<option>Solicitud de Certificado de Defunción</option>
									</select>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="columns">
					<div class="column is-12">
						<div>
							<button type="submit" class="button is-primary">Filtrar</button>
						</div>
					</div>
				</div>
			</form >
				<div class="columns">
					<div class="column">
					<c:if test="${solicitudes.size() > 0}">
						<table
							class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
							<thead class="has-background-primary">
								<tr>
									<th>Número de atención</th>
									<th>Nombre del cliente</th>
									<th>Tipo de solicitud</th>
									<th>Acciones</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="solicitud" items="${solicitudes}">
									<tr>
										<td>${solicitud.numeroSolicitud}</td>
										<td>${solicitud.nombre }</td>
										<td>${solicitud.tipoSolicitud}</td>
										<td><a
											href="AtenderSolicitudesController.do?numeroEliminar=${solicitud.numeroSolicitud}"
											class="has-text-danger">Atender</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:if>
					</div>

				</div>
			</c:if>
			<c:if test="${solicitudes.size() == 0 && filtro == 0}">

				<div class="notification has-background-danger-dark">
					<p class="has-text-link-light">No se han encontrado
						solicitudes.</p>
					<p class="has-text-link-light">
						Puede ingresar una solicitud <a
							href="AgregarSolicitudController.do">Aquí.</a>
					</p>
				</div>

			</c:if>
			<c:if test="${solicitudes.size() == 0 && filtro == 1}">

				<div class="notification has-background-danger-dark">
					<p class="has-text-link-light">No se han encontrado
						solicitudes.</p>
				</div>

			</c:if>
		</div>
	</div>
</main>
</body>
</html>