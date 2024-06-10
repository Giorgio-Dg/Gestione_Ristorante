package entity;

import java.util.ArrayList;

import database.OrdineDAO;

public class EntityCatalogoOrdini {
	private static ArrayList<EntityOrdine> Ordini;



	public EntityCatalogoOrdini() {
		super();
		Ordini = new ArrayList<EntityOrdine>();
		catalogoOrdini();
}
	
	public void catalogoOrdini(){
		
		ArrayList<OrdineDAO> ordini = new ArrayList<OrdineDAO>();
		
		ordini = OrdineDAO.caricaTuttiOrdiniDaDB();
		
		
		
		for(int i=0;i<ordini.size();i++) {
			
			EntityOrdine ordine = new EntityOrdine(ordini.get(i));
			Ordini.add(ordine);
		}

	}
	
	public static void AggiornaStatoOrdine(int idOrdine, String stato) {
		Ordini.get(idOrdine).setStatoOrdine(stato);
		// AGGIORNARE DATABASE
	}
	
	public void SegnalaOrdineProntoPerConsegna(int idOrdine) {
		Ordini.get(idOrdine).setStatoOrdine("Pronto_per_Consegna");
		// AGGIORNARE DATABASE
		
		EntityCatalogoConsegne catalogoconsegne = new EntityCatalogoConsegne();
		catalogoconsegne.AssegnaConsegna();
	}
	
	public boolean PrendiOrdineInCarico() {
	    if (Ordini.size() == 0) return false;

	    boolean ordineAggiornato = false;
	    int i = 0;
	    
	    while(i<Ordini.size() && ordineAggiornato == false) {
	        if (Ordini.get(i).getStatoOrdine() == null) {
	            Ordini.get(i).setStatoOrdine("In_Preparazione");
	            ordineAggiornato = true;
	         // AGGIORNARE DATABASE
	        }
	        i++;
	    }
	    
	    return ordineAggiornato;
	}

	public ArrayList<EntityOrdine> getOrdini() {
		return Ordini;
	}
	
	

}















