package ec.edu.ups.pweb.Bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ec.edu.ups.pweb.Business.RecetaONLocal;
import ec.edu.ups.pweb.modelo.Mascota;
import ec.edu.ups.pweb.modelo.Receta;
/**
 * 
 * @author alexa
 *
 */

@Named
@RequestScoped
public class RecetaBean {
	
	@Inject
	private RecetaONLocal recetaON;
	
	private int codigo;
	Receta receta=new Receta();
	private List<Receta> rece;
	private List<Receta> receFiltro;
	private String nombre;
	
	private RecetaBean() {
		
	}
	@PostConstruct
	public void inicio() {
		
		this.loadR();
	}

	
	
	
	public List<Receta> getReceFiltro() {
		return receFiltro;
	}
	public void setReceFiltro(List<Receta> receFiltro) {
		this.receFiltro = receFiltro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
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


	

	
	public String Guardar() {
		System.out.println("Guardando"+this.receta.getNombreDuenio());

		try {
			this.receta.setCodigo(this.codigo);
			recetaON.guardarReceta(this.receta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ListadoRecetas?faces-redirect=true";
	}
	
	public void CargaDatos() {
		if(codigo==0)
			return;
		this.receta=recetaON.getReceta(codigo);
	}		
	/**
	 * carga los datos en el formulario de registro
	 */
	public void loadDataEditar() {
		Receta rece=recetaON.getReceta(codigo);
		System.out.println("llego" + rece.getCodigo());
		receta=rece;
	}
	
	/**
	 * permite editar de un listado por el código mandando al formulario
	 * @param codigo valor que obtiene
	 * @return retorna al registro
	 */
	public String editar(int codigo) {
		System.out.println("set "+ codigo);
		return "RegistrarReceta?faces-redirect=true&id="+codigo;
		
	}
	
	/**
	 * Permite eliminar de un listado por el codigo
	 * @param codigo valor que obtienen
	 * @return retorna al listado 
	 */

	public String delete(int  codigo) {
		System.out.println("Numero de" +codigo);
		recetaON.delete(codigo);
		return "ListadoRecetas?faces-redirect=true";
		
	
		
	}
	/**
	 * carga los datos en un listado mandando al constructor que se liste inmediatamente
	 */
	public void loadR() {
		this.rece=recetaON.getReceta();
	}

	/**
	 * Este método permite filtrar los datos por el nombre
	 */
	public void RetasFiltrar() {
		receFiltro = recetaON.getListFiltroReceta(nombre);
		this.rece = receFiltro;
		System.out.println(receFiltro.size());
	}
	
}
