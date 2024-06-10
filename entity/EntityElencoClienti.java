package entity;

import java.util.ArrayList;
import database.ClienteDAO;

public class EntityElencoClienti {
	
	private ArrayList<EntityCliente> Clienti;

	public EntityElencoClienti() {
		super();
		this.Clienti = new ArrayList<EntityCliente>();
		elencoClienti();
	}
	
	public void elencoClienti(){
		
		ArrayList<ClienteDAO> clienti = new ArrayList<ClienteDAO>();
		
		clienti = ClienteDAO.caricaTuttiClientiDaDB();
		
		
		
		for(int i=0;i<clienti.size();i++) {
			
			EntityCliente cliente = new EntityCliente(clienti.get(i));
			this.Clienti.add(cliente);
		}

	}
	
}
