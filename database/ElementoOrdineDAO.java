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
	public ElementoOrdineDAO(int IDOrdine, String Nome) {
		this.Ordine = new OrdineDAO(IDOrdine);
		this.Piatto = new PiattoDAO(Nome);
		caricaDaDB();
	}

	public void caricaDaDB() {
		
		String query = new String("select * from elementoordine where Ordine_idOrdine ='"+this.Ordine.getIDOrdine()+"' and Piatto_Nome='"+this.Piatto.getNome()+"';");
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				this.Quantita = rs.getInt("Quantita");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ElementoOrdineDAO(PiattoDAO piatto, int quantita) {
		Piatto = piatto;
		Quantita = quantita;
	}

	public int salvaInDB(){
		int ret = 0;
		
		String query = "INSERT INTO ordine(idOrdine,StatoOrdine,Data,Cliente_idCliente) VALUES ('"+this.IDOrdine+"',"+"'"+this.StatoOrdine+"','"+this.Data+"','"+this.Cliente.getIDCliente()+"')"; 
		System.out.println(query);
		try {
			
			ret = DBConnectionManager.updateQuery(query);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			ret = -1;
		}
		
		return ret;
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
