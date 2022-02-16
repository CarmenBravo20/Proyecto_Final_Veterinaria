package ec.edu.ups.pweb.Business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.pweb.modelo.Veterinario;
/**
 * Esta interfaz permitira consumir los métodos de manera local
 * @author alexa
 *
 */
@Local
public interface VeterinarioONLocal {
	
	public void insert(Veterinario vet);
	public List<Veterinario>getListVete();
	public void delete(String cedula);

}
