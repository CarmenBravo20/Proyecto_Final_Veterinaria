package ec.edu.ups.pweb.Business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.pweb.modelo.Factura;
/**
 * Esta interfaz permitira consumir los métodos de manera local
 * @author campo
 *
 */
@Local
public interface FacturaONLocal {
	
	
	public void insertar(Factura fac);
	
	public Factura getFactura(int codigo);


}
