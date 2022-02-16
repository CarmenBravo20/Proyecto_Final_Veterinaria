package ec.edu.ups.pweb.CLIENTE.MODEL;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name="TBL_Mascota")
public class Mascota implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="masc_codigo")
	private int codigo;
	
	@Column(name="masc_nombre")
	private String nombre;
	
	@Column(name="masc_raza")
	private String raza;
	
	@Column(name="masc_sexo")
	private String sexo;
	
	@ManyToOne
	@JoinColumn(name = "cli_codigo")
	private Cliente cliente;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	

}
