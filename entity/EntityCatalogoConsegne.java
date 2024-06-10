package entity;

import java.util.ArrayList;

import database.ConsegnaDAO;

public class EntityCatalogoConsegne {
	private ArrayList<EntityConsegna> Consegne;



	public EntityCatalogoConsegne() {
		super();
		this.Consegne = new ArrayList<EntityConsegna>();
		catalogoConsegne();
}
	
	public void catalogoConsegne(){
		
		ArrayList<ConsegnaDAO> consegne = new ArrayList<ConsegnaDAO>();
		
		consegne = ConsegnaDAO.caricaTutteConsegneDaDB();
		
		for(int i=0;i<consegne.size();i++) {
			
			EntityConsegna consegna = new EntityConsegna(consegne.get(i));
			this.Consegne.add(consegna);
		}

	}
	
	public int AssegnaConsegna(/*parametri da dare a consegna?*/) {
		
		EntityConsegna consegna = new EntityConsegna();
		consegna.setStatoConsegna("Pronto_per_Consegna");
		
		Consegne.add(consegna);
		
		EntityElencoCorrieri corrieri = new EntityElencoCorrieri();
		EntityCorriere corriere = corrieri.TrovaPrimoCorriereDisponibile();
		
		if(corriere == null) {
			consegna.setCorriere(corriere);
			//aggiungere consegna al DB  E DAOOOOOOOOO
			return 0;
		}
		return -1;
	}

}