package entity;

import java.util.ArrayList;
import database.ClienteDAO;

public class EntityElencoClienti {

	public EntityElencoClienti() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<ClienteDAO> elencoClienti(){
		
		
		ArrayList<ClienteDAO> clienti = new ArrayList<ClienteDAO>();		
						
		//clienti = ClienteDAO.caricaTuttiClientidaDB();
		
				
		return clienti;
	}
	
}
