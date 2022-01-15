package ec.edu.ups.pweb.CLIENTE.BUSINESS;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.pweb.CLIENTE.MODEL.Mascota;

@Remote
public interface MascotaONRemote {
	public void insert(Mascota mascota) throws Exception;
	
	public void update(Mascota mascota);
	
	public Mascota read(String codigo) ;
	
	public void delete( int codigo) ;
	public List<Mascota>getList();
	
}