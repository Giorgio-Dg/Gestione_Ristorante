package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ElementoOrdineDAO {
	
	private OrdineDAO Ordine;
	private PiattoDAO Piatto;
	private int Quantita;
	
	public ElementoOrdineDAO() {
		super();
	}
	
	//costruttore che prende in ingresso la PK
	public ElementoOrdineDAO(String nome) {
		//caricaDaDB();
	}

	/*public void caricaDaDB() {
		
		String query = new String("select * from piatto where Nome ='"+"';");
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public ElementoOrdineDAO(PiattoDAO piatto, int quantita) {
		Piatto = piatto;
		Quantita = quantita;
	}

	public PiattoDAO getPiatto() {
		return Piatto;
	}

	public int getQuantita() {
		return Quantita;
	}


	public OrdineDAO getOrdine() {
		return Ordine;
	}

}
