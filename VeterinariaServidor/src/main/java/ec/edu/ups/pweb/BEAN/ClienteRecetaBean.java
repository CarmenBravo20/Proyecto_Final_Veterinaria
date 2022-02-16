package ec.edu.ups.pweb.Bean;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import ec.edu.ups.pweb.Business.RecetaONLocal;
import ec.edu.ups.pweb.modelo.Receta;
/**
 * 
 * @author campo
 *
 */

@Named
@RequestScoped
public class ClienteRecetaBean {
	
	@Inject
	private RecetaONLocal recetaON;
	
	
	Receta receta=new Receta();
	private List<Receta> rece;
	private String cedula;
	
	
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	private ClienteRecetaBean() {
		
	}

	public Receta getReceta() {
		return receta;
	}


	public void setReceta(Receta receta) {
		this.receta = receta;
	}


	public List<Receta> getRece() {
		return rece;
	}


	public void setRece(List<Receta> rece) {
		this.rece = rece;
	}
	
////////////////////////////////////////////////////////////////////////////////////
	
	@PostConstruct
	public void inicio() {
		
		//Permite hacer que se inserte la lista en la tabla
				FacesContext facesContext = FacesContext. getCurrentInstance();
				ExternalContext externalContext = facesContext.getExternalContext();
				Map<String, String> parameterMap = (Map<String, String>) externalContext.getRequestParameterMap(); 
				String param = parameterMap.get("id");
				this.cedula=param;	
				rece=recetaON.getRecetasCli(cedula);
	}
	
	/**
	 * Este metodo permite guardar las recetas que se ingresaron
	 * en un formulario por el veterinario
	 * @return retorna a el mismo registro .
	 */
	public String Guardar() {

		try {
			recetaON.guardarReceta(this.receta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "RegistrarReceta?faces-redirect=true";
	}
	
	
	/**
	 * permite buscar por cédula
	 * @param cedu parámetro que obtiene 
	 * @return retorna a un listado 
	 */
	public String BuscarReceta(String cedu){
		
		return "ClienteListadoRecetas?faces-redirect=true&id="+cedu;
	}



}
