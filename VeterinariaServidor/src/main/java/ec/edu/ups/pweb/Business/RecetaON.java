package ec.edu.ups.pweb.Business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

import ec.edu.ups.pweb.DAO.RecetaDAO;
import ec.edu.ups.pweb.modelo.Mascota;
import ec.edu.ups.pweb.modelo.Receta;
/**
 * Esta clase va a llamar a los métodos realizados en el DAO mediante la instancia
 * @author alexa
 *
 */
@Stateless
public class RecetaON implements RecetaONLocal{
	
	@Inject
	private RecetaDAO recetaDAO;
	
	public void insert(Receta rec) {
		recetaDAO.insert(rec);		
	}
	
	public void update(Receta rec) {
		recetaDAO.update(rec);
	}
	
	public Receta read(int  codigo) {
		return recetaDAO.read(codigo);
	}
	
	public Receta getReceta(int id) {
		
		return recetaDAO.read(id); 
	}
	public void guardarReceta(Receta rec) throws Exception {
		if(recetaDAO.read(rec.getCodigo())==null) {
			recetaDAO.insert(rec);
	}else {
		recetaDAO.update(rec);
	}
	}
	
	public void delete(int  codigo) {
		recetaDAO.delete(codigo);
	}


	public List<Receta>getRecetasCli(String cedula){
		return recetaDAO.getListRecetaCli(cedula);
	}

	
	public List<Receta> getReceta() {
		return recetaDAO.getList();
	}

	public List<Receta> getListFiltroReceta(String nombre) {
			
		return recetaDAO.getListFiltroReceta(nombre);
	}
		
	 
}
