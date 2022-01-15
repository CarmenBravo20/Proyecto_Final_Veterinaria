package ec.edu.ups.pweb.CLIENTE.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ec.edu.ups.pweb.CLIENTE.MODEL.Mascota;

@Stateless
public class MascotaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Mascota op) {
		em.persist(op);		
	}
	
	public void update(Mascota op) {
		em.merge(op);
	}
	
	public Mascota read(String codigo) {
		Mascota op = em.find(Mascota.class, codigo);
		return op;
	}
	
	public void delete( int codigo) {
		Mascota op = em.find(Mascota.class, codigo);
		em.remove(op);
	}
	public List<Mascota>getList(){
		List<Mascota> listado=new ArrayList<Mascota>();
	
		String jpql="SELECT op FROM Mascota op"; 
		
		Query query =em.createQuery(jpql,Mascota.class);
		listado=query.getResultList();
	return listado;
	}

}
