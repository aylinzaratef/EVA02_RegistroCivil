<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../templates/header.jsp"></jsp:include>

<main class="container mt-6">
	<div class="columns">
		<div class="column">
			<table
				class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
				<thead class="has-background-primary">
					<tr>
						<th>Nro de Atención</th>
						<th>Nombre del Cliente</th>
						<th>Tipo de Solicitud </th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="consola" items="${consolas}">
						<tr>
						<td>${solicitud.numeroAtencion} </td>
						<td>${solicitud.nombre}</td>
						<td>${solicitud.tipoSolicitud}</td>
						<td>
							<a href="AtenderSolicitudController.do?nombreEliminar=${solicitud.numeroAtencion}" class="has-text-danger">Atender</a>
						</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>

</main>

<html>
</html>
