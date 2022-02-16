package ec.edu.ups.pweb.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pweb.modelo.Veterinario;
/**
 * VeterinarioDAO va a representar una clase java que va alojar métodos 
 * para el funcionamiento. 
 * @author alexa
 *
 */
@Stateless
public class VeterinarioDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	
	/**
	 * Este método permite la inserción de los datos de Veterinario
	 * @param vet permitira insertar todos los datos obtenidos
	 */
	public void insert(Veterinario vet) {
		em.persist(vet);		
	}
	
	/**
	 * Este método permite eliminar un registro mediante la cédula obtenida.
	 * @param cedula va a recibir un valor numérico 
	 */
	public void delete(String cedula) {
		Veterinario vet = em.find(Veterinario.class, cedula);
		em.remove(vet);
	}
	
	/**
	 * Este método permite obtener una lista de todos los Veterinarios mediante una sentencia.
	 * @return nos delvolvera un listado de los Veterinarios registrados
	 */
	public List<Veterinario>getListVete(){
		List<Veterinario> listado=new ArrayList<Veterinario>();
	
		String jpql="SELECT vet FROM Veterinario vet"; 
		
		Query query =em.createQuery(jpql,Veterinario.class);
		listado=query.getResultList();
	return listado;
	}
}
