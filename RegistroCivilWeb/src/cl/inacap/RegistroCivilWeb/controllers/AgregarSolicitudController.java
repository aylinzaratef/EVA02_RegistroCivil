package cl.inacap.RegistroCivilWeb.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.RegistroCivilModel.dao.SolicitudDAOLocal;
import cl.inacap.RegistroCivilModel.dto.Solicitud;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/AgregarSolicitudController.do")
public class AgregarSolicitudController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private SolicitudDAOLocal solicitudDAO;

	AtomicInteger atomicInteger = new AtomicInteger();

	public AgregarSolicitudController() {
		super();

	}

	protected boolean validarRut(String rut) {
		boolean validacion = false;
		try {
			rut = rut.toUpperCase();
			rut = rut.replace(".", "");
			rut = rut.replace("-", "");
			int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

			char dv = rut.charAt(rut.length() - 1);

			int m = 0, s = 1;
			for (; rutAux != 0; rutAux /= 10) {
				s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
			}
			if (dv == (char) (s != 0 ? s + 47 : 75)) {
				validacion = true;
			}

			} catch (Exception e) {
		}
		return validacion;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/vistas/agregarSolicitud.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<String> errores = new ArrayList<>();

		String nombre = request.getParameter("nombre-txt").trim();
		if (nombre.isEmpty()) {
			errores.add("Debe ingresar un nombre.");
		}
		String rut = request.getParameter("rut-txt").trim();
		if (validarRut(rut) == false) {
			errores.add("Debe ingresar un rut válido.");
		}

		String solicitudSelect = request.getParameter("solicitud-select").trim();
		if (solicitudSelect.isEmpty()) {
			errores.add("Debe Seleccionar un tipo de solicitud.");
		}
		if (errores.isEmpty()) {

			Solicitud solicitud = new Solicitud();
			solicitud.setRut(0);
			solicitud.setNombre(nombre);
			solicitud.setTipoSolicitud(solicitudSelect);
			solicitud.setNumeroSolicitud(atomicInteger.incrementAndGet());
			solicitudDAO.save(solicitud);

			request.setAttribute("mensaje", "Solicitud enviada exitosamente.");
		} else {
			request.setAttribute("errores", errores);
		}

		doGet(request, response);
	}

}
