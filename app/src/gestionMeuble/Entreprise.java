package gestionMeuble;

import java.util.LinkedList;

public class Entreprise {
	
	private String nom;
	private LinkedList <Meuble> meubles;
	
	
	public Entreprise () {
		
	}
	
	public Entreprise(String nom) {
		this.nom = nom;
		this.meubles = new LinkedList<Meuble>();
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
	
	public void fabriquerMeuble(Meuble m, String etape, LinkedList<Personne> p) {
		if (!this.getMeubles().contains(m)) {
			this.getMeubles().add(m);
		}
		EtapeFabrication etapeFab = new EtapeFabrication(etape, p);
		m.getEtapes().add(etapeFab);
		m.setEtapeEnCours(etape);
	}
	
	public void afficherMeuble() {
		for(int i=0; i<this.getMeubles().size(); i++) {
			this.getMeubles().get(i).afficheInfo();
		}
	}
	
	
	public void afficherMeublesEnCours() {
	    System.out.println("Meubles en cours de fabrication :");
	    for (Meuble m : this.meubles) {
	        LinkedList<EtapeFabrication> etapes = m.getEtapes();
	        if (!etapes.isEmpty() && !etapes.getLast().getNom().isEmpty()) {
	            System.out.println("- " + m.getNom());
	        }
	    }
	}
	
	public void afficherMeublesParEtape(String etapeCible) {
	    System.out.println("Meubles à l'étape \"" + etapeCible + "\" :");
	    for (Meuble m : this.meubles) {
	        LinkedList<EtapeFabrication> etapes = m.getEtapes();
	        if (!etapes.isEmpty() && etapes.getLast().getNom().equals(etapeCible)) {
	            System.out.println("- " + m.getNom());
	        }
	    }
	}
	
	public void afficherMeublesFabriques() {
	    System.out.println("Meubles fabriqués :");
	    for (Meuble m : this.meubles) {
	        LinkedList<EtapeFabrication> etapes = m.getEtapes();
	        if (!etapes.isEmpty() && etapes.getLast() == null) {
	            System.out.println("- " + m.getNom());
	        }
	    }
	}


}
