package entity;

import java.util.ArrayList;

import database.ConsegnaDAO;
import database.CorriereDAO;

public class EntityCorriere {
	private int IDCorriere;
	private String Nome;
	private int Disponibilita;
	private ArrayList<EntityConsegna> Consegne;
	
	
	public EntityCorriere() {
		super();
		this.Consegne = new ArrayList<EntityConsegna>();	
	}
	
	public EntityCorriere(int idCorriere){
		
		this.IDCorriere = idCorriere;
		
		CorriereDAO corriere = new CorriereDAO(idCorriere);
		
		this.Nome = corriere.getNome();
		this.Disponibilita = corriere.getDisponibilita();
		
		this.Consegne = new ArrayList<EntityConsegna>();
		
		
		corriere.caricaConsegneCorriereDaDB();
		
		caricaConsegne(corriere);
		
		
	}
	
	public EntityCorriere(CorriereDAO corriere) {
		
		this.IDCorriere = corriere.getIDCorriere();
		this.Nome = corriere.getNome();
		this.Disponibilita = corriere.getDisponibilita();
		
		this.Consegne = new ArrayList<EntityConsegna>();
		
		
		corriere.caricaConsegneCorriereDaDB();
		
		caricaConsegne(corriere);
		 
	}


	public void caricaConsegne(CorriereDAO corriere) {
		for(int i=0;i<corriere.getConsegne().size();i++) {
			
			EntityConsegna consegna = new EntityConsegna(corriere.getConsegne().get(i));
			this.Consegne.add(consegna);
		}
	}


	public int getIDCorriere() {
		return IDCorriere;
	}

	public void setIDCorriere(int iDCorriere) {
		IDCorriere = iDCorriere;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getDisponibilita() {
		return Disponibilita;
	}

	public void setDisponibilita(int disponibilita) {
		Disponibilita = disponibilita;
	}

	public ArrayList<EntityConsegna> getConsegne() {
		return Consegne;
	}

	public void setConsegne(ArrayList<EntityConsegna> consegne) {
		Consegne = consegne;
	}
	
	public int AggiornaStatoConsegna(int idConsegna) {
		
		String statocorr = "Pronto per consegna";
		String stato1 = "In consegna";
		String stato2 = "Consegnato";
		
		if(trovaConsegna(idConsegna) == -1) {return -1;}
		
		else {
			int myidConsegna = trovaConsegna(idConsegna);
			if(Consegne.get(myidConsegna).getStatoConsegna().equals(statocorr)) {
				Consegne.get(myidConsegna).setStatoConsegna(stato1);
				
				ConsegnaDAO consegna = new ConsegnaDAO(myidConsegna);
				consegna.aggiornaStatoConsegnaInDB(stato1);
				
				EntityCatalogoOrdini.AggiornaStatoOrdine(myidConsegna, stato1);  
			}
			else {
				Consegne.get(myidConsegna).setStatoConsegna(stato2);
				
				ConsegnaDAO consegna = new ConsegnaDAO(myidConsegna);
				consegna.aggiornaStatoConsegnaInDB(stato1);
				
				EntityCatalogoOrdini.AggiornaStatoOrdine(myidConsegna, stato2);
	
			}
			return 0;
		}
	}
	
	public int trovaConsegna(int idConsegna) {
		
		for(int i=0; i<Consegne.size(); i++) {
			if(Consegne.get(i).getIDConsegna() == idConsegna) return i;
		}
		return -1;
	}

	@Override
	public String toString() {
		return "EntityCorriere [IDCorriere=" + IDCorriere + ", Nome=" + Nome + ", Disponibilita=" + Disponibilita
				+ ", Consegne=" + Consegne + "]";
	}
	
}
