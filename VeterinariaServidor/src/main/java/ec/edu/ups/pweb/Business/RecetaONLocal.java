package ec.edu.ups.pweb.Business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.pweb.modelo.Receta;
/**
 * Esta interfaz permitira consumir los métodos de manera local
 * @author alexa
 *
 */
@Local
public interface RecetaONLocal {
	
	public void insert(Receta rec);
	public void guardarReceta(Receta rec) throws Exception;
	public void delete(int codigo);
	public List<Receta>getRecetasCli(String cedula);
	public List<Receta>getReceta();
	public List<Receta> getListFiltroReceta(String nombre);
	public Receta getReceta(int id);
	

}
