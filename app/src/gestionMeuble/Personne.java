package gestionMeuble;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Personne {
	
	private String nom;
	private String prenom;
	private int anciennete;
	
	
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personne(String nom, String prenom, int anciennete) {
	    this.nom = nom;
	    this.prenom = prenom;
	    this.anciennete = anciennete;
	}

	
	public String getNom() {
		return this.nom;
	}


	public String getPrenom() {
		return this.prenom;
	}


	public int getAnciennete() {
		return this.anciennete;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public void setAnciennete(int anciennete) {
		this.anciennete = anciennete;
	}
	
	public void save() {
        String sql = "INSERT INTO personne (nom, prenom, anciennete) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.setInt(3, anciennete);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}