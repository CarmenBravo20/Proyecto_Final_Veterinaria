package ec.edu.ups.pweb.CLIENTE.BUSINESS;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.pweb.CLIENTE.DAO.ClienteDAO;
import ec.edu.ups.pweb.CLIENTE.MODEL.Cliente;


@Stateless
public class ClienteON implements ClienteONLocal,ClienteONRemote{
	
@Inject
private ClienteDAO clienteDAO;
	

	public void insert(Cliente op) {
		clienteDAO.insert(op);		
	}
	
	public void update(Cliente op) {
		clienteDAO.update(op);
	}
	
	public Cliente read(String cedula) {
		return clienteDAO.read(cedula);
	}
	
	public void delete( String cedula) {
		clienteDAO.delete(cedula);
	}
	public List<Cliente>getClientes(){
		return clienteDAO.getList();
	}
	

}
