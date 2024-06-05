package database;

import java.util.ArrayList;

public class CorriereDAO {
	private int IDCorriere;
	private String Nome;
	private int Disponibilita;
	private ArrayList<ConsegnaDAO> Consegne;
	
	
	public CorriereDAO(int iDCorriere, String nome, int disponibilita) {
		IDCorriere = iDCorriere;
		Nome = nome;
		Disponibilita = disponibilita;
		Consegne = new ArrayList<ConsegnaDAO>(3);///????3 o no?
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
