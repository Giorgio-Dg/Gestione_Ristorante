package database;


public class ElementoOrdineDAO {
	
	private PiattoDAO Piatto;
	private int Quantita;
	
	public ElementoOrdineDAO(PiattoDAO piatto, int quantita) {
		Piatto = piatto;
		Quantita = quantita;
	}

	public PiattoDAO getPiatto() {
		return Piatto;
	}

	public void setPiatto(PiattoDAO piatto) {
		Piatto = piatto;
	}

	public int getQuantita() {
		return Quantita;
	}

	public void setQuantita(int quantita) {
		Quantita = quantita;
	}
	
}
