package ec.edu.ups.pweb.Business;

import javax.ejb.Local;

import ec.edu.ups.pweb.MODEL.Mascota;

@Local
public interface MascotaLocal {

	public void insert(Mascota ma);
	
	public void update(Mascota ma);
}
