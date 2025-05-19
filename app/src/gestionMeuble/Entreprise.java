package gestionMeuble;

import java.util.LinkedList;

public class Entreprise {
	
	private String nom;
	private LinkedList <Meuble> meubles;
	
	
	public Entreprise () {
		
	}
	
	public Entreprise(String nom, LinkedList<Meuble> meubles) {
		super();
		this.nom = nom;
		this.meubles = meubles;
	}


	public String getNom() {
		return this.nom;
	}


	public LinkedList<Meuble> getMeubles() {
		return this.meubles;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setMeubles(LinkedList<Meuble> meubles) {
		this.meubles = meubles;
	}
	

}
