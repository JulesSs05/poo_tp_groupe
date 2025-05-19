package gestionMeuble;

import java.util.LinkedList;

public class EtapeFabrication {
	private String nom;
	private LinkedList<Personne> personnes;
	
	public EtapeFabrication(String nom, LinkedList<Personne> personnes) {
		super();
		this.nom = nom;
		this.personnes = personnes;
	}
	
	public EtapeFabrication () {
		
	}

	public String getNom() {
		return this.nom;
	}

	public LinkedList<Personne> getPersonnes() {
		return this.personnes;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPersonnes(LinkedList<Personne> personnes) {
		this.personnes = personnes;
	}
	
	public void afficheInfo() {
	    System.out.print("Étape : " + this.getNom() + " | Personnes : ");
	    for (Personne p : this.getPersonnes()) {
	        System.out.print(p.getNom() + " "); 
	    }
	    System.out.println(); 
	}


}
