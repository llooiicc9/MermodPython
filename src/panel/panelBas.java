package panel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import bouton.btnBase;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.border.Border;
 
/**
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Auteur : Python Loïc <br/>
 * Extention de la classe : JPanel <br/>
 * Description de la classe : Ajoute le bouton home et le fond noir pour ressembler a un smartphone <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Entrée(s) : - <br/>
 * Sortie : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Remarque : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 */
public class panelBas extends JPanel {
	
	public JButton btnHome = new btnBase("images/Home.png");
	
	public panelBas() {
		
		add(btnHome);
		setBackground(Color.BLACK);
		
	}

}


 
 
 
