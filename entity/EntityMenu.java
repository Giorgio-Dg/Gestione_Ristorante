package entity;

import java.util.ArrayList;

public class EntityMenu {
	private ArrayList<EntityPiatto> Piatti;

	public EntityMenu(ArrayList<EntityPiatto> piatti) {
		Piatti = piatti;
	}

	public ArrayList<EntityPiatto> getPiatti() {
		return Piatti;
	}

	public void setPiatti(ArrayList<EntityPiatto> piatti) {
		Piatti = piatti;
	}
	
}
