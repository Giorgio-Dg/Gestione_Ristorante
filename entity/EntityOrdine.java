package entity;

import java.time.*;

public class EntityOrdine {
	
	private int IDOrdine;
	private String StatoOrdine;
	private LocalDate Data;
	private LocalTime Ora;
	private EntityCliente Cliente;
	
	public EntityOrdine(int iDOrdine, String statoOrdine, LocalDate data, LocalTime ora, EntityCliente cliente) {
		IDOrdine = iDOrdine;
		StatoOrdine = statoOrdine;
		Data = data;
		Ora = ora;
		Cliente = cliente;
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

	public EntityCliente getCliente() {
		return Cliente;
	}

	public void setCliente(EntityCliente cliente) {
		Cliente = cliente;
	}

}
