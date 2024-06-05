package entity;

public class EntityOrdine {
	
	private int IDOrdine;
	private String StatoOrdine;
	
	public EntityOrdine(int idord, String statoOrdine) {
		super();
		IDOrdine = idord;
		StatoOrdine = statoOrdine;
	}

	
	public int getIDOrdine() {
		return IDOrdine;
	}

	public void setIDOrdine(int IDOrdine) {
		IDOrdine = IDOrdine;
	}

	public String getStatoOrdine() {
		return StatoOrdine;
	}

	public void setStatoOrdine(String statoOrdine) {
		StatoOrdine = statoOrdine;
	}
	
	
	
	

}
