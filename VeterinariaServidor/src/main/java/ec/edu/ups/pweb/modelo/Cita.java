package ec.edu.ups.pweb.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * Cita va a representar el registro de los datos de la persona con de la mascota.
 * @author campo
 *
 */


@Entity
@Table(name="TBL_Citas")
public class Cita implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue
	@Column(name="cit_codigo")
	private int codigo;
	
	@Column(name="cit_fecha")
	private Date fecha;
	
	@Column(name="cit_hora")
	private String hora;
	
	@Column(name="cit_descripcion")
	private String descripcion;
	
	
	@Column(name="cli_cedula")
	private String cedula;
	
	@Column(name="mas_nombre")
	private String nombre;

	@Column(name="cit_estado")
	private String estado;
	
	
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
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
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCedula() {
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
	
	
}
