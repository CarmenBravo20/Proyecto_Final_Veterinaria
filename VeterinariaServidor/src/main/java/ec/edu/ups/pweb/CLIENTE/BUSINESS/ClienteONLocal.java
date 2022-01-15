package ec.edu.ups.pweb.CLIENTE.BUSINESS;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.pweb.CLIENTE.MODEL.Cliente;

@Local
public interface ClienteONLocal {

	public void insert(Cliente cliente) throws Exception; ;
	
	public void update(Cliente cliente);
	
	public Cliente read(String cedula) ;
	
	public void delete( String cedula);
	public List<Cliente>getClientes();
	
}
