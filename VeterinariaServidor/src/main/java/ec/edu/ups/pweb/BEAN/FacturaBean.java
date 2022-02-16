package ec.edu.ups.pweb.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pweb.Business.FacturaONLocal;
import ec.edu.ups.pweb.modelo.Factura;
import ec.edu.ups.pweb.modelo.FacturaDet;

@Named
@RequestScoped
public class FacturaBean {

	
	@Inject
	private FacturaONLocal facturaON;
	
	
//////////////////////////////////////////
	
	Factura fac=new Factura();
	//FacturaDet det=new FacturaDet();
	private ArrayList<FacturaDet> Lista=new ArrayList<FacturaDet>(); 
	//private Factura fac;
	private FacturaDet facdet;
	
	

	public FacturaDet getFacdet() {
		return facdet;
	}

	public void setFacdet(FacturaDet facdet) {
		this.facdet = facdet;
	}

	public Factura getFac() {
		return fac;
	}

	public void setFac(Factura fac) {
		this.fac = fac;
	}

	

	public FacturaBean() {
		
	}
	
	
	
/////////////////////////////////////////	
	
	public ArrayList<FacturaDet> getLista() {
		return Lista;
	}

	public void setLista(ArrayList<FacturaDet> lista) {
		Lista = lista;
	}

	@PostConstruct
	public void init() {
		facdet=new FacturaDet();
		fac.addDetalle(new FacturaDet());
		
	}
		
////////////////////////////////////////	
	
	

public void Agregar() {
	System.out.println("hola");	
		if(facdet!= null) {
			
			Lista.add(facdet);
			System.out.println(Lista.size());
			facdet= new FacturaDet();
		}else {
		System.out.println("ERROR");
	}		

	
	/*public String Guardar() {
	
		
		try {
			facturaON.guardarFactura(this.factura);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ListadoCitas?faces-redirect=true";
	}
	
	public void loadFactura() {
		this.Lista=facturaON.getListFactura();
	}*/
	}
	
	
	
}
