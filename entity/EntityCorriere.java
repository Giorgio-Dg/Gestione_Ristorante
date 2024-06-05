package entity;

public class EntityCorriere {
	private int IDCorriere;
	private String Nome;
	private int Disponibilita;
	
	public EntityCorriere(int iDCorriere, String nome, int disponibilita) {
		IDCorriere = iDCorriere;
		Nome = nome;
		Disponibilita = disponibilita;
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
	
}
