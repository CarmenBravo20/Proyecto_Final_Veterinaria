package ec.edu.ups.pweb.CLIENTE.BUSINESS;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import ec.edu.ups.pweb.CLIENTE.DAO.MascotaDAO;
import ec.edu.ups.pweb.CLIENTE.MODEL.Mascota;

@Stateless
public class MascotaON {

@Inject
private MascotaDAO mascotaDAO;

	public void insert(Mascota mascota){
		mascotaDAO.insert(mascota);		
	}
	
	public void update(Mascota mascota) {
		mascotaDAO.update(mascota);;
	}
	
	public Mascota read(String codigo) {
		return mascotaDAO.read(codigo);
	}
	
	public void delete( int codigo) {
		mascotaDAO.delete(codigo);
	}
	public List<Mascota>getList(){
		return mascotaDAO.getList();
	}
}
