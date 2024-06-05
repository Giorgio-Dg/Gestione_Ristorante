package database;

import java.time.*;
import java.util.ArrayList;

public class OrdineDAO {
	
	private int IDOrdine;
	private String StatoOrdine;
	private LocalDate Data;
	private LocalTime Ora;
	private ClienteDAO Cliente;
	private ArrayList<ElementoOrdineDAO> Piatti;
	
	public OrdineDAO(int iDOrdine, String statoOrdine, LocalDate data, LocalTime ora, ClienteDAO cliente) {
		IDOrdine = iDOrdine;
		StatoOrdine = statoOrdine;
		Data = data;
		Ora = ora;
		Cliente = cliente;
		Piatti = new ArrayList<ElementoOrdineDAO>();
	}

	public int getIDOrdine() {
		return IDOrdine;
	}

	public void setIDOrdine(int iDOrdine) {
		IDOrdine = iDOrdine;
	}

	public String getStatoOrdine() {
		return StatoOrdine;
	}

	public void setStatoOrdine(String statoOrdine) {
		StatoOrdine = statoOrdine;
	}

	public LocalDate getData() {
		return Data;
	}

	public void setData(LocalDate data) {
		Data = data;
	}

	public LocalTime getOra() {
		return Ora;
	}

	public void setOra(LocalTime ora) {
		Ora = ora;
	}

	public ClienteDAO getCliente() {
		return Cliente;
	}

	public void setCliente(ClienteDAO cliente) {
		Cliente = cliente;
	}

	public ArrayList<ElementoOrdineDAO> getPiatti() {
		return Piatti;
	}

	public void setPiatti(ArrayList<ElementoOrdineDAO> piatti) {
		Piatti = piatti;
	}
	
}

