package ec.edu.ups.pweb.Business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

import ec.edu.ups.pweb.DAO.CitasDAO;
import ec.edu.ups.pweb.modelo.Cita;
import ec.edu.ups.pweb.modelo.Cliente;
import ec.edu.ups.pweb.modelo.Mascota;
/**
 * Esta clase va a llamar a los métodos realizados en el DAO mediante la instancia
 * @author campo
 *
 */
@Stateless
public class CitaON implements CitaONLocal{
	
	@Inject
	private CitasDAO DAO;
	
	public void insert(Cita cit) {
		DAO.insert(cit);		
	}
	
	public void update(Cita cit) {
		DAO.update(cit);
	}
	public List<Cita>getListCita(){
		return DAO.getListCita();
	}
	
	public void delete(int codigo) {
		System.out.println("llogo eliminar "+ codigo);
		DAO.delete(codigo);
	}
	
	/**
	 * nos va a permitir validar si los datos estan registrados o no,
	 * si el valor esta registrado se actualizara
	 */
	public void guardarCita(Cita c) throws Exception {
		if(DAO.read(c.getCodigo())==null) {
			DAO.insert(c);
	}else {
			DAO.update(c);
	}
	}
	public Cita read(int codigo) {
			return DAO.read(codigo);
		}
	
	public Cita getCita( int codigo) {
		 return DAO.read(codigo);
	 }
	/*public List<Cita>getListadoCita(int codigo){
		return DAO.getListadoCita(codigo);
	}*/
//----------------------------------------------------
	public List<Cita>getCitalist(String cedula){
		return DAO.getCita(cedula);
	}
	
	
	public List<Cita> getListFiltroCita(String nombre) {
			
		return DAO.getListFiltroCita(nombre);
	}	
}
