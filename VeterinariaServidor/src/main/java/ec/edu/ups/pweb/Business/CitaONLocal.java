package ec.edu.ups.pweb.Business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.pweb.modelo.Cita;
import ec.edu.ups.pweb.modelo.Cliente;
/**
 * Esta interfaz permitira consumir los métodos de manera local
 * @author campo
 *
 */
@Local
public interface CitaONLocal {
	public void insert(Cita cit);
	
	public void update(Cita cit);
	
	public List<Cita>getListCita();
	public void delete(int codigo);
	public Cita read(int codigo);
	public void guardarCita(Cita c) throws Exception;
	public Cita getCita( int codigo);
	//public List<Cita>getListadoCita(int codigo);
	
	public List<Cita>getCitalist(String cedula);
	public List<Cita> getListFiltroCita(String nombre);
	}

