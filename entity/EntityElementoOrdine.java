package entity;

public class EntityElementoOrdine {
	
	private EntityOrdine Ordine;
	private EntityPiatto Piatto;
	private int Quantita;
	
	public EntityElementoOrdine(EntityPiatto piatto, int quantita) {
		Piatto = piatto;
		Quantita = quantita;
	}

	public EntityPiatto getPiatto() {
		return Piatto;
	}

	public void setPiatto(EntityPiatto piatto) {
		Piatto = piatto;
	}

	public int getQuantita() {
		return Quantita;
	}

	public void setQuantita(int quantita) {
		Quantita = quantita;
	}

	public EntityOrdine getOrdine() {
		return Ordine;
	}

	public void setOrdine(EntityOrdine ordine) {
		Ordine = ordine;
	}
	
}

