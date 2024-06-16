package control;

import java.util.ArrayList;
import entity.EntityCliente;
import entity.EntityElencoClienti;
import entity.EntityMenu;
import entity.EntityPiatto;

public class ControllerCliente {
	
	public static String EffettuaOrdine(int idcliente, ArrayList<String> Nomi_piatti, ArrayList<Integer> Qta){
		
		EntityCliente cliente= new EntityCliente(idcliente);
		
		boolean ret = cliente.EffettuaOrdine(Nomi_piatti, Qta);
		
		if(ret) {
			return "Ordine effettuato correttamente";
		}
		else {
			return "Errore durante l'ordinazione, ordine non effettuato";
		}
	}
	
	public static ArrayList<String> VisualizzaMenu() {
		ArrayList<EntityPiatto> piatti = EntityMenu.VisualizzaPiatti();
		
		ArrayList<String> menu = new ArrayList<String>();
		
		for(int i=0; i<piatti.size();i++) {
			menu.add(piatti.get(i).getNome());
		}
		
		return menu;
	}
	
	public static ArrayList<Integer> ElencoClienti() {
		EntityElencoClienti clienti = new EntityElencoClienti();
		
		ArrayList<Integer> idclienti = new ArrayList<Integer>();
		
		for(int i=0; i<clienti.getClienti().size();i++) {
			idclienti.add(clienti.getClienti().get(i).getIDCliente());
		}
		
		return idclienti;
	}
}
