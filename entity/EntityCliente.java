package entity;

import java.util.ArrayList;
import java.util.Date;

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
	
	
	public int EffettuaOrdine(ArrayList<EntityElementoOrdine> piatti) {
		EntityOrdine nuovoOrdine = new EntityOrdine();
		
		EntityCatalogoOrdini catalogoOrdini = new EntityCatalogoOrdini();
		int indice = catalogoOrdini.getOrdini().size() -1;
		
		nuovoOrdine.setIDOrdine(indice);
		nuovoOrdine.setPiatti(piatti);
		nuovoOrdine.setCliente(this);
		nuovoOrdine.setStatoOrdine("");
		Date now =new Date();
		nuovoOrdine.setData(now);
		
		catalogoOrdini.getOrdini().add(nuovoOrdine);
		
		OrdineDAO neword = new OrdineDAO();
		neword.setIDOrdine(nuovoOrdine.getIDOrdine());
		neword.setStatoOrdine(nuovoOrdine.getStatoOrdine());
		neword.setData(nuovoOrdine.getData());
		
		int i = neword.salvaInDB();
		
		//salvare anche i dati della classe associativa ElementoOrdine
		
		//salvare anche elemento ordine in db 
		
		return i;
	}
	
	public void salvaClientePiattiInOrdineDAO(OrdineDAO nuovoOrdine, EntityCliente cliente, ArrayList<EntityElementoOrdine> piatti) {
		salvaCliente(cliente, nuovoOrdine.getCliente());
		salvaPiatti();
		
	}
	
	public void salvaCliente(EntityCliente cliente, ClienteDAO clienteDAO) {
		clienteDAO.setIDCliente(cliente.getIDCliente());
		clienteDAO.setNome(cliente.getNome());
		clienteDAO.setCognome(cliente.getCognome());
		clienteDAO.setIndirizzo(cliente.getIndirizzo());
	}
	
	public void salvaPiatti(ArrayList<EntityElementoOrdine> piatti, ArrayList<ElementoOrdineDAO> piattiDAO) {
		for(int i=0;i<piatti.size();i++) {
			
			OrdineDAO newordine = new OrdineDAO();
			newordine.setIDOrdine(piatti.get(i).getOrdine().getIDOrdine());
			PiattoDAO newpiatto = new PiattoDAO();
			newpiatto
			
			
			ElementoOrdineDAO elemento = new ElementoOrdineDAO(newordine, );
		}
	}
	
	

	@Override
	public String toString() {
		return "EntityCliente [IDCliente=" + IDCliente + ", Nome=" + Nome + ", Cognome=" + Cognome + ", Indirizzo="
				+ Indirizzo + "]";
	}
}











