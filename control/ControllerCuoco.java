package control;

import entity.EntityCatalogoOrdini;

public class ControllerCuoco {
	
	public static String PrendiOrdineInCarico() {
		
		EntityCatalogoOrdini catalogo = new EntityCatalogoOrdini();
		String risp = catalogo.PrendiOrdineInCarico();
		
		if(risp.equals("errore")) return "Nessun ordine in arrivo!";
		else return "Ordine preso in carico:\n\n"+risp;
	}
	
	public static String SegnalaOrdineProntoPerConsegna(int idOrdine) { 
		
		EntityCatalogoOrdini catalogo = new EntityCatalogoOrdini();
		int risp = catalogo.SegnalaOrdineProntoPerConsegna(idOrdine);
		
		if(risp==-1) return "Nessun corriere attualmente disponibile!";
		else return "Ordine segnalato! Consegna assegnata al corriere con id: "+risp;
	}
}