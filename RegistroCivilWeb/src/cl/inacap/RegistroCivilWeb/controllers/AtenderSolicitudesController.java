package cl.inacap.RegistroCivilWeb.controllers;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.RegistroCivilModel.dao.SolicitudDAOLocal;
import cl.inacap.RegistroCivilModel.dto.Solicitud;


/**
 * Servlet implementation class AtenderSolicitudesController
 */
@WebServlet("/AtenderSolicitudesController.do")
public class AtenderSolicitudesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	SolicitudDAOLocal solicitudDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("numeroEliminar") !=null) {
			String numero = request.getParameter("numeroEliminar");
			int numeroSolicitud = Integer.parseInt(numero);
			List<Solicitud> busqueda = solicitudDAO.filterByNumber(numeroSolicitud);
			
			Solicitud solicitudAtender = busqueda.isEmpty()? null:busqueda.get(0);
			if(solicitudAtender != null) {
				solicitudDAO.delete(solicitudAtender);
			}
		}
		
		if(request.getAttribute("solicitudes") ==null) {
			List<Solicitud> solicitudes = solicitudDAO.getAll();
			request.setAttribute("solicitudes", solicitudes);
			request.setAttribute("filtro", 0);
		}
		
		
	
		request.getRequestDispatcher("WEB-INF/vistas/atenderSolicitud.jsp").forward(request, response);
		
	}	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("solicitud-select") !=null) {
			
			String solicitudSelect = request.getParameter("solicitud-select").trim();
			
		if(solicitudSelect.contains("Todas las solicitudes") ) {
			request.setAttribute("solicitudes",solicitudDAO.getAll());
			}else {
				List<Solicitud> solicitudesFiltradas = solicitudDAO.filterByType(solicitudSelect);
				request.setAttribute("solicitudes", solicitudesFiltradas);
				
			}
			request.setAttribute("filtro", 1);
		}
		
		doGet(request,response);
			
	}

}
