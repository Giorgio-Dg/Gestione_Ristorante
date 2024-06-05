package entity;

public class EntityConsegna {
	private int IDConsegna;
	private String StatoConsegna;
	private EntityCorriere Corriere;
	
	public EntityConsegna(int iDConsegna, String statoConsegna,  EntityCorriere corriere) {
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

	public EntityCorriere getCorriere() {
		return Corriere;
	}

	public void setCorriere(EntityCorriere corriere) {
		Corriere = corriere;
	}
	
}
