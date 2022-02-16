package ec.edu.ups.pweb.Bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pweb.Business.LoginONLocal;
import ec.edu.ups.pweb.modelo.Cliente;
import ec.edu.ups.pweb.modelo.Veterinario;
/**
 * 
 * @author campo
 *
 */
@Named
@RequestScoped
public class LoginBean {
	
	@Inject
	private LoginONLocal login;
	
	
	
	Cliente cliente=new Cliente();
	
	Veterinario veterinario=new Veterinario();


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	
	
	
	@PostConstruct
	public void  init() {
		
	}
	
	
	/**
	 * permite validar el login con los datos que se obtienen
	 * @return retorna a la ventana correspondiente
	 */
	public String ValidarLogin() {

		try {
			Cliente cli = login.ObtenerLogin(cliente.getEmail(), cliente.getPassword());
			System.out.println(cliente.getEmail()+" / "+cliente.getPassword());
			if (cli == null) {

				System.out.println("usuario Incorrecto");
				return null;
			} else {
				System.out.println("usuario Correcto");
				return "VentanaCliente.xhtml";
			}
		} catch (Exception e) {
			System.out.println("hola eror");
			return null;
		}
	}
	
	
	/**
	 * permite validar el login con los datos que se obtienen
	 * @return retorna a la ventana correspondiente
	 */
	public String ValidarLoginVet() {

		try {
			Veterinario vet = login.ObtenerLoginVet(veterinario.getEmail(), veterinario.getPassword());	

			if (vet == null) {

				System.out.println("usuario Incorrecto");
				
				return "";
			} else {
				System.out.println("usuario Correcto");
				return "VentanaVeterinaria.xhtml";
			}
		} catch (Exception e) {
			return "";
		}
			
	}
	
}
