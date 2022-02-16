package ec.edu.ups.pweb.Business;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pweb.DAO.LoginDAO;
import ec.edu.ups.pweb.modelo.Cliente;
import ec.edu.ups.pweb.modelo.Veterinario;
/**
 * Esta clase va a llamar a los métodos realizados en el DAO mediante la instancia
 * @author campo
 *
 */
@Stateless
public class LoginON implements LoginONLocal {
	
	@Inject
	private LoginDAO DAO;

	public Cliente ObtenerLogin(String usuario, String contra) {

		return DAO.ObtenerLogin(usuario, contra);
	}

	public Veterinario ObtenerLoginVet(String usuario, String contra) {

		return DAO.ObtenerLoginVet(usuario, contra);
	}

}
