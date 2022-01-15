package ec.edu.ups.pweb.BEAN;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pweb.CLIENTE.BUSINESS.ClienteONLocal;
import ec.edu.ups.pweb.CLIENTE.MODEL.Cliente;


//import javax.annotation.PostConstruct;

@Named
@RequestScoped
public class ClientesBean {
	
	@Inject
	private ClienteONLocal clientesON;
	
	/*private String cedula;
	private String nombre;
	private String direccion;*/
	
	private Cliente cliente=new Cliente();
	private List<Cliente>clientes;
	
	public ClientesBean(){
		
	}
@PostConstruct
	public void  init() {
		this.loadCLientes();
	}

	/*public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}*/
	
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
		/*System.out.println("Guardando"+this.nombre);
		Persona p=new Persona();
		p.setCedula(this.cedula);
		p.setNombre(this.nombre);
		p.setDireccion(this.direccion);
		try {
			clientesON.insertar(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/
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
