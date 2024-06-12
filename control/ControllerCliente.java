package control;

import java.util.ArrayList;
import java.sql.Date;
import entity.EntityCatalogoOrdini;
import entity.EntityCliente;
import entity.EntityElementoOrdine;
import entity.EntityMenu;
import entity.EntityOrdine;
import entity.EntityPiatto;

public class ControllerCliente {
	
	public static String EffettuaOrdine(int idcliente, ArrayList<String> Nomi_piatti, ArrayList<Integer> Qta){
		
		EntityOrdine nuovoOrdine = new EntityOrdine();
		EntityCatalogoOrdini catalogoOrdini = new EntityCatalogoOrdini();
		int indice = catalogoOrdini.getOrdini().size();
		nuovoOrdine.setIDOrdine(indice);
		
		EntityCliente cliente= new EntityCliente(idcliente);
		nuovoOrdine.setCliente(cliente);
		
		nuovoOrdine.setStatoOrdine("");
		Date now =new Date(System.currentTimeMillis());
		nuovoOrdine.setData(now);
		
		ArrayList<EntityElementoOrdine> piatti = new ArrayList<EntityElementoOrdine>();
		
		for(int i=0;i<Nomi_piatti.size();i++) {
			EntityPiatto p = new EntityPiatto(Nomi_piatti.get(i));
			EntityElementoOrdine piatto = new EntityElementoOrdine(nuovoOrdine, p, Qta.get(i));
			piatti.add(piatto);
			
		}
		
		nuovoOrdine.setPiatti(piatti);
		
		boolean ret = cliente.EffettuaOrdine(nuovoOrdine, piatti);
		
		if(ret) {
			catalogoOrdini.getOrdini().add(nuovoOrdine);
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
}
