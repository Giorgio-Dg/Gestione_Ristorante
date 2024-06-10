package entity;

import java.util.ArrayList;
import database.CorriereDAO;

public class EntityElencoCorrieri {
	
	private ArrayList<EntityCorriere> Corrieri;

	public EntityElencoCorrieri() {
		super();
		this.Corrieri = new ArrayList<EntityCorriere>();
		elencoCorrieri();
	}
	
	public void elencoCorrieri(){
		
		ArrayList<CorriereDAO> corrieri = new ArrayList<CorriereDAO>();
		
		corrieri = CorriereDAO.caricaTuttiCorrieriDaDB();
		
		
		
		for(int i=0;i<corrieri.size();i++) {
			
			EntityCorriere corriere = new EntityCorriere(corrieri.get(i));
			this.Corrieri.add(corriere);
		}

	}
	
}
