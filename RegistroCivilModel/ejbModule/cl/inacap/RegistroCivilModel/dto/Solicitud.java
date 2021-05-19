package cl.inacap.RegistroCivilModel.dto;

public class Solicitud {
	
	private String nombre;
	private int rut;
	private String tipoSolicitud;
	private int numeroSolicitud;
	private int numeroSolicitudOriginal;
	
	
	public int getNumeroSolicitudOriginal() {
		return numeroSolicitudOriginal;
	}
	public void setNumeroSolicitudOriginal(int numeroSolicitudOriginal) {
		this.numeroSolicitudOriginal = numeroSolicitudOriginal;
	}
	public int getNumeroSolicitud() {
		return numeroSolicitud;
	}
	public void setNumeroSolicitud(int numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getRut() {
		return rut;
	}
	public void setRut(int rut) {
		this.rut = rut;
	}
	public String getTipoSolicitud() {
		return tipoSolicitud;
	}
	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}
	
	
}
