package database;

import java.util.ArrayList;

public class MenuDAO {
	private ArrayList<PiattoDAO> Piatti;

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
