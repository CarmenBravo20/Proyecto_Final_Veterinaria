package ec.edu.ups.pweb.Bean;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pweb.Business.MascotaLocal;
import ec.edu.ups.pweb.modelo.Cita;
import ec.edu.ups.pweb.modelo.Cliente;
import ec.edu.ups.pweb.modelo.Mascota;
/**
 * 
 * @author alexa
 *
 */
@Named
@RequestScoped
public class MascotaBean {
	
	
	@Inject
	private MascotaLocal mascotaON;
	
	private Cita cit=new Cita();
	
	public Cita getCit() {
		return cit;
	}
	public void setCit(Cita cit) {
		this.cit = cit;
	}

	private int codigo;
	private Mascota mascota=new Mascota();
	private List<Mascota>mascotas;
	private List<Mascota>mascotasFiltro;
	private String cedula;



		
		public List<Mascota> getMascotasFiltro() {
		return mascotasFiltro;
	}
	public void setMascotasFiltro(List<Mascota> mascotasFiltro) {
		this.mascotasFiltro = mascotasFiltro;
	}
		public String getCedula() {
			return cedula;
		}
		public void setCedula(String cedula) {
			this.cedula = cedula;
		}
		public int getCodigo() {
			return codigo;
		}
		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}
		public Mascota getMascota() {
			return mascota;
		}
		public void setMascota(Mascota mascota) {
			this.mascota = mascota;
		}
		public List<Mascota> getMascotas() {
			return mascotas;
		}
		public void setMascotas(List<Mascota> mascotas) {
			this.mascotas = mascotas;
		}
		
		public MascotaBean(){
			
		
		}

		@PostConstruct
		public void init() {
			
			this.LoadData();
		}
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * carga datos de la mascota según el código que se seleccione 
		 */
		public void CargaDatos() {
			if(codigo==0)
				return;
			this.mascota=mascotaON.getMascota(codigo);
		}		
		
		/**
		 * permite editar de un listado por el código mandando al formulario
		 * @param codigo valor que obtiene
		 * @return retorna al registro
		 */
		public String editar(int codigo) {
			System.out.println("set "+ codigo);
			
			return"RegistroMascotas?faces-redirect=true&id="+codigo;
			
		}
		/**
		 * carga los datos en el formulario de registro para editar
		 */
		public void loadDataEditar() {
			Mascota m=mascotaON.getMascota(codigo);
			System.out.println("llego" + m.getCodigo());
			mascota=m;
		}
		/**
		 * Permite eliminar de un listado por el código
		 * @param codigo valor que obtienen
		 * @return retorna al listado 
		 */
	public String delete(int codigo) {
	System.out.println("Numero de" +codigo);
	mascotaON.delete(codigo);
	return "ListadoMascota?faces-redirect=true";

	}
		
	/**
	 * guarda los datos o actualiza si es que el dato ya ha sido guardado
	 * @return retorna a la lista
	 */
	public String guardar() {
		System.out.println("Guardando= "+this.codigo);
		this.mascota.setCodigo(this.codigo);
		try {
			mascotaON.guardarMascota(this.mascota);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ListadoMascota?faces-redirect=true";
		
	}
	
	/**
	 * carga los datos en un listado mandando al constructor para que se liste inmediatamente
	 */
	public void LoadData() {
		this.mascotas=mascotaON.getMascotas();
	}

///////////////////////////////////////////////////////////////////////
	/**
	 * permite filtar los datos de mascotas por la cedula
	 */
	
	public void MascotasFiltrar() {
		mascotasFiltro = mascotaON.getListFiltroMascota(cedula);
		this.mascotas = mascotasFiltro;
		System.out.println(mascotasFiltro.size());
	}

}
