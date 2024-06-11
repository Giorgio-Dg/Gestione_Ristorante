package entity;

import java.util.ArrayList;

import database.PiattoDAO;

public class EntityMenu {
	private ArrayList<EntityPiatto> Piatti;

	public EntityMenu(ArrayList<EntityPiatto> piatti) {
		Piatti = piatti;
	}

	public ArrayList<EntityPiatto> getPiatti() {
		return Piatti;
	}

	public void setPiatti(ArrayList<EntityPiatto> piatti) {
		Piatti = piatti;
	}
	
	public static ArrayList<EntityPiatto> VisualizzaPiatti() {
		
		ArrayList<PiattoDAO> piatti = PiattoDAO.caricaTuttiPiattiDaDB();
		ArrayList<EntityPiatto> elenco_piatti = new ArrayList<EntityPiatto>();
		
		for(int i=0; i<piatti.size();i++) {
			EntityPiatto piatto = new EntityPiatto();
			piatto.setNome(piatti.get(i).getNome());
			piatto.setDescrizione(piatti.get(i).getDescrizione());
			elenco_piatti.add(piatto);
		}
		
		return elenco_piatti;
		
	}
	
}
