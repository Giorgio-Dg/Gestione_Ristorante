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

	public int getQuantita() {
		return Quantita;
	}

	public EntityOrdine getOrdine() {
		return Ordine;
	}
	
}

