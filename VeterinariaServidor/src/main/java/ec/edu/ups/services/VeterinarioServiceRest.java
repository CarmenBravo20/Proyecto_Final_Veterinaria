package ec.edu.ups.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.pweb.Business.VeterinarioONLocal;
import ec.edu.ups.pweb.modelo.Veterinario;
/**
 * Esta Clase REST Permite tener los metodos creados previamente para compartirlos en angular
 * @author campo
 *
 */
@Path("vete")
public class VeterinarioServiceRest {

	
	@Inject
	private VeterinarioONLocal veteON;
	
	/**
	 * permite guardar los datos que se ingresan
	 * @param vet 
	 * @return
	 */
	@POST
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Veterinario  CrearVeterinario( Veterinario vet) {
		veteON.insert(vet);
		return vet;
	}
	
	/**
	 * elimina pormedio de la cedula 
	 * @param cedula valor que obtiene
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{cedula}")
	public void  EliminarVeterinario(@PathParam("cedula") String cedula) {
		veteON.delete(cedula);	
	}
	
	
	/**
	 * permite listar todos los registros 
	 * @return nos devuelve los datos obtenidos
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Veterinario> getListadoVeterinario(){
		return veteON.getListVete();
	}
}
