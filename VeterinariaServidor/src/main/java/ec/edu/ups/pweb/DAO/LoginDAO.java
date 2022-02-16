package ec.edu.ups.pweb.DAO;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pweb.modelo.Cliente;
import ec.edu.ups.pweb.modelo.Veterinario;
/**
 * LoginDAO va a representar una clase java que va alojar métodos 
 * para el funcionamiento. 
 * @author campo
 *
 */

@Stateless
public class LoginDAO {
	
	@PersistenceContext
	private EntityManager em;

	/**
	 * Este método permitira obtener datos específicos de la base para el login 
	 * @param usuario  recibe el email registrado
	 * @param contra recibeel password registrado
	 * @return nos va a devolver los datos hechos por la consulta
	 */
	public Cliente ObtenerLogin(String usuario, String contra) {
		try {
		String jpq3="SELECT c FROM Cliente c WHERE email = ?1 AND password = ?2";
		
		Query query=em.createQuery(jpq3,Cliente.class);
		query.setParameter(1, usuario);
		query.setParameter(2, contra);
		
		Cliente cli=(Cliente)query.getSingleResult();
		return cli ;
	}catch (Exception e) {
		return null;
	}
	}

	/**
	 * Este método permitira obtener datos específicos de la base para el login 
	 * @param usuario recibe el email registrado
	 * @param contra recibe el password registrado
	 * @return nos va a devolver los datos hechos por la consulta
	 */
	public Veterinario ObtenerLoginVet(String usuario, String contra) {
		try {
		String jpq3="SELECT v FROM Veterinario v WHERE email = ?1 AND password = ?2";
		
		Query query=em.createQuery(jpq3,Veterinario.class);
		query.setParameter(1, usuario);
		query.setParameter(2, contra);
		
		Veterinario vet=(Veterinario)query.getSingleResult();
		return vet ;
	}catch (Exception e) {
		return null;
	}
	}
	
	
}