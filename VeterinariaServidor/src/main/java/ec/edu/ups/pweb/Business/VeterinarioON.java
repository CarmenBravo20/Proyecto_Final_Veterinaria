package ec.edu.ups.pweb.Business;


import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import ec.edu.ups.pweb.DAO.VeterinarioDAO;
import ec.edu.ups.pweb.modelo.Veterinario;
/**
 * Esta clase va a llamar a los métodos realizados en el DAO mediante la instancia
 * @author alexa
 *
 */
@Stateless
public class VeterinarioON implements VeterinarioONLocal{
	
	@Inject
	private VeterinarioDAO DAO;
	
	public void insert(Veterinario vet) {
		DAO.insert(vet);		
	}
	
	public void delete(String cedula) {
		DAO.delete(cedula);
	}
	public List<Veterinario>getListVete(){
		
	return DAO.getListVete();
	}
}
