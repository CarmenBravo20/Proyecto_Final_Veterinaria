package ec.edu.ups.pweb.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pweb.modelo.Cliente;
import ec.edu.ups.pweb.modelo.Mascota;
/**
 * MascotaDAO va a representar una clase java que va alojar métodos 
 * para el funcionamiento. 
 * @author alexa
 *
 */

@Stateless
public class MascotaDAO {
	
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Este método permite la inserción de los datos de Mascota
	 * @param ma permitira insertar todos los datos obtenidos
	 */
	public void insert(Mascota ma) {
		em.persist(ma);		
	}
	
	/**
	 * Este método permite la actualizar de los datos de Mascota 
	 * @param ma permitira actualizar los datos cambiados
	 */
	public void update(Mascota ma) {
		em.merge(ma);
	}
	
	/**
	 * Este método nos permite buscar la Mascota por id
	 * @param id es el paramentro que va a resivir el metodo
	 * @return ma a devolver el valor optenido
	 */
	public Mascota read(int id) {
		Mascota ma = em.find(Mascota.class, id);
		return ma;
	}
	
	/**
	 * Este método permite eliminar un registro mediante un valor numérico obtenido.
	 * @param codigo va a recibir un valor numérico 
	 */
	public void delete(int codigo) {
		Mascota ma = em.find(Mascota.class, codigo);
		em.remove(ma);
	}
	
	/**
	 * Este método permite optener una lista de todas las Mascotas mediante una sentencia.
	 * @return nos delvolvera un listado de las Mascotas registradas
	 */
	public List<Mascota>getList(){
		List<Mascota> listado=new ArrayList<Mascota>();
	
		String jpql="SELECT ma FROM Mascota ma"; 
		
		Query query =em.createQuery(jpql,Mascota.class);
		listado=query.getResultList();
	return listado;
	}
//--------------------------------------------------------------------
	
	/**
	 * Este método va a permitir filtrar datos mediante la cédula
	 * @param cedula es el parámetro que recibe
	 * @return va a devolver un listado de datos
	 */
	public List<Mascota> getListFiltroMascota(String cedula) {
		
		String jpql="SELECT m FROM Mascota m WHERE cedula like ?1 "; 
			cedula="%"+cedula+"%";
			Query query=em.createQuery(jpql,Mascota.class);
			query.setParameter(1, cedula);
			List<Mascota> listado =query.getResultList();
			
		return listado;
	}

}
