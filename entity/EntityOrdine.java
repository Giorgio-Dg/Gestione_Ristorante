package entity;

import database.OrdineDAO;
import java.time.*;
import java.util.ArrayList;

public class EntityOrdine {
	
	private int IDOrdine;
	private String StatoOrdine;
	private LocalDate Data;
	private LocalTime Ora;
	private EntityCliente Cliente;
	private ArrayList<EntityElementoOrdine> Piatti;
	
	public EntityOrdine() {
		super();
		this.Piatti = new ArrayList<EntityElementoOrdine>();
	}
	
	public EntityOrdine(int IDOrdine){
		
		OrdineDAO ordine = new OrdineDAO(IDOrdine);
		
		this.StatoOrdine = ordine.getStatoOrdine();
		this.Data = ordine.getData();
		this.Ora = ordine.getOra();
		
		this.Piatti = new ArrayList<EntityElementoOrdine>(); //creato array vuoto
		
		//System.out.println("EntityStudente: "+studente.toString());
		
					
		
		ordine.caricaClienteOrdineDaDB(); //mi carico i badge tramite lo studenteDAO
		caricaCliente(ordine);
		
		//ordine.(); //QUA SERVE CARICA ORDINE PIATTI?? PER L'ARRAYLIST
		
		//caricaCorsi(studente);
		
		//System.out.println("EntityStudente: "+this);
	}
	
	public EntityOrdine(OrdineDAO ordine) {
		
		this.StatoOrdine = ordine.getStatoOrdine();
		this.Data = ordine.getData();
		this.Ora = ordine.getOra();
		
		this.Piatti = new ArrayList<EntityElementoOrdine>();
		
		//ordine.caricaCorsiStudenteDaDB(); ARRAY DI PIATTI NON LO POSSO FARE NON Cè CARICA
		//caricaCorsi(studente);
		ordine.caricaClienteOrdineDaDB();
		caricaCliente(ordine);
; 
	}

	
	public void caricaCliente(OrdineDAO ordine) {
		
		EntityCliente cliente = new EntityCliente(ordine.getCliente());		
		this.Cliente = cliente;
		
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

	public ArrayList<EntityElementoOrdine> getPiatti() {
		return Piatti;
	}

	public void setPiatti(ArrayList<EntityElementoOrdine> piatti) {
		Piatti = piatti;
	}
	
}
