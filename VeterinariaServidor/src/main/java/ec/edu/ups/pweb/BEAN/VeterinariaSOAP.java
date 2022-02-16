package ec.edu.ups.pweb.Bean;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;


import ec.edu.ups.pweb.Business.VeterinarioONLocal;
import ec.edu.ups.pweb.modelo.Veterinario;
/**
 * 
 * @author alexa
 *
 */
@WebService
public class VeterinariaSOAP {

	@Inject
	private VeterinarioONLocal veteON;
	
	
	@WebMethod
	public String  CrearVeterinario(Veterinario vet) {
		veteON.insert(vet);
		return"Veterinario Guardado";
	}
	@WebMethod
	public String  EliminarVeterinario(String cedula) {
		veteON.delete(cedula);
		return"Veterinario Eliminado";
	}
	@WebMethod
	public List<Veterinario> getListadoVeterinario(){
		return veteON.getListVete();
	}
	
}
