package ec.edu.ups.pweb.Business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.pweb.modelo.Cliente;
/**
 * Esta interfaz permitira consumir los métodos de manera local
 * @author campo
 *
 */
@Local
public interface ClienteONLocal {

public void insert(Cliente cli);
	
	public void update(Cliente cli);
	
	public Cliente read(String cedula);
	
	public List<Cliente>getClientes();
	public void delete(String cedula);
	public Cliente getCliente(String cedula);
	public void guardarPersona(Cliente p) throws Exception;
}
