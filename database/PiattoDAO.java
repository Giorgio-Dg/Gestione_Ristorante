package database;

import java.sql.ResultSet;
import java.sql.SQLException;

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

