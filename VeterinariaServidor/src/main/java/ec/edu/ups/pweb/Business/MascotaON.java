package ec.edu.ups.pweb.Business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

import ec.edu.ups.pweb.DAO.MascotaDAO;
import ec.edu.ups.pweb.modelo.Cliente;
import ec.edu.ups.pweb.modelo.Mascota;
/**
 * Esta clase va a llamar a los métodos realizados en el DAO mediante la instancia
 * @author alexa
 *
 */
@Stateless
public class MascotaON implements MascotaLocal{

	@Inject
	private MascotaDAO DAO;
	
	public void insert(Mascota ma) {
		DAO.insert(ma);		
	}
	
	public void update(Mascota ma) {
		DAO.update(ma);
	}
	public void delete(int codigo) {
		DAO.delete(codigo);
	}
	
	
	public List<Mascota>getMascotas(){
		return DAO.getList();
	}
	
	public Mascota getMascota(int id) {
		
		return DAO.read(id); 
	}
	public void guardarMascota(Mascota ma) throws Exception {
		
		if(DAO.read(ma.getCodigo())==null) {
			System.out.println("holaaaaa"+DAO.read(ma.getCodigo()));
			DAO.insert(ma);
	}else {
			DAO.update(ma);
	}
	}
	public List<Mascota> getListFiltroMascota(String cedula) {

	return DAO.getListFiltroMascota(cedula);
}

}
