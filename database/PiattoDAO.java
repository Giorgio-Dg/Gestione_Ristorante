package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PiattoDAO {
	private String Nome;
	private String Descrizione;
	
	public PiattoDAO() {
		super();
	}
	
	//costruttore che prende in ingresso la PK
	public PiattoDAO(String nome) {
		this.Nome = nome;
		caricaDaDB();
	}

	public void caricaDaDB() {
		
		String query = new String("select * from piatto where Nome ='"+this.Nome+"';");
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) this.setDescrizione(rs.getString("Descrizione"));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<PiattoDAO> caricaTuttiPiattiDaDB() {
		
		ArrayList<PiattoDAO> elenco_piatti = new ArrayList<PiattoDAO>();
		String query = new String("select * from piatto;");
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				PiattoDAO piatto = new PiattoDAO();
				piatto.setNome(rs.getString("Nome"));
				piatto.setDescrizione(rs.getString("Descrizione"));
				
				elenco_piatti.add(piatto);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elenco_piatti;
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getDescrizione() {
		return Descrizione;
	}
	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}
	
}

