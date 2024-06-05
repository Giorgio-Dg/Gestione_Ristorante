package entity;

public class EntityPiatto {
	private String Nome;
	private String Descrizione;
	
	public EntityPiatto(String nome, String descrizione) {
		Nome = nome;
		Descrizione = descrizione;
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
