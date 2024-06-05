package entity;

public class EntityConsegna {
	private int IDConsegna;
	private String StatoConsegna;
	
	public EntityConsegna(int iDConsegna, String statoConsegna) {
		super();
		IDConsegna = iDConsegna;
		StatoConsegna = statoConsegna;
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
}
