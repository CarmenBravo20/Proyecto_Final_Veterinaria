package ec.edu.ups.pweb.Business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.pweb.MODEL.Cliente;

@Local
public interface ClienteONLocal {

public void insert(Cliente cli);
	
	public void update(Cliente cli);
	
	public Cliente read(String cedula);
	
	public List<Cliente>getClientes();
}
