package ec.edu.ups.pweb.CLIENTE.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pweb.CLIENTE.MODEL.Cliente;


@Stateless
public class ClienteDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Cliente op) {
		em.persist(op);		
	}
	
	public void update(Cliente op) {
		em.merge(op);
	}
	
	public Cliente read(String cedula) {
		Cliente op = em.find(Cliente.class, cedula);
		return op;
	}
	
	public void delete( String cedula) {
		Cliente op = em.find(Cliente.class, cedula);
		em.remove(op);
	}
	
	public List<Cliente>getList(){
		List<Cliente> listado=new ArrayList<Cliente>();
	
		String jpql="SELECT op FROM Cliente op"; 
		
		Query query =em.createQuery(jpql,Cliente.class);
		listado=query.getResultList();
	return listado;
	}

}
