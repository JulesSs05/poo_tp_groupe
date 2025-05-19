package gestionMeuble;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class JeuEssai {

    public static void main(String[] args) {
    	
    	SchemaInitializer.createTables();
		
		Personne p1 = new Personne("Silvestri", "Jules", 3);
		Personne p2 = new Personne("Lea-Plaza", "Maria", 5);
		Personne p3 = new Personne("nom", "Fares", 6);
		Personne p4 = new Personne("nom", "Oussama", 7);
		Personne p5 = new Personne("nom", "Salma", 1);
		
		p1.save();
		p2.save();
	
        Entreprise entreprise = new Entreprise("Meubles SA");

        JFrame frame = new JFrame("Gestion de Meubles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(6, 2));

        // Champs pour le meuble
        JLabel nomLabel = new JLabel("Nom du meuble :");
        JTextField nomField = new JTextField();

        JLabel hauteurLabel = new JLabel("Hauteur (cm) :");
        JTextField hauteurField = new JTextField();

        JLabel largeurLabel = new JLabel("Largeur (cm) :");
        JTextField largeurField = new JTextField();

        JLabel profondeurLabel = new JLabel("Profondeur (cm) :");
        JTextField profondeurField = new JTextField();

        JLabel etapeLabel = new JLabel("Étape de fabrication :");
        String[] etapes = {"assemblage", " peinture-vernis", "colisage"};
        JComboBox<String> etapeComboBox = new JComboBox<>(etapes);

        JButton fabriquerBtn = new JButton("Fabriquer le meuble");

        // Ajout des composants à la fenêtre
        frame.add(nomLabel); frame.add(nomField);
        frame.add(hauteurLabel); frame.add(hauteurField);
        frame.add(largeurLabel); frame.add(largeurField);
        frame.add(profondeurLabel); frame.add(profondeurField);
        frame.add(etapeLabel); frame.add(etapeComboBox);
        frame.add(new JLabel()); frame.add(fabriquerBtn);

        // Action du bouton
        fabriquerBtn.addActionListener(e -> {
            try {
                String nom = nomField.getText();
                double h = Double.parseDouble(hauteurField.getText());
                double l = Double.parseDouble(largeurField.getText());
                double p = Double.parseDouble(profondeurField.getText());
                String etape = (String) etapeComboBox.getSelectedItem();

                Meuble m = new Meuble(nom, h, l, p, "");
                LinkedList<Personne> personnes = new LinkedList<>(); 

                entreprise.fabriquerMeuble(m, etape, personnes);
                entreprise.afficherMeuble();
                entreprise.afficherMeublesEnCours();

                JOptionPane.showMessageDialog(frame, "Meuble fabriqué et ajouté à l'entreprise !");
                
                // Réinitialisation des champs
                nomField.setText("");
                hauteurField.setText("");
                largeurField.setText("");
                profondeurField.setText("");
                etapeComboBox.setSelectedIndex(0);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Veuillez entrer des dimensions valides (nombres).");
            }
        });

        frame.setVisible(true);
    }
}
