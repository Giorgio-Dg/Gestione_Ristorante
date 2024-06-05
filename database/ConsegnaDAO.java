package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsegnaDAO {
	private int IDConsegna;
	private String StatoConsegna;
	private CorriereDAO Corriere;
	private OrdineDAO Ordine;
	
	public ConsegnaDAO() {
		super();
	}
	
	//costruttore che prende in ingresso la PK
	public ConsegnaDAO(int idconsegna) {
			
		this.IDConsegna = idconsegna;
		caricaDaDB();
	}

	public void caricaDaDB() {
		
		String query = new String("select * from consegna where idConsegna ='"+this.IDConsegna+"';");
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) this.setStatoConsegna(rs.getString("StatoConsegna"));
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void caricaCorriereConsegnaDaDB() {
		
		String query = new String("select c.idCorriere, c.Nome, c.Disponibilita "
				+ "from corriere c join consegna c1 on c.idCorriere = c1.Corriere_idCorriere");
		try {
			
			ResultSet rs1 = DBConnectionManager.selectQuery(query);
			
			if(rs1.next()) {
				
				CorriereDAO corriere = new CorriereDAO();
				corriere.setIDCorriere(rs1.getInt("c.idCorriere"));
				corriere.setNome(rs1.getString("c.Nome"));
				corriere.setDisponibilita(rs1.getInt("c.Disponibilita"));
				
				this.Corriere = corriere;
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void caricaOrdineConsegnaDaDB() {
		
		String query = new String("select * from ordini o join consegne c on o.idOrdine = c.Ordine_idOrdine)" );
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {	
				
				OrdineDAO ordine = new OrdineDAO();
				ordine.setIDOrdine(rs.getInt("o.idOrdine"));
				ordine.setStatoOrdine(rs.getString("o.StatoOrdine"));
				ordine.setData(rs.getDate("o.Data").toLocalDate());
				ordine.setOra(rs.getTime("o.Ora").toLocalTime());
				
                this.Ordine=ordine;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public int getIDConsegna() {
		return IDConsegna;
	}

	public void setIDConsegna(int iDConsegna) {
		IDConsegna = iDConsegna;
	}

	public String getStatoConsegna() {
		return StatoConsegna;
	}

	public void setStatoConsegna(String statoConsegna) {
		StatoConsegna = statoConsegna;
	}

	public CorriereDAO getCorriere() {
		return Corriere;
	}

	public void setCorriere(CorriereDAO corriere) {
		Corriere = corriere;
	}
	
}
