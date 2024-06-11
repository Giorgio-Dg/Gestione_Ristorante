package entity;

import java.util.ArrayList;

import database.ConsegnaDAO;
import database.CorriereDAO;
import database.OrdineDAO;

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
	
	public EntityConsegna creaConsegna(int idordine, String stato) {
		EntityConsegna consegna = new EntityConsegna();
		
		//per far coincidere gli id e gli indici degli elenchi
		consegna.setIDConsegna(idordine);
		consegna.setStatoConsegna(stato);
		
		EntityOrdine ordine = new EntityOrdine(idordine);
		consegna.setOrdine(ordine);
		
		Consegne.add(consegna);
	
		ConsegnaDAO consegnadao = new ConsegnaDAO();
		consegnadao.setIDConsegna(consegna.getIDConsegna());
		consegnadao.setStatoConsegna(consegna.getStatoConsegna());
		
		OrdineDAO ordinedao = new OrdineDAO(idordine);
		consegnadao.setOrdine(ordinedao);
		
		consegnadao.salvaInDB();
		
		return consegna;
	}
	
	public int AssegnaConsegna(EntityConsegna consegna) {
		EntityElencoCorrieri corrieri = new EntityElencoCorrieri();
		EntityCorriere corriere = corrieri.TrovaPrimoCorriereDisponibile();
		if(corriere != null) {
			consegna.setCorriere(corriere);
			
			CorriereDAO corrieredao= new CorriereDAO(corriere.getIDCorriere());
			ConsegnaDAO consegnadao = new ConsegnaDAO(consegna.getIDConsegna());
			
			consegnadao.setCorriere(corrieredao);
			consegnadao.aggiornaCorriereInDB();
			
			return 0;
		}
		return -1;
	}

}