package cl.inacap.RegistroCivilModel.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import cl.inacap.RegistroCivilModel.dto.Solicitud;

/**
 * Session Bean implementation class SolicitudDAO
 */
@Stateless
@LocalBean
public class SolicitudDAO implements SolicitudDAOLocal {
	private static List<Solicitud> solicitudes = new ArrayList<>();

	@Override
	public void save(Solicitud solicitud) {
		solicitudes.add(solicitud);
		
	}

	@Override
	public List<Solicitud> getAll() {
		return solicitudes;
	}

	@Override
	public void delete(Solicitud solicitud) {
		solicitudes.remove(solicitud);
		
	}

	@Override
	public List<Solicitud> filterByNumber(int numeroSolicitud) {
		// TODO Auto-generated method stub
	 return solicitudes.stream().filter(s->s.getNumeroSolicitud()==(numeroSolicitud)).collect(Collectors.toList());
	}

	@Override
	public List<Solicitud> filterByType(String tipoSolicitud) {
		// TODO Auto-generated method stub
		 return solicitudes.stream().filter(s->s.getTipoSolicitud().contains(tipoSolicitud)).collect(Collectors.toList());	}

}
