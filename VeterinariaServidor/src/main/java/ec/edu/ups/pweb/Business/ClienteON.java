package ec.edu.ups.pweb.Business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pweb.DAO.ClienteDAO;
import ec.edu.ups.pweb.MODEL.Cliente;

@Stateless
public class ClienteON implements ClienteRemote,ClienteONLocal{
	
	@Inject
	private ClienteDAO DAO;
	
	public void insert(Cliente cli) {
		DAO.insert(cli);		
	}
	
	public void update(Cliente cli) {
		DAO.update(cli);
	}
	
	public Cliente read(String cedula) {
		return DAO.read(cedula);
	}
	
	/*public void delete( String cedula) {
		Cliente cli = DAO.read(cedula);
		DAO.delete(cedula);
	}*/
	
	public List<Cliente>getClientes(){
		return DAO.getList();
	}

}
