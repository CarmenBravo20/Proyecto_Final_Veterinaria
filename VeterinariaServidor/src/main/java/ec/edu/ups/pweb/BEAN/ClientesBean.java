package ec.edu.ups.pweb.Bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pweb.Business.ClienteONLocal;
import ec.edu.ups.pweb.modelo.Cliente;

/**
 * 
 * @author campo
 *
 */

@Named
@RequestScoped
public class clientesBean {
	
	@Inject
	private ClienteONLocal clientesON;
	
	private String cedula;
	
	private Cliente cliente=new Cliente();
	private List<Cliente>clientes;
	
	public clientesBean(){
		
	}
	
public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

@PostConstruct
	public void  init() {
		this.loadCLientes();
	}

	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	

	
	public void loadData() {
		if(cedula==null)
			return;
		Cliente p=clientesON.getCliente(cedula); 
		cliente=p;
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	/**
	 * carga los datos en el formulario de registro
	 */
	public void loadDataEditar() {
		Cliente p=clientesON.getCliente(cliente.getCedula()); 
		cliente=p;
	}

	public String Guardar() {
		System.out.println("Guardando"+this.cliente.getNombre());
	
		try {
			clientesON.guardarPersona(this.cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "LoginCliente?faces-redirect=true";
	}
	
	/**
	 * permite editar de un listado por el número de cédula mandando al formulario
	 * @param cedula valor que obtiene
	 * @return retorna al EditarPersonas
	 */
	public String editar(String cedula) {
		System.out.println("set "+ cedula);
		return"EditarPersonas?faces-redirect=true&id="+cedula;
		
	}
	
	
	/**
	 * Permite eliminar de un listado por el número de cédula
	 * @param cedula valor que obtienen
	 * @return retorna al listado 
	 */

	public String delete(String cedula) {
		System.out.println("Numero de" +cedula);
		clientesON.delete(cedula);
		return "Listado-personas?faces-redirect=true";
		
	
		
	}
	
	/**
	 * carga los datos en un listado mandando al contructor que se liste inmediatamente
	 */
	public void loadCLientes() {
		this.clientes=clientesON.getClientes();
	}
////////////////////////////////////////////////////////////////////////
	/**
	 * guarda los datos editados 
	 * @return retorna a la lista de la persona 
	 */
	public String GuardarEditado() {
	
		try {
			clientesON.guardarPersona(this.cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ListadoPersonas?faces-redirect=true";
	}

}



