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
		/*accedo all'elemento di indice pari all'idordine poichè gli id agli ordini (ed anche alle consegne) sono
		  sono assegnati con valori sequenziali in base al numero di elementi nell'array list*/
		
		Ordini.get(idOrdine).setStatoOrdine(stato);
		OrdineDAO ordine = new OrdineDAO(idOrdine);
        ordine.aggiornaStatoInDB(stato);
	}
	
	public int SegnalaOrdineProntoPerConsegna(int idOrdine) {
		String stato = "Pronto per consegna";
		Ordini.get(idOrdine).setStatoOrdine(stato);
		OrdineDAO ordine = new OrdineDAO(idOrdine);
        ordine.aggiornaStatoInDB(stato);
		
		EntityCatalogoConsegne catalogoconsegne = new EntityCatalogoConsegne();
		EntityConsegna consegna = catalogoconsegne.creaConsegna(idOrdine, stato);
		int res = catalogoconsegne.AssegnaConsegna(consegna);
		return res;
	}
	
	public boolean PrendiOrdineInCarico() {
	    
		String stato = "In preparazione";
		if (Ordini.size() == 0) return false;
	    boolean ordineAggiornato = false;
	    int i = 0;
	    
	    while(i<Ordini.size() && ordineAggiornato == false) {
	        if (Ordini.get(i).getStatoOrdine().equals("")) {
	            Ordini.get(i).setStatoOrdine(stato);
	            OrdineDAO ordine = new OrdineDAO(Ordini.get(i).getIDOrdine());
	            ordine.aggiornaStatoInDB(stato);
	            ordineAggiornato = true;
	        }
	        i++;
	    }
	    
	    return ordineAggiornato;
	}

	public ArrayList<EntityOrdine> getOrdini() {
		return Ordini;
	}
	
}















