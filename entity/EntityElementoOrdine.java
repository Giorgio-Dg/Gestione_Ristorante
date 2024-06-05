package entity;

public class EntityElementoOrdine {
	
	private EntityOrdine Ordine;
	private EntityPiatto Piatto;
	private int Quantita;
	
	public EntityElementoOrdine(EntityOrdine ordine, EntityPiatto piatto, int quantita) {
		Ordine = ordine;
		Piatto = piatto;
		Quantita = quantita;
	}

	public EntityOrdine getOrdine() {
		return Ordine;
	}

	public void setOrdine(EntityOrdine ordine) {
		Ordine = ordine;
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
	
}

