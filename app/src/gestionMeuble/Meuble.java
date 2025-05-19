package gestionMeuble;

import java.util.LinkedList;

public class Meuble {
	private String nom;
	private Double hauteur;
	private Double largeur;
	private Double profondeur;
	private LinkedList <EtapeFabrication> etapes;
	
	
	public Meuble(String nom, Double hauteur, Double largeur, Double profondeur, LinkedList<EtapeFabrication> etapes) {
		super();
		this.nom = nom;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.profondeur = profondeur;
		this.etapes = etapes;
	}


	public Meuble () {
	
	}
	
	public String getNom() {
		return this.nom;
	}


	public Double getHauteur() {
		return this.hauteur;
	}


	public Double getLargeur() {
		return this.largeur;
	}


	public Double getProfondeur() {
		return this.profondeur;
	}


	public LinkedList<EtapeFabrication> getEtapes() {
		return this.etapes;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setHauteur(Double hauteur) {
		this.hauteur = hauteur;
	}


	public void setLargeur(Double largeur) {
		this.largeur = largeur;
	}


	public void setProfondeur(Double profondeur) {
		this.profondeur = profondeur;
	}


	public void setEtapes(LinkedList<EtapeFabrication> etapes) {
		this.etapes = etapes;
	}
	
	
	

}
