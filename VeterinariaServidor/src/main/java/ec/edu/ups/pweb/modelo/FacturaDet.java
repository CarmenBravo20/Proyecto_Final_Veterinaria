package ec.edu.ups.pweb.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * FacturaDet va a representar el registro de los datos de una factura detalle.
 * @author alexa
 *
 */
@Entity
@Table(name="TBL_FacturaDet")
public class FacturaDet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	
	
	@Id
	@GeneratedValue
	@Column
	private int codigo;
	@Column(name = "det_Descripcion")
	private String Descripcion;
	@Column(name="det_cantidad")
	private int cantidad;
	@Column(name="det_precio")
	private double precio;
	@Column(name="det_total")
	private double total;
	
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	
	
}
