package ec.edu.ups.pweb.CLIENTE.MODEL;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_Cliente")
public class Cliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	
	
		@Id
		@Column(name="cli_codigo")
		private int codigo;
		
		@Column(name="cli_cedula")
		private String cedula;
		
		@Column(name="cli_nombre")
		private String nombre;
		
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
		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		@Override
		public String toString() {
			return "Cliente [cedula=" + cedula + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono="
					+ telefono + "]";
		}

}
