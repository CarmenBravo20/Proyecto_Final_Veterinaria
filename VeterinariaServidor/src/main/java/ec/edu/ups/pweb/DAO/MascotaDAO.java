package ec.edu.ups.pweb.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.pweb.MODEL.Mascota;



@Stateless
public class MascotaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Mascota ma) {
		em.persist(ma);		
	}
	
	public void update(Mascota ma) {
		em.merge(ma);
	}
	
}
