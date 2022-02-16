package ec.edu.ups.pweb.Business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pweb.DAO.FacturaDAO;
import ec.edu.ups.pweb.modelo.Factura;
/**
 * Esta clase va a llamar a los métodos realizados en el DAO mediante la instancia
 * @author campo
 *
 */
@Stateless
public class FacturaON implements FacturaONLocal{

	
	@Inject
	private FacturaDAO DAO;
	
	public void insertar(Factura fac) {
		DAO.insert(fac);
	}
		
	public Factura getFactura(int codigo) {
		return DAO.read(codigo);
	}
	
	
}
