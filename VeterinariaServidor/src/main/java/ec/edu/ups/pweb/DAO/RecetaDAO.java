package ec.edu.ups.pweb.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pweb.modelo.Mascota;
import ec.edu.ups.pweb.modelo.Receta;
/**
 * RecetaDAO va a representar una clase java que va alojar metodos 
 * para el funcionamiento. 
 * @author campo
 *
 */
@Stateless
public class RecetaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Este metodo permite la insercion de los datos de Receta 
	 * @param rec permitira insertar todos los datos obtenidos
	 */
	public void insert(Receta rec) {
		em.persist(rec);		
	}
	
	/**
	 * Este metodo permite la actualizar de los datos de receta 
	 * @param rec permitira actualizar los datos cambiados
	 */
	public void update(Receta rec) {
		em.merge(rec);
	}
	
	/**
	 * Este metodo nos permite buscar la receta por id
	 * @param id es el paramentro que va a resivir el metodo
	 * @return va a devolver el valor optenido
	 */
	public Receta read(int id) {
		Receta rec = em.find(Receta.class, id);
		return rec;
	}
	
	

	/**
	 * Este metodo permite optener una lista de todas la recetas mediante una sentencia.
	 * @return nos delvolvera un listado de las recetas registradas
	 */
	public List<Receta>getList(){
		List<Receta> listado=new ArrayList<Receta>();
	
		String jpql="SELECT rec FROM Receta rec"; 
		
		Query query =em.createQuery(jpql,Receta.class);
		listado=query.getResultList();
	return listado;
	}

	
	/**
	 * Este metodo permite obtener los datos por cedular para editarlos 
	 * @param cedula parametro que recive el metodo.
	 * @return devolvera los datos obtenidos por cedula 
	 */
	public List<Receta> getListRecetaCli(String cedula) {

		List<Receta> listado = new ArrayList<Receta>();

		String jpql = "SELECT rec FROM Receta rec WHERE cedula = ?1";

		Query query = em.createQuery(jpql, Receta.class);
		query.setParameter(1, cedula);

		listado = query.getResultList();
		return listado;
	}
	
	
	/**
	 * Este metodo permite eliminar un registro mediante un valor numerico obtenido.
	 * @param codigo va a resivir un valor numerico 
	 */
	public void delete(int codigo) {
		Receta rec = em.find(Receta.class, codigo);
		em.remove(rec);
		
	}

//--------------------------------------------------------------------
	
	
	/**
	 * Este metodo va a permitir filtrar datos mediante el nombre
	 * @param nombre es el parametro que recive
	 * @return va a devolver un listado de datos
	 */
		public List<Receta> getListFiltroReceta(String nombre) {

			String jpql="SELECT re FROM Receta re WHERE nombreMascota like ?1 "; 
				nombre="%"+nombre+"%";
				Query query=em.createQuery(jpql,Receta.class);
				query.setParameter(1, nombre);
				List<Receta> listado =query.getResultList();
				
			return listado;
		}

}
