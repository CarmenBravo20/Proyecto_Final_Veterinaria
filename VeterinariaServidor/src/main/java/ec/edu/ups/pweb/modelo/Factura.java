package ec.edu.ups.pweb.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Factura va a representar el registro de los datos de la factura 
 * mas los datos de factura detalle mediante un fk.
 * @author alexa
 *
 */


@Entity
@Table(name="TBL_Factura")
public class Factura implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L; 
		
			@Id
			@GeneratedValue
			@Column(name="fac_codigo")
			private int codigo;
			@Column(name="fac_fecha")
			private Date fecha;
			@Column(name="cli_cedula")
			private String cedula;
			@Column(name="cli_nombre")
			private String nombre;
			@Column(name="cli_email")
			private  String email;
			@Column(name="cli_direccion")
			private String direccion;
			@Column(name="cli_telefono")
			private String telefono;
			@OneToMany
			@JoinColumn(name="fac_codigofk")
			private List<FacturaDet>detalle;
			
			
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
			public String getNombre() {
				return nombre;
			}
			public void setNombre(String nombre) {
				this.nombre = nombre;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public String getDireccion() {
				return direccion;
			}
			public void setDireccion(String direccion) {
				this.direccion = direccion;
			}
			public String getTelefono() {
				return telefono;
			}
			public void setTelefono(String telefono) {
				this.telefono = telefono;
			}
			public List<FacturaDet> getDetalle() {
				return detalle;
			}
			public void setDetalle(List<FacturaDet> detalle) {
				this.detalle = detalle;
			}
		
	public void addDetalle(FacturaDet det) {
		if(detalle==null) {
			detalle = new  ArrayList<FacturaDet>();
	
		}
		
		detalle.add(det);
	}
}
