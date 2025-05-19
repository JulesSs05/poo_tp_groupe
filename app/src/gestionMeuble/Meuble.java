package gestionMeuble;

import java.util.LinkedList;

public class Meuble {
	private String nom;
	private Double hauteur;
	private Double largeur;
	private Double profondeur;
	private LinkedList <EtapeFabrication> etapes;
	private String etapeEnCours;
	
	
	public Meuble(String nom, Double hauteur, Double largeur, Double profondeur, String etapeEnCours) {
		super();
		this.nom = nom;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.profondeur = profondeur;
		this.etapeEnCours = etapeEnCours;
		this.etapes = new LinkedList<EtapeFabrication>();
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
	
	public void setEtapeEnCours(String etape) {
		this.etapeEnCours = etape;
	}
	
	public String getEtapeEnCours() {
		return this.etapeEnCours;
	}
	
	public void afficheInfo() {
		System.out.println("Meuble: " + this.getNom() + ", H: " + this.getHauteur() + "cm, L: " + this.getLargeur() + "cm, P: " + this.getProfondeur() + "cm, etape:" + this.getEtapeEnCours());
	}	
	
	

}
