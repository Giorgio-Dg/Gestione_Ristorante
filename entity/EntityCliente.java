package entity;

import java.sql.Date;
import java.util.ArrayList;



import database.ClienteDAO;
import database.OrdineDAO;
import database.PiattoDAO;
import database.ElementoOrdineDAO;

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
	
	
	public boolean EffettuaOrdine(ArrayList<String> Nomi_piatti, ArrayList<Integer> Qta) {
		boolean op = false,op1;
		
		EntityOrdine nuovoOrdine = new EntityOrdine();
		EntityCatalogoOrdini catalogoOrdini = new EntityCatalogoOrdini();
		int indice = catalogoOrdini.getOrdini().size();
		nuovoOrdine.setIDOrdine(indice);
		
		nuovoOrdine.setStatoOrdine("In coda");
		Date now =new Date(System.currentTimeMillis());
		nuovoOrdine.setData(now);
		
		ArrayList<EntityElementoOrdine> piatti = new ArrayList<EntityElementoOrdine>();
		
		for(int i=0;i<Nomi_piatti.size();i++) {
			EntityPiatto p = new EntityPiatto(Nomi_piatti.get(i));
			EntityElementoOrdine piatto = new EntityElementoOrdine(nuovoOrdine, p, Qta.get(i));
			piatti.add(piatto);
			
		}
		
		nuovoOrdine.setPiatti(piatti);
		
		OrdineDAO neword = new OrdineDAO();
		neword.setIDOrdine(nuovoOrdine.getIDOrdine());
		neword.setStatoOrdine(nuovoOrdine.getStatoOrdine());
		neword.setData(nuovoOrdine.getData());
		
		ClienteDAO cl = new ClienteDAO();
		neword.setCliente(cl);
		
		ArrayList<ElementoOrdineDAO> el = new ArrayList<ElementoOrdineDAO>();
		neword.setPiatti(el);
		
		salvaClientePiattiInOrdineDAO(neword, this, piatti); 
		
		op1 = neword.salvaInDB();
		
		for(int i=0;i<el.size();i++) {
			op = el.get(i).salvaInDB();
		}
		
		catalogoOrdini.getOrdini().add(nuovoOrdine);
		
		return op && op1;
	}
	
	public void salvaClientePiattiInOrdineDAO(OrdineDAO nuovoOrdine, EntityCliente cliente, ArrayList<EntityElementoOrdine> piatti) {
		salvaCliente(cliente, nuovoOrdine.getCliente());
		salvaPiatti(nuovoOrdine, piatti,nuovoOrdine.getPiatti());
		
	}
	
	public void salvaCliente(EntityCliente cliente, ClienteDAO clienteDAO) {
		clienteDAO.setIDCliente(cliente.getIDCliente());
		clienteDAO.setNome(cliente.getNome());
		clienteDAO.setCognome(cliente.getCognome());
		clienteDAO.setIndirizzo(cliente.getIndirizzo());
	}
	
	public void salvaPiatti(OrdineDAO nuovoOrdine, ArrayList<EntityElementoOrdine> piatti, ArrayList<ElementoOrdineDAO> piattiDAO) {
		for(int i=0;i<piatti.size();i++) {
			
			PiattoDAO piatto = new PiattoDAO();
			piatto.setNome(piatti.get(i).getPiatto().getNome());
			piatto.setDescrizione(piatti.get(i).getPiatto().getDescrizione());
			
			ElementoOrdineDAO elemento = new ElementoOrdineDAO(nuovoOrdine, piatto, piatti.get(i).getQuantita());
			
			piattiDAO.add(elemento);
		}
	}

	@Override
	public String toString() {
		return "[IDCliente=" + IDCliente + ", Nome=" + Nome + ", Cognome=" + Cognome + ", Indirizzo="
				+ Indirizzo + "]";
	}
}











