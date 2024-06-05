package entity;

import java.util.ArrayList;

public class EntityCorriere {
	private int IDCorriere;
	private String Nome;
	private int Disponibilita;
	private ArrayList<EntityConsegna> Consegne;
	
	
	public EntityCorriere(int iDCorriere, String nome, int disponibilita) {
		IDCorriere = iDCorriere;
		Nome = nome;
		Disponibilita = disponibilita;
		Consegne = new ArrayList<EntityConsegna>(3);///????3 o no?
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

	public ArrayList<EntityConsegna> getConsegne() {
		return Consegne;
	}

	public void setConsegne(ArrayList<EntityConsegna> consegne) {
		Consegne = consegne;
	}
	
}
