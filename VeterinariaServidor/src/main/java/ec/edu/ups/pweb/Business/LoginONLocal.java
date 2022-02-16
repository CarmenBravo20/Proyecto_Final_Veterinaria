package ec.edu.ups.pweb.Business;

import javax.ejb.Local;

import ec.edu.ups.pweb.modelo.Cliente;
import ec.edu.ups.pweb.modelo.Veterinario;
/**
 * Esta interfaz permitira consumir los métodos de manera local
 * @author campo
 *
 */
@Local
public interface LoginONLocal {

	public Cliente ObtenerLogin(String usuario, String contra);

	public Veterinario ObtenerLoginVet(String usuario, String contra);
}
