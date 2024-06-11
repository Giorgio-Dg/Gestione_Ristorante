package control;

import entity.EntityCatalogoOrdini;

public class ControllerCuoco {
	
	public static String PrendiOrdineInCarico() {
		
		EntityCatalogoOrdini catalogo = new EntityCatalogoOrdini();
		boolean risp = catalogo.PrendiOrdineInCarico();
		
		if(risp) return "Ordine preso in carico correttamente";
		else return "Errore durante la presa in carico dell'ordine";
	}
	
	public static String SegnalaOrdineProntoPerConsegna(int idOrdine) { //controllare se l'id è giusto negli entity o dao?
		
		EntityCatalogoOrdini catalogo = new EntityCatalogoOrdini();
		int risp = catalogo.SegnalaOrdineProntoPerConsegna(idOrdine);
		
		if(risp==-1) return "Nessun corriere attualmente disponibile a cui assegnare la consegna";
		else return "Ordine segnalato e consegna assegnata";
	}
}