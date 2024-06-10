package entity;

import java.util.ArrayList;

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
		
		if(trovaConsegna(idConsegna) == -1) {return -1;}
		
		else {
		
			int myidConsegna = trovaConsegna(idConsegna);
			if(Consegne.get(myidConsegna).getStatoConsegna() == "Pronto_per_Consegna") {
				Consegne.get(myidConsegna).setStatoConsegna("In_Consegna");
				EntityCatalogoOrdini.AggiornaStatoOrdine(myidConsegna, "In_Consegna");    //DA FARE  come parametro sicuro la stringa
			}
			else {
				Consegne.get(myidConsegna).setStatoConsegna("Consegnato");
				EntityCatalogoOrdini.AggiornaStatoOrdine(myidConsegna, "Consegnato");    //DA FARE  e poi devo dare l'idOrdine !!!
	
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
	
}
