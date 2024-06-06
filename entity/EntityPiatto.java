package entity;

import database.PiattoDAO;

public class EntityPiatto {
	private String Nome;
	private String Descrizione;
	
	public EntityPiatto() {
		super();
	}
	
	public EntityPiatto(String nome){
		
		PiattoDAO piatto = new PiattoDAO(nome);
		
		this.Descrizione = piatto.getDescrizione();
		
		//System.out.println("EntityStudente: "+studente.toString());
	}
	
	public EntityPiatto(PiattoDAO piatto) {
		
		this.Descrizione = piatto.getDescrizione(); 
	}


	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getDescrizione() {
		return Descrizione;
	}
	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}
	
}
