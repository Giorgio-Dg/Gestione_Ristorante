package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO{
	
	private int IDCliente;
	private String Nome;
	private String Cognome;
	private String Indirizzo;
	private ArrayList<OrdineDAO> Ordini;
	
	public ClienteDAO() {
		super();
		Ordini = new ArrayList<OrdineDAO>();
	}
	
	//costruttore che prende in ingresso la PK
		public ClienteDAO(int idcliente) {
			
			this.IDCliente = idcliente;
			this.Ordini = new ArrayList<OrdineDAO>();
			caricaDaDB();
			//caricaOrdiniClienteDaDB(); lo deve fare l'entity ma perche???????
	}

	public void caricaDaDB() {
		
		String query = new String("select * from clienti where idcliente ='"+this.IDCliente+"';");
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				this.setNome(rs.getString("Nome"));
				this.setCognome(rs.getString("Cognome"));
				this.setIndirizzo(rs.getString("Indirizzo"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void caricaOrdiniClienteDaDB() {
		
		String query = new String("select * from ordini where Cliente_idCliente='"+this.IDCliente+"')" );
		//System.out.println(query); //stampo query per controllo in fase di DEBUG, poi posso commentare
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {		
				OrdineDAO ordine = new OrdineDAO();
				ordine.setIDOrdine(rs.getInt("idOrdine"));
				ordine.setStatoOrdine(rs.getString("StatoOrdine"));
				
				////////////////////////////////////////////////////////////////////////////////////////////////
				ordine.setData(rs.getDate("Data").toLocalDate());
				ordine.setOra(rs.getTime("Ora").toLocalTime());
                ////////////////////////////////////////////////////////////////////////////////////////////////
                
				this.Ordini.add(ordine);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getIDCliente() {
		return IDCliente;
	}

	public void setIDCliente(int iDCliente) {
		IDCliente = iDCliente;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String cognome) {
		Cognome = cognome;
	}

	public String getIndirizzo() {
		return Indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		Indirizzo = indirizzo;
	}

	public ArrayList<OrdineDAO> getOrdini() {
		return Ordini;
	}

	public void setOrdini(ArrayList<OrdineDAO> ordini) {
		Ordini = ordini;
	}
	
}

