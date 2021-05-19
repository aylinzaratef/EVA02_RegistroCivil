package cl.inacap.RegistroCivilModel.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import cl.inacap.RegistroCivilModel.dto.Solicitud;

/**
 * Session Bean implementation class SolicitudDAO
 */
@Stateless
@LocalBean
public class SolicitudDAO implements SolicitudDAOLocal {

    /**
     * Default constructor. 
     */
    public SolicitudDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void save(Solicitud solicitud) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Solicitud> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Solicitud solicitud) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Solicitud> filterByName(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
