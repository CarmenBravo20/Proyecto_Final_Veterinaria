package ec.edu.ups.pweb.Business;

import javax.ejb.Remote;

import ec.edu.ups.pweb.MODEL.Mascota;

@Remote
public interface MascotaRemota {

	public void insert(Mascota ma);
	
	public void update(Mascota ma);
}
