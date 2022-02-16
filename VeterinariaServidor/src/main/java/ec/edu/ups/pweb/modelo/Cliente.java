package ec.edu.ups.pweb.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Cliente va a representar el registro de los datos de la persona.
 * @author campo
 *
 */
@Entity
@Table(name="TBL_Cliente")
public class Cliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	
		@Id
		@Column(name="cli_cedula")
		private String cedula;
		
		@Column(name="cli_nombre")
		private String nombre;
		
		@Column(name="cli_apellido")
		private  String apellido;
		
		@Column(name="cli_email")
		private  String email;
		
		@Column(name="cli_password")
		private  String password;

		@Column(name="cli_direccion")
		private String direccion;
		
		@Column(name="cli_telefono")
		private String telefono;

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

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
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
		
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}	

}
