package entity;

import database.ElementoOrdineDAO;

public class EntityElementoOrdine {
	
	private EntityOrdine Ordine;
	private EntityPiatto Piatto;
	private final int Quantita;
	
	public EntityElementoOrdine(EntityOrdine ordine, EntityPiatto piatto, int quantita) {
		Ordine = ordine;
		Piatto = piatto;
		Quantita = quantita;
	}
	
	public EntityElementoOrdine(ElementoOrdineDAO el, EntityOrdine ord) {
		
		el.caricaDaDB();
		this.Ordine = ord;
		caricaPiatto(el);
		this.Quantita = el.getQuantita();
	}
	
	public void caricaOrdine(ElementoOrdineDAO el) {
		
		EntityOrdine ordine = new EntityOrdine(el.getOrdine());		
		this.Ordine = ordine;
	}
	
	public void caricaPiatto(ElementoOrdineDAO el) {
		
		EntityPiatto piatto = new EntityPiatto(el.getPiatto());		
		this.Piatto = piatto;
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

	@Override
	public String toString() {
		return Piatto + ", Quantita=" + Quantita;
	}
	
}

