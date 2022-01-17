package ec.edu.ups.pweb.Business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.pweb.MODEL.Cliente;

@Remote
public interface ClienteRemote {

	public void insert(Cliente cli);
	
	public void update(Cliente cli);
	
	public Cliente read(String cedula);
	
	public List<Cliente>getClientes();
}
