package ec.edu.ups.pweb.Bean;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;


import ec.edu.ups.pweb.Business.CitaONLocal;
import ec.edu.ups.pweb.modelo.Cita;
/**
 * 
 * @author campo
 *
 */
@WebService
public class CitasSOAP {

	@Inject
	private CitaONLocal citaON;
	
	
	@WebMethod
	public String crearContacto(Cita cita) {
		try {
			citaON.guardarCita(cita);
			return "Cita Guardada";
		}catch (Exception e) {
			return "ERROR";
		}	
	}
	@WebMethod
	public List<Cita> getCitas(){
		return citaON.getListCita();
	}
	
	
}
