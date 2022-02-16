package ec.edu.ups.pweb.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Receta va a representar el registro de los datos de la persona con de la mascota y un hora y fecha
 * para su cita.
 * @author alexa
 *
 */
@Entity
@Table(name="TBL_Receta")
public class Receta  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="rec_codigo")
	private int codigo;
	
	@Column(name="rec_fecha")
	private Date fecha;
	
	@Column(name="rec_cedula")
	private String cedula;
	
	@Column(name="rec_nombreDuenio")
	private String nombreDuenio;
	
	@Column(name="rec_nombreMascota")
	private String nombreMascota;
	
	@Column(name="rec_raza")
	private String raza;
	
	@Column(name="rec_descripcion")
	private String descripcion;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombreDuenio() {
		return nombreDuenio;
	}
	public void setNombreDuenio(String nombreDuenio) {
		this.nombreDuenio = nombreDuenio;
	}
	public String getNombreMascota() {
		return nombreMascota;
	}
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	

}
