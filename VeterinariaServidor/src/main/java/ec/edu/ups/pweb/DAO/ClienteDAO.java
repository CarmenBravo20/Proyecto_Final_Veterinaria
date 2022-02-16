package ec.edu.ups.pweb.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.ups.pweb.modelo.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 * ClienteDAO va a representar una clase java que va alojar métodos 
 * para el funcionamiento. 
 * @author campo
 *
 */

@Stateless
public class ClienteDAO {

	@PersistenceContext
	private EntityManager em;
	
	 /**
	 * Este método permite la inserción de los datos de cliente
	 * @param cli permitira insertar todos los datos obtenidos
	 */
	public void insert(Cliente cli) {
		em.persist(cli);		
	}
	
	 /**
	 * Este método permite la actualizar de los datos de cliente
	 * @param cli permitira actualizar los datos cambiados
	 */
	public void update(Cliente cli) {
		em.merge(cli);
	}
	
	
	/**
	 * Este método nos permite buscar el cliente por cédula
	 * @param cedula es el parametro que va a recibir 
	 * @return va a devolver lo obtenido
	 */
	public Cliente read(String cedula) {
		Cliente cli = em.find(Cliente.class, cedula);
		return cli;
	}
	
	/**
	 * Este método permite eliminar un registro mediante la cédula obtenido.
	 * @param cedula es el parámetro que recibirá
	 */
	public void delete(String cedula) {
		Cliente cli = em.find(Cliente.class, cedula);
		em.remove(cli);
	}
	
	/**
	 * Este método permite obtener una lista de todos los clientes mediante una sentencia.
	 * @return nos delvolvera un listado de los clientes registrados
	 */
	public List<Cliente>getList(){
		List<Cliente> listado=new ArrayList<Cliente>();
	
		String jpql="SELECT cli FROM Cliente cli"; 
		
		Query query =em.createQuery(jpql,Cliente.class);
		listado=query.getResultList();
	return listado;
	}

}
