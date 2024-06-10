package entity;

import java.util.ArrayList;

import database.OrdineDAO;

public class EntityCatalogoOrdini {
	private ArrayList<EntityOrdine> Ordini;



	public EntityCatalogoOrdini() {
		super();
		this.Ordini = new ArrayList<EntityOrdine>();
		catalogoOrdini();
}
	
	public void catalogoOrdini(){
		
		ArrayList<OrdineDAO> ordini = new ArrayList<OrdineDAO>();
		
		ordini = OrdineDAO.caricaTuttiOrdiniDaDB();
		
		
		
		for(int i=0;i<ordini.size();i++) {
			
			EntityOrdine ordine = new EntityOrdine(ordini.get(i));
			this.Ordini.add(ordine);
		}

	}

}