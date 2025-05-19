package gestionMeuble;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SchemaInitializer {

    public static void createTables() {
    	
    	String init = """
    		    PRAGMA foreign_keys = OFF;
    		    DROP TABLE IF EXISTS etape_fabrication_personne;
    		    DROP TABLE IF EXISTS etapeFabrication;
    		    DROP TABLE IF EXISTS bois;
    		    DROP TABLE IF EXISTS meuble;
    		    DROP TABLE IF EXISTS personne;
    		    DROP TABLE IF EXISTS entreprise;
    		    PRAGMA foreign_keys = ON;
    		""";

    	
        String entrepriseTable = """
            CREATE TABLE IF NOT EXISTS entreprise (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nom TEXT NOT NULL
            );
        """;

        String meubleTable = """
            CREATE TABLE IF NOT EXISTS meuble (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nom TEXT NOT NULL,
                hauteur REAL,
                largeur REAL,
                profondeur REAL,
                type TEXT, -- 'Bois', 'Resine', 'Metal'
                entreprise_id INTEGER,
                FOREIGN KEY (entreprise_id) REFERENCES entreprise(id)
            );
        """;

        String boisTable = """
            CREATE TABLE IF NOT EXISTS bois (
                meuble_id INTEGER PRIMARY KEY,
                provenance TEXT,
                annee_coupe INTEGER,
                FOREIGN KEY (meuble_id) REFERENCES meuble(id)
            );
        """;

        String etapeFabricationTable = """
            CREATE TABLE IF NOT EXISTS etapeFabrication (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nom TEXT NOT NULL,
                meuble_id INTEGER,
                FOREIGN KEY (meuble_id) REFERENCES meuble(id)
            );
        """;

        String personneTable = """
            CREATE TABLE IF NOT EXISTS personne (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nom TEXT NOT NULL,
                prenom TEXT NOT NULL,
                anciennete INTEGER
            );
        """;

        String etapePersonne = """
            CREATE TABLE IF NOT EXISTS etape_fabrication_personne (
                etape_fabrication_id INTEGER,
                personne_id INTEGER,
                PRIMARY KEY (etape_fabrication_id, personne_id),
                FOREIGN KEY (etape_fabrication_id) REFERENCES etapeFabrication(id)
                FOREIGN KEY (personne_id) REFERENCES personne(id)
            );
        """;

        try (Connection conn = Database.getConnection()) {
        	conn.createStatement().execute(init);
            conn.createStatement().execute(entrepriseTable);
            conn.createStatement().execute(meubleTable);
            conn.createStatement().execute(boisTable);
            conn.createStatement().execute(etapeFabricationTable);
            conn.createStatement().execute(personneTable);
            conn.createStatement().execute(etapePersonne);

         // Insertion entreprises
	        String insertEntreprise = "INSERT INTO entreprise (nom) VALUES (?)";
	        try (PreparedStatement stmt = conn.prepareStatement(insertEntreprise)) {
	            stmt.setString(1, "Menuiserie Dupont");
	            stmt.executeUpdate();
	        }

	        // Insertion personnes
	        String insertPersonne = "INSERT INTO personne (nom, prenom, anciennete) VALUES (?, ?, ?)";
	        try (PreparedStatement stmt = conn.prepareStatement(insertPersonne)) {
	            stmt.setString(1, "Martin");
	            stmt.setString(2, "Julie");
	            stmt.setInt(3, 5);
	            stmt.executeUpdate();

	            stmt.setString(1, "Durand");
	            stmt.setString(2, "Alex");
	            stmt.setInt(3, 10);
	            stmt.executeUpdate();

	            stmt.setString(1, "Bernard");
	            stmt.setString(2, "Emma");
	            stmt.setInt(3, 2);
	            stmt.executeUpdate();
	        }	
            System.out.println("Tables créées avec succès.");
        } catch (SQLException e) {
            System.err.println("Erreur création tables : " + e.getMessage());
        }
    }
}