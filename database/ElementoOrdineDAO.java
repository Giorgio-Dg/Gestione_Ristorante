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
	
	public ElementoOrdineDAO(OrdineDAO ordine, PiattoDAO piatto, int quantita) {
		Ordine = ordine;
		Piatto = piatto;
		Quantita = quantita;
	}

	public boolean salvaInDB(){
		boolean ret;
		
		String query = "INSERT INTO elementoordine(Ordine_idOrdine,Piatto_Nome,Quantita) VALUES ('"+this.Ordine.getIDOrdine()+"',"+"'"+this.Piatto.getNome()+"','"+this.Quantita+"')"; 
		System.out.println(query);
		try {
			
			DBConnectionManager.updateQuery(query);
			ret = true;
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			ret = false;
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

	@Override
	public String toString() {
		return "ElementoOrdineDAO [Ordine=" + Ordine + ", Piatto=" + Piatto + ", Quantita=" + Quantita + "]";
	}

}
