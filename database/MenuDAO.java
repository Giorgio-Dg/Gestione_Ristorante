package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MenuDAO {
	private ArrayList<PiattoDAO> Piatti;

	public MenuDAO() {
		super();
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
	
	public MenuDAO(ArrayList<PiattoDAO> piatti) {
		Piatti = piatti;
	}

	public ArrayList<PiattoDAO> getPiatti() {
		return Piatti;
	}

	public void setPiatti(ArrayList<PiattoDAO> piatti) {
		Piatti = piatti;
	}
	
}
