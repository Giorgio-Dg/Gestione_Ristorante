package control;

import entity.EntityCorriere;

public class ControllerCorriere {
public static String AggiornaStatoConsegna(int idcorriere, int idconsegna) {
		
		EntityCorriere corriere = new EntityCorriere(idcorriere);
		int risp = corriere.AggiornaStatoConsegna(idconsegna);
		
		if(risp==-1) return "Consegna non presente";
		else return "Stato consegna aggiornato";
	}
}