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
	
	public int creaConsegna(int idordine, String stato) {
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
		
		int risp = this.AssegnaConsegna(consegna, consegnadao);
		consegnadao.salvaInDB();
		
		return risp;
	}
	
	public int AssegnaConsegna(EntityConsegna consegna, ConsegnaDAO consegnadao) {
		EntityElencoCorrieri corrieri = new EntityElencoCorrieri();
		EntityCorriere corriere = corrieri.TrovaPrimoCorriereDisponibile();
		if(corriere != null) {
			consegna.setCorriere(corriere);
	
			CorriereDAO corrieredao= new CorriereDAO(corriere.getIDCorriere());
			corrieredao.setDisponibilita((corrieredao.getDisponibilita()-1));
			
			//aggiorno la disponibilità del corriere nel db
			corrieredao.aggiornaDisponibilitaInDB();
			
			consegnadao.setCorriere(corrieredao);
			
			return corriere.getIDCorriere();
		}
		return -1;
	}

}