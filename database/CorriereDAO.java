package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CorriereDAO {
	private int IDCorriere;
	private String Nome;
	private int Disponibilita;
	private ArrayList<ConsegnaDAO> Consegne;
	
	
	public CorriereDAO() {
		super();
		// TODO Auto-generated constructor stub
		Consegne = new ArrayList<ConsegnaDAO>(3);
	}

	//costruttore che prende in ingresso la PK
	public CorriereDAO(int idcorriere) {
		this.IDCorriere = idcorriere;
		this.Consegne = new ArrayList<ConsegnaDAO>(3);
		caricaDaDB();
	}

	public void caricaDaDB() {
		
		String query = new String("select * from corriere where idCorriere ='"+this.IDCorriere+"';");
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				
				this.setNome(rs.getString("Nome"));
				this.setDisponibilita(rs.getInt("Disponibilita"));
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<CorriereDAO> caricaTuttiCorrieriDaDB() {
		
		ArrayList<CorriereDAO> elenco_corrieri = new ArrayList<CorriereDAO>();
		String query = new String("select * from corriere;");
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {
				
				CorriereDAO corriere = new CorriereDAO();
				corriere.setIDCorriere(rs.getInt("idCorriere"));
				corriere.setNome(rs.getString("Nome"));
				corriere.setDisponibilita(rs.getInt("Disponibilita"));
				
				elenco_corrieri.add(corriere);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elenco_corrieri;
	}
	
	public void caricaConsegneCorriereDaDB() {
			String query = new String("select * from consegna join corriere on idCorriere = Corriere_idCorriere");
	try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {		
				ConsegnaDAO consegna = new ConsegnaDAO();
				consegna.setIDConsegna(rs.getInt("idConsegna"));
				consegna.setStatoConsegna(rs.getString("StatoConsegna"));
				//consegna.setOrdineDAO(); PRENDERE ANCHE L'ORDINE E SETTARE ANCHE IDCORRIERE?? FARLO ANCHE NEGLI ALTRI GIA FATTI 
				this.Consegne.add(consegna);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void aggiornaDisponibilitaInDB() {
	String query = "UPDATE corriere SET Disponibilita ='"+this.getDisponibilita()+"' WHERE idCorriere ='"+this.getIDCorriere()+"';"; 
	System.out.println(query);
	try {
		
		DBConnectionManager.updateQuery(query);
		
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	}

	public int getIDCorriere() {
		return IDCorriere;
	}

	public void setIDCorriere(int iDCorriere) {
		IDCorriere = iDCorriere;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getDisponibilita() {
		return Disponibilita;
	}

	public void setDisponibilita(int disponibilita) {
		Disponibilita = disponibilita;
	}

	public ArrayList<ConsegnaDAO> getConsegne() {
		return Consegne;
	}

	public void setConsegne(ArrayList<ConsegnaDAO> consegne) {
		Consegne = consegne;
	}
	
}
