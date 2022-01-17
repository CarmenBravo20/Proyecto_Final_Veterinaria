package ec.edu.ups.pweb.Business;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pweb.DAO.MascotaDAO;
import ec.edu.ups.pweb.MODEL.Mascota;

@Stateless
public class MascotaON implements MascotaRemota,MascotaLocal{

	@Inject
	private MascotaDAO DAO;
	
	public void insert(Mascota ma) {
		DAO.insert(ma);		
	}
	
	public void update(Mascota ma) {
		DAO.update(ma);
	}
}
