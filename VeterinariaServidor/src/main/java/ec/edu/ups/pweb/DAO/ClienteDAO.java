package ec.edu.ups.pweb.DAO;



import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.pweb.MODEL.Cliente;




@Stateless
public class ClienteDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Cliente cli) {
		em.persist(cli);		
	}
	
	public void update(Cliente cli) {
		em.merge(cli);
	}
	
	public Cliente read(String cedula) {
		Cliente cli = em.find(Cliente.class, cedula);
		return cli;
	}
	
	/*public void delete( String cedula) {
		Cliente cli = em.find(Cliente.class, cedula);
		em.remove(cli);
	}*/
	public List<Cliente>getList(){
		List<Cliente> listado=new ArrayList<Cliente>();
	
		String jpql="SELECT op FROM Cliente op"; 
		
		Query query =em.createQuery(jpql,Cliente.class);
		listado=query.getResultList();
	return listado;
	}

}
