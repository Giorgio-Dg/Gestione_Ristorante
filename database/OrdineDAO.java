package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.util.ArrayList;

public class OrdineDAO {
	
	private int IDOrdine;
	private String StatoOrdine;
	private LocalDate Data;
	private LocalTime Ora;
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
				ordine.setData(rs.getDate("Data").toLocalDate());
				ordine.setOra(rs.getTime("Ora").toLocalTime());
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
				//caricare lista ordini del cliente????
				this.Cliente = cliente;
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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

	public LocalDate getData() {
		return Data;
	}

	public void setData(LocalDate data) {
		Data = data;
	}

	public LocalTime getOra() {
		return Ora;
	}

	public void setOra(LocalTime ora) {
		Ora = ora;
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

