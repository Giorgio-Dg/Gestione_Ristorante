package entity;

import java.util.ArrayList;

import database.ClienteDAO;

public class EntityCliente {
	
	private int IDCliente;
	private String Nome;
	private String Cognome;
	private String Indirizzo;
	
	public EntityCliente() {
		super();
	}
	
	public EntityCliente(int idCliente) {
		ClienteDAO cliente = new ClienteDAO(idCliente);
		
		this.IDCliente = idCliente;
		this.Nome = cliente.getNome();
		this.Cognome = cliente.getCognome();
		this.Indirizzo = cliente.getIndirizzo();
	}
	
			
	public EntityCliente(ClienteDAO cliente) {
		
		this.IDCliente = cliente.getIDCliente();
		this.Nome = cliente.getNome();
		this.Cognome = cliente.getCognome();
		this.Indirizzo = cliente.getIndirizzo();
		 
	}


	public int getIDCliente() {
		return IDCliente;
	}

	public void setIDCliente(int iDCliente) {
		IDCliente = iDCliente;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String cognome) {
		Cognome = cognome;
	}

	public String getIndirizzo() {
		return Indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		Indirizzo = indirizzo;
	}
	
	
	public void EffettuaOrdine(ArrayList<EntityElementoOrdine> piatti) {
		EntityOrdine nuovoOrdine = new EntityOrdine();
		
		
		EntityCatalogoOrdini catalogoOrdini = new EntityCatalogoOrdini();
		int indice = catalogoOrdini.getOrdini().size() -1;
		
		nuovoOrdine.setIDOrdine(indice);
		nuovoOrdine.setPiatti(piatti);
		nuovoOrdine.setCliente(this);
		nuovoOrdine.setStatoOrdine("");
		
		
		catalogoOrdini.getOrdini().add(nuovoOrdine);
	}

	@Override
	public String toString() {
		return "EntityCliente [IDCliente=" + IDCliente + ", Nome=" + Nome + ", Cognome=" + Cognome + ", Indirizzo="
				+ Indirizzo + "]";
	}
}
