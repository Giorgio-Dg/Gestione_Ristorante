package database;


public class ConsegnaDAO {
	private int IDConsegna;
	private String StatoConsegna;
	private CorriereDAO Corriere;
	
	public ConsegnaDAO(int iDConsegna, String statoConsegna,  CorriereDAO corriere) {
		IDConsegna = iDConsegna;
		StatoConsegna = statoConsegna;
		Corriere = corriere;
	}

	public int getIDConsegna() {
		return IDConsegna;
	}

	public void setIDConsegna(int iDConsegna) {
		IDConsegna = iDConsegna;
	}

	public String getStatoConsegna() {
		return StatoConsegna;
	}

	public void setStatoConsegna(String statoConsegna) {
		StatoConsegna = statoConsegna;
	}

	public CorriereDAO getCorriere() {
		return Corriere;
	}

	public void setCorriere(CorriereDAO corriere) {
		Corriere = corriere;
	}
	
}
