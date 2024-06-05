package database;

import java.util.ArrayList;

public class ClienteDAO{
	
	private int IDCliente;
	private String Nome;
	private String Cognome;
	private String Indirizzo;
	private ArrayList<OrdineDAO> Ordini;
	
	public ClienteDAO(int iDCliente, String nome, String cognome, String indirizzo) {
		IDCliente = iDCliente;
		Nome = nome;
		Cognome = cognome;
		Indirizzo = indirizzo;
		Ordini = new ArrayList<OrdineDAO>();
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

	public ArrayList<OrdineDAO> getOrdini() {
		return Ordini;
	}

	public void setOrdini(ArrayList<OrdineDAO> ordini) {
		Ordini = ordini;
	}
	
}

