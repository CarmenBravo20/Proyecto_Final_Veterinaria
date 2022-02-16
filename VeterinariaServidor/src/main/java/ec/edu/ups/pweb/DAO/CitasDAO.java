package ec.edu.ups.pweb.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pweb.modelo.Cita;
/**
 * CitasDAO va a representar una clase java que va alojar métodos 
 * para el funcionamiento.
 * @author campo
 *
 */

@Stateless
public class CitasDAO {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Este método permite la inserción de los datos de cita 
	 * @param cit permitira insertar todos los datos obtenidos
	 */
	public void insert(Cita cit) {
		em.persist(cit);		
	}
	
	/**
	 * Este método permite la actualizar de los datos de cita 
	 * @param cit permitira actualizar los datos cambiados
	 */
	public void update(Cita cit) {
		em.merge(cit);
	}
	
	/**
	 * Este método permite obtener una lista de todas la citas mediante una sentencia.
	 * @return nos delvolvera un listado de las citas registradas
	 */
	public List<Cita>getListCita(){
		List<Cita> listado=new ArrayList<Cita>();
	
		String jpql="SELECT cit FROM Cita cit"; 
		
		Query query =em.createQuery(jpql,Cita.class);
		listado=query.getResultList();
	return listado;
	}
	
	/**
	 * Este método permite eliminar un registro mediante un valor numérico obtenido.
	 * @param codigo va a recibir un valor numérico 
	 */
	public void delete(int codigo) {
		Cita cit = em.find(Cita.class, codigo);
		em.remove(cit);
	}
	
	/**
	 * Este método nos permite buscar la cita por código
	 * @param codigo es el parametro que va a recibir el método
	 * @return va a devolver el valor obtenido
	 */
	public Cita read(int codigo) {
		Cita cit = em.find(Cita.class, codigo);
		return cit;
	}
	
	
	/**
	 * 
	 * @param codigo
	 * @return
	 */
	/*public List<Cita> getListadoCita(int codigo){
		List<Cita> listado = new ArrayList<Cita>();
		String jpql = "SELECT ci FROM Cita ci";
		Query query =em.createQuery(jpql,Cita.class);
		listado=query.getResultList();
	return listado;	
	}*/
//---------------------------------------------------------------------------------	
	
	/**
	 * Este método permite obtener los datos por cédula para editarlos 
	 * @param cedula parámetro que recibe el método.
	 * @return devolvera los datos obtenidos por cédula 
	 */
	public List<Cita> getCita(String cedula) {

		List<Cita> listado = new ArrayList<Cita>();

		String jpql = "SELECT ci FROM Cita ci WHERE cedula = ?1";

		Query query = em.createQuery(jpql, Cita.class);
		query.setParameter(1, cedula);

		listado = query.getResultList();
		System.out.println("llego jpql cita");
		return listado;
	}
//--------------------------------------------------------------------
	
	/**
	 * Este método va a permitir filtrar datos mediante el nombre
	 * @param nombre es el parámetro que recibe
	 * @return va a devolver un listado de datos
	 */
		public List<Cita> getListFiltroCita(String nombre) {
			
			String jpql="SELECT ci FROM Cita ci WHERE nombre like ?1 "; 
				nombre="%"+nombre+"%";
				Query query=em.createQuery(jpql,Cita.class);
				query.setParameter(1, nombre);
				List<Cita> listado =query.getResultList();
				
			return listado;
		}	
}
