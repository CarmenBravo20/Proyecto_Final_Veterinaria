package ec.edu.ups.pweb.Business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pweb.DAO.ClienteDAO;
import ec.edu.ups.pweb.modelo.Cliente;
/**
 * Esta clase va a llamar a los métodos realizados en el DAO mediante la instancia
 * @author campo
 *
 */

@Stateless
public class ClienteON implements ClienteONLocal{
	
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
	public void guardarPersona(Cliente p) throws Exception {
		if(DAO.read(p.getCedula())==null) {
			DAO.insert(p);
	}else {
			DAO.update(p);
	}
	}
	
	public void delete(String cedula) {
		DAO.delete(cedula);
	}
	/*public void delete( String cedula) {
		Cliente cli = DAO.read(cedula);
		DAO.delete(cedula);
	}*/
	
	public List<Cliente>getClientes(){
		return DAO.getList();
	}

	 public Cliente getCliente(String cedula) {
		 return DAO.read(cedula);
	 }
}
