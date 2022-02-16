package ec.edu.ups.pweb.Bean;


import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pweb.Business.CitaON;
import ec.edu.ups.pweb.Business.CitaONLocal;
import ec.edu.ups.pweb.Business.MascotaLocal;
import ec.edu.ups.pweb.Business.RecetaON;
import ec.edu.ups.pweb.modelo.Cita;
import ec.edu.ups.pweb.modelo.Cliente;
import ec.edu.ups.pweb.modelo.Mascota;
/**
 * 
 * @author campo
 *
 */
@Named
@RequestScoped
public class CitasBean {

	@Inject
	private CitaONLocal citaON;
	
	//@Inject
	//private MascotaLocal mascotaON;
	

	
/////////////////////////////////////////////////////	
	
	private Mascota mascota=new Mascota();
	//private List<Mascota> ma; 
	private List<Cita> citas;
	private List<Cita> Filtrocitas;
	private Cita cita=new Cita();
	private String cedula;
	private String nombre;
	private int codigo;	
/////////////////////////////////////////////////////	
	
	
	public int getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Cita> getFiltrocitas() {
		return Filtrocitas;
	}
	public void setFiltrocitas(List<Cita> filtrocitas) {
		Filtrocitas = filtrocitas;
	}
	public Mascota getMascota() {
		return mascota;
	}
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public List<Cita> getCitas() {
		return citas;
	}
	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		System.out.println(cedula);
		this.cedula = cedula;
	}
	public CitaONLocal getCitaON() {
		return citaON;
	}
	public void setCitaON(CitaONLocal citaON) {
		this.citaON = citaON;
	}
	public Cita getCita() {
		return cita;
	}
	public void setCita(Cita cita) {
		this.cita = cita;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public CitasBean() {
		
	}
	
	@PostConstruct
	public void init() {
		//Permite hacer que se inserte la lista en la tabla
		FacesContext facesContext = FacesContext. getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		Map<String, String> parameterMap = (Map<String, String>) externalContext.getRequestParameterMap(); 
		String param = parameterMap.get("id");
		this.cedula=param;	
		citas=citaON.getCitalist(cedula);

	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Este método permite guardar las citas que se ingresaron
	 * en un formulario
	 * @return retorna a el mismo registro .
	 */

	public String Guardar() {
		try {
			citaON.guardarCita(this.cita);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "RegistrarCita?faces-redirect=true";
		
	}
	
	public String delete(int codigo) {
		citaON.delete(this.codigo);
		return "ListadoCitas?faces-redirect=true";
		
	
		
	}

	/**
	 * permite buscar por cédula
	 * @param cedu parámetro que obtiene 
	 * @return retorna a un listado 
	 */
	public String BuscarCita(String cedu){
		
		return "ListadoCitas?faces-redirect=true&id="+cedu;
	}
	
	/**
	 * permite filtrar datos mediante el nombre
	 */
	
	public void CitasFiltrar() {
		Filtrocitas = citaON.getListFiltroCita(nombre);
		this.citas = Filtrocitas;
		System.out.println(Filtrocitas.size());
	}

	
}