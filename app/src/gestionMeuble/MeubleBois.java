package gestionMeuble;

import java.util.LinkedList;

public class MeubleBois extends Meuble {
	
	private String provenance;
	private int anneeCoupe;
	
	
	public MeubleBois() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MeubleBois(String nom, Double hauteur, Double largeur, Double profondeur, String etapeEnCours) {
		super(nom, hauteur, largeur, profondeur, etapeEnCours);
		// TODO Auto-generated constructor stub
	}
	
	public String getProvenance() {
		return this.provenance;
	}
	public int getAnneeCoupe() {
		return this.anneeCoupe;
	}
	public void setProvenance(String provenance) {
		this.provenance = provenance;
	}
	public void setAnneeCoupe(int anneeCoupe) {
		this.anneeCoupe = anneeCoupe;
	}
	
	

}
