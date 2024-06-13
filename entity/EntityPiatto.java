package entity;

import database.PiattoDAO;

public class EntityPiatto {
	private String Nome;
	private String Descrizione;
	private EntityElementoOrdine link;
	
	public EntityPiatto() {
		super();
	}
	
	public EntityPiatto(String nome){
		
		this.Nome = nome;
		
		PiattoDAO piatto = new PiattoDAO(nome);
		
		this.Descrizione = piatto.getDescrizione();
	}
	
	public EntityPiatto(PiattoDAO piatto) {
		
		this.Nome = piatto.getNome();
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
	
	public void inserisciLinkElemento(EntityElementoOrdine t) {
		
		if (link == null && t !=null && t.getPiatto() == this) {
			link = t;
		}
	}
	

	public EntityElementoOrdine getLink() {
		return link;
	}

	public void setLink(EntityElementoOrdine link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Piatto [Nome=" + Nome + ", Descrizione=" + Descrizione + "]";
	}
	
}
