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
		
		CorriereDAO corriere = new CorriereDAO(idCorriere); //carico lo studente dal DB col costruttore
		
		this.Nome = corriere.getNome();
		this.Disponibilita = corriere.getDisponibilita();
		
		this.Consegne = new ArrayList<EntityConsegna>();
		
		//System.out.println("EntityStudente: "+studente.toString());
		
		
		corriere.caricaConsegneCorriereDaDB();
		
		caricaConsegne(corriere);
		
		//System.out.println("EntityStudente: "+this);
	}
	
	public EntityCorriere(CorriereDAO corriere) {
		
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
	
}
