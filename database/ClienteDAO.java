package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO{
	
	private int IDCliente;
	private String Nome;
	private String Cognome;
	private String Indirizzo;
	
	public ClienteDAO() {
		super();
	}
	
	//costruttore che prende in ingresso la PK
	public ClienteDAO(int idcliente) {
			
		this.IDCliente = idcliente;
		caricaDaDB();
	}

	public void caricaDaDB() {
		
		String query = new String("select * from cliente where idCliente ='"+this.IDCliente+"';");
		
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
	
	public static ArrayList<ClienteDAO> caricaTuttiClientiDaDB() {
		
		ArrayList<ClienteDAO> elenco_clienti = new ArrayList<ClienteDAO>();
		String query = new String("select * from cliente;");
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				ClienteDAO cliente = new ClienteDAO();
				cliente.setIDCliente(rs.getInt("idCliente"));
				cliente.setNome(rs.getString("Nome"));
				cliente.setCognome(rs.getString("Cognome"));
				cliente.setIndirizzo(rs.getString("Indirizzo"));
				
				elenco_clienti.add(cliente);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elenco_clienti;
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

	@Override
	public String toString() {
		return "ClienteDAO [IDCliente=" + IDCliente + ", Nome=" + Nome + ", Cognome=" + Cognome + ", Indirizzo="
				+ Indirizzo + "]";
	}
	
}

