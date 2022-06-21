import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Convertisseur extends JFrame implements ActionListener {
	
	private JButton btAc = new JButton("AC");
	private JButton btEuros = new JButton("Euros");
	private JButton btDevise = new JButton("Francs");
	private JButton btTaux = new JButton("Taux");
	private JButton btQuitter = new JButton("Quitter");
	private JButton btAPropos = new JButton("A Propos");
	
	private JTextField txtMontant = new JTextField();
	
	private float taux = (float) 6.56;
	
	private JMenuBar uneBarre = new JMenuBar();
	private JMenu mnFichier = new JMenu("Fichiers");
	private JMenu mnOpérations = new JMenu("Opérations");
	private JMenu mnHelp = new JMenu("Help");
	
	private JMenuItem itemAc = new JMenuItem("AC");
	private JMenuItem itemQuitter = new JMenuItem("Quitter");
	private JMenuItem itemEuros = new JMenuItem("Euros");
	private JMenuItem itemDevise = new JMenuItem("Devise");
	private JMenuItem itemAPropos = new JMenuItem("A Propos");
	private JMenuItem itemTaux = new JMenuItem("Taux");
	
	public Convertisseur () {
		this.setTitle("Mon Convertisseur de monnaies");
		this.setBounds(300, 300, 450, 250);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.cyan);
		this.setResizable(false);
		
		this.btEuros.setBounds(50, 50, 100, 30);
		this.add(this.btEuros);
		
		this.txtMontant.setBounds(170, 50, 100, 30);
		this.add(this.txtMontant);
		
		this.btDevise.setBounds(290, 50, 100, 30);
		this.add(this.btDevise);
		
		this.btTaux.setBounds(50, 100, 100, 30);
		this.add(this.btTaux);
		
		this.btAc.setBounds(170, 100, 100, 30);
		this.add(this.btAc);
		
		this.btAPropos.setBounds(290, 100, 100, 30);
		this.add(this.btAPropos);
		
		this.btQuitter.setBounds(50, 150, 340, 30);
		this.add(this.btQuitter);
		
		// Rendre les boutons écoutables
		this.btAc.addActionListener(this);
		this.btTaux.addActionListener(this);
		this.btQuitter.addActionListener(this);
		this.btEuros.addActionListener(this);
		this.btDevise.addActionListener(this);
		this.btAPropos.addActionListener(this);
		
		// Constitution des menus
		this.mnFichier.add(this.itemQuitter);
		this.mnOpérations.add(this.itemAc);
		this.mnOpérations.add(this.itemTaux);
		this.mnOpérations.add(this.itemEuros);
		this.mnOpérations.add(this.itemDevise);
		this.mnHelp.add(this.itemAPropos);
		
		this.uneBarre.add(this.mnFichier);
		this.uneBarre.add(this.mnOpérations);
		this.uneBarre.add(this.mnHelp);
		
		this.setJMenuBar(this.uneBarre);
		
		// Rendre les items cliquables
		this.itemAc.addActionListener(this);
		this.itemTaux.addActionListener(this);
		this.itemQuitter.addActionListener(this);
		this.itemAPropos.addActionListener(this);
		this.itemEuros.addActionListener(this);
		this.itemDevise.addActionListener(this);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		Convertisseur monConvertisseur = new Convertisseur();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAc || e.getSource() == this.itemAc) {
			this.txtMontant.setText("");
		} else if (e.getSource() == this.btQuitter || e.getSource() == this.itemQuitter) {
			int retour = JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'application ?", "Quiter l'application", JOptionPane.YES_NO_OPTION);
			if (retour == 0) {
				this.dispose();
			}
		} else if (e.getSource() == this.btEuros || e.getSource() == this.itemEuros) {
			float mt = 0;
			try {
				mt = Float.parseFloat(this.txtMontant.getText());
				mt = mt / this.taux;
				this.txtMontant.setText(mt + "");
			} catch (NumberFormatException exp) {
				JOptionPane.showMessageDialog(this, "Erreur de saisie");
				this.txtMontant.setText("");
			}
		} else if (e.getSource() == this.btDevise || e.getSource() == this.itemDevise) {
			float mt = 0;
			try {
				mt = Float.parseFloat(this.txtMontant.getText());
				mt = mt * this.taux;
				this.txtMontant.setText(mt + "");
			} catch (NumberFormatException exp) {
				JOptionPane.showMessageDialog(this, "Erreur de saisie");
				this.txtMontant.setText("");
			}
		} else if (e.getSource() == this.btAPropos || e.getSource() == this.itemAPropos) {
			JOptionPane.showMessageDialog(this, 
					"Application réalisée le 10 janvier 2022"
					+"\n avec le Framework Swing Java"
					+ "\n En classe SIO 1A SLAM"
					+ "\n Copyright IRIS Ecole");
		} else if (e.getSource() == this.btTaux || e.getSource() == this.itemTaux) {
			try {
				String devise = JOptionPane.showInputDialog("Donner la nouvellle devise : ");
				this.btDevise.setText(devise);
				this.taux = Float.parseFloat(JOptionPane.showInputDialog("Donner le taux de change de cette devise : "));
			} catch (NumberFormatException exp) {
				JOptionPane.showMessageDialog(this, "Erreur de saisie");
				this.btDevise.setText("Francs");
				this.taux = (float) 6.56;
			}
		}
		
	}

}
