package ec.edu.ups.services;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ec.edu.ups.pweb.Business.CitaONLocal;
import ec.edu.ups.pweb.modelo.Cita;
/**
 * Esta Clase REST Permite tener los metodos creados previamente para compartirlos en angular
 * @author campo
 *
 */

@Path("citas")
public class CitaServiceRest {
	@Inject
	private CitaONLocal citaON;
	
	/**
	 * Permite obtener los datos del formulario
	 * @param cita permite obtener los datos del formulario
	 * @return retorno un mensaje 
	 */
	@PUT
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String Editar(Cita cita) {
		try {
			citaON.guardarCita(cita);
			return "Cita Guardada";
		}catch (Exception e) {
			return "ERROR Cita";
		}	
	}
	
	/**
	 * Permite listar todos los registros
	 * @return devuelve los registros
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cita> getCitas(){
		return citaON.getListCita();
	}
	
	/**
	 * Este metodo permite listar las citas mediante cojiendo el codigo
	 * @param codigo es el parametro que obtendra 
	 * @return y va a listar los datos con el codigo
	 */
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{codigo}")
	public Cita getListadoCitas(@PathParam("codigo") int codigo){
		System.out.println("asdasdasd"+codigo);
		Cita cit= citaON.read(codigo);
		System.out.println("Hola " + cit.getNombre());
		return cit;
	}
	
	
}
