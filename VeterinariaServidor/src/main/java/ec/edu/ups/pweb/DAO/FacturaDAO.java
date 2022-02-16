package ec.edu.ups.pweb.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pweb.modelo.Factura;
/**
 * FacturaDAO va a representar una clase java que va alojar métodos 
 * para el funcionamiento. 
 * @author campo
 *
 */
@Stateless
public class FacturaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	 /**
	 * Este método permite la inserción de los datos de Factura
	 * @param fac permitira insertar todos los datos obtenidos
	 */
	public void insert(Factura fac) {	
		em.persist(fac);
	}
	
	
	/**
	 * Este método permite la actualizar los datos de la factura
	 * @param fac permitira actualizar los datos cambiados
	 */
	public void update(Factura fac) {	
		em.merge(fac);
	}
	
	
	public Factura read(int id) {	
		Factura fac = em.find(Factura.class, id);
		if(fac.getDetalle().size()>0)
			fac.getDetalle().get(0);

		return fac;
	}
	



}
