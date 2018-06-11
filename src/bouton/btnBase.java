package bouton;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Apps.Contact;
import fenetre.MaFrame;

public class btnBase extends JButton 
{
	public String CheminImage ;
	
	public btnBase() {
		
		definitionBtn();
	}
	//bouton contact
	public btnBase(Contact contact) {
		
		//definitionBtn();
		setBorderPainted(true);
		setSize(100, 100);
		setBackground(Color.white);
		
		
	}
	public btnBase(String CheminImage)
	{
		super();
		this.CheminImage = CheminImage;
		
		definitionBtn();
	}
	
	private void definitionBtn()
	{
		//Choix de l'image pour remplacer le boutton
		setIcon(new ImageIcon(CheminImage));
		//Affiche que le boutton est sélectionner
		setFocusPainted(false);
		//Désactive la bordure du boutton pour ne voir que l'image
		setBorderPainted(false);
		setOpaque(false);
		setContentAreaFilled(false);
	}
	public void setcheminImage(String chemin) {
		// TODO Auto-generated method stub
		this.CheminImage=chemin;
	}
	
	
	
}
