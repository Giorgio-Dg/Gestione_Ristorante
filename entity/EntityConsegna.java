package entity;

import database.ConsegnaDAO;

public class EntityConsegna {
	private int IDConsegna;
	private String StatoConsegna;
	private EntityCorriere Corriere;
	private EntityOrdine Ordine;
	
	public EntityConsegna() {
		super();
	}
	
	public EntityConsegna(int IDConsegna){
		
		this.IDConsegna = IDConsegna;
		
		ConsegnaDAO consegna = new ConsegnaDAO(IDConsegna);
		
		this.StatoConsegna = consegna.getStatoConsegna();
		
		consegna.caricaCorriereConsegnaDaDB();
		caricaCorriere(consegna);
		
		consegna.caricaOrdineConsegnaDaDB();
		caricaOrdine(consegna);
	}
	
	public EntityConsegna(ConsegnaDAO consegna) {
		
		this.IDConsegna = consegna.getIDConsegna();
		this.StatoConsegna = consegna.getStatoConsegna();
		
		consegna.caricaCorriereConsegnaDaDB();
		caricaCorriere(consegna);
		
		consegna.caricaOrdineConsegnaDaDB();
		caricaOrdine(consegna);

	}

	
	public void caricaCorriere(ConsegnaDAO consegna){
		EntityCorriere corriere = new EntityCorriere(consegna.getCorriere());		
		this.Corriere = corriere;
	}
	
	public void caricaOrdine(ConsegnaDAO consegna) {
		EntityOrdine ordine = new EntityOrdine(consegna.getOrdine());
		this.Ordine = ordine;
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

	public EntityOrdine getOrdine() {
		return Ordine;
	}

	public void setOrdine(EntityOrdine ordine) {
		Ordine = ordine;
	}

	@Override
	public String toString() {
		return "EntityConsegna [IDConsegna=" + IDConsegna + ", StatoConsegna=" + StatoConsegna + ", Corriere="
				+ Corriere + "]";
	}
	
}
