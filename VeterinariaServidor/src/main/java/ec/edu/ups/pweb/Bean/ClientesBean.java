package ec.edu.ups.pweb.Bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pweb.Business.ClienteONLocal;
import ec.edu.ups.pweb.MODEL.Cliente;




//import javax.annotation.PostConstruct;

@Named
@RequestScoped
public class ClientesBean {
	
	@Inject
	private ClienteONLocal clientesON;
	

	
	private Cliente cliente=new Cliente();
	private List<Cliente>clientes;
	
	public ClientesBean(){
		
	}
@PostConstruct
	public void  init() {
		this.loadCLientes();
	}

	
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String Guardar() {
		System.out.println("Guardando"+this.cliente.getNombre());
		
		try {
			clientesON.insert(this.cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Listado-personas?faces-redirect=true";
	}
	public void loadCLientes() {
		this.clientes=clientesON.getClientes();
	}

}
