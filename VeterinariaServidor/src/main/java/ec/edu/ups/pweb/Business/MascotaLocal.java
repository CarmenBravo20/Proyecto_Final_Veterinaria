package ec.edu.ups.pweb.Business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.pweb.modelo.Mascota;
/**
 * Esta interfaz permitira consumir los métodos de manera local
 * @author alexa
 *
 */
@Local
public interface MascotaLocal {

	public void insert(Mascota ma);
	public List<Mascota>getMascotas();
	public void update(Mascota ma);
	public void delete(int codigo);
	public Mascota getMascota(int id);
	public List<Mascota> getListFiltroMascota(String cedula);
	public void guardarMascota(Mascota ma) throws Exception ;
}
