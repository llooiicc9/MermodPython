package bouton;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import fenetre.MaFrame;
import fenetre.MonDialog;

public class btnBase extends JButton 
{
	
	public btnBase(String CheminImage) 
	{
		super();
		definitionBtn(CheminImage);
	}
	
	private void definitionBtn(String CheminImage)
	{
		//Choix de l'image pour remplacer le boutton
		setIcon(new ImageIcon(CheminImage));
		//Affiche que le boutton est s�lectionner
		setFocusPainted(false);
		//D�sactive la bordure du boutton pour ne voir que l'image
		setBorderPainted(false);
		setOpaque(false);
		setContentAreaFilled(false);
	}
	
	
}
