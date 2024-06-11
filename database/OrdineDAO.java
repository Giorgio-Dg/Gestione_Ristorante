package database;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class OrdineDAO {
	
	private int IDOrdine;
	private String StatoOrdine;
	private Date Data;
	private ClienteDAO Cliente;
	private ArrayList<ElementoOrdineDAO> Piatti;
	
	public OrdineDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	//costruttore che prende in ingresso la PK
	public OrdineDAO(int idordine) {
		this.IDOrdine = idordine;
		this.Piatti = new ArrayList<ElementoOrdineDAO>();
		caricaDaDB();
	}
	
	public void caricaDaDB() {
		
		String query = new String("select * from ordine where idOrdine ='"+this.IDOrdine+"';");
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				OrdineDAO ordine = new OrdineDAO();
				ordine.setStatoOrdine(rs.getString("StatoOrdine"));
				ordine.setData(rs.getDate("Data"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<OrdineDAO> caricaTuttiOrdiniDaDB() {
		
		ArrayList<OrdineDAO> elenco_ordini = new ArrayList<OrdineDAO>();
		String query = new String("select * from ordine;");
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				OrdineDAO ordine = new OrdineDAO();
				ordine.setIDOrdine(rs.getInt("idOrdine"));
				ordine.setStatoOrdine(rs.getString("StatoOrdine"));
				ordine.setData(rs.getDate("Data"));
				
				elenco_ordini.add(ordine);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elenco_ordini;
	}
	
	public void caricaClienteOrdineDaDB() {
		
		String query = new String("select c.idCliente, c.Nome, c.Cognome, c.Indirizzo "
				+ "from cliente c join ordine o on c.idCliente = o.Cliente_idCliente");
		try {
			
			ResultSet rs1 = DBConnectionManager.selectQuery(query);
			
			if(rs1.next()) {
				
				ClienteDAO cliente = new ClienteDAO();
				cliente.setIDCliente(rs1.getInt("c.idCliente"));
				cliente.setNome(rs1.getString("c.Nome"));
				cliente.setCognome(rs1.getString("c.Cognome"));
				cliente.setIndirizzo(rs1.getString("c.Indirizzo"));
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void caricaPiattiOrdineDaDB() {
		
		String query = new String("select * from ordini join elementoordini on idOrdine=Ordine_idOrdine");
		try {
			
			ResultSet rs1 = DBConnectionManager.selectQuery(query);
			
			if(rs1.next()) {
				
				ElementoOrdineDAO el = new ElementoOrdineDAO(rs1.getInt("Ordine_idOrdine"), rs1.getString("Piatto_Nome"));
				
				this.Piatti.add(el);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean salvaInDB(){
		boolean ret;
		
		String query = "INSERT INTO ordine(idOrdine,StatoOrdine,Data,Cliente_idCliente) VALUES ('"+this.IDOrdine+"',"+"'"+this.StatoOrdine+"','"+this.Data+"','"+this.Cliente.getIDCliente()+"')"; 
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
	
	public void aggiornaStatoInDB(String stato) {
		String query = "UPDATE ordine SET StatoOrdine ='"+stato+"' WHERE idOrdine ='"+this.IDOrdine+"';"; 
		System.out.println(query);
		try {
			
			DBConnectionManager.updateQuery(query);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getIDOrdine() {
		return IDOrdine;
	}

	public void setIDOrdine(int iDOrdine) {
		IDOrdine = iDOrdine;
	}

	public String getStatoOrdine() {
		return StatoOrdine;
	}

	public void setStatoOrdine(String statoOrdine) {
		StatoOrdine = statoOrdine;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}


	public ClienteDAO getCliente() {
		return Cliente;
	}

	public void setCliente(ClienteDAO cliente) {
		Cliente = cliente;
	}

	public ArrayList<ElementoOrdineDAO> getPiatti() {
		return Piatti;
	}

	public void setPiatti(ArrayList<ElementoOrdineDAO> piatti) {
		Piatti = piatti;
	}
	
}

