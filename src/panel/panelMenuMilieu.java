package panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;


import bouton.btnBase;
import bouton.btnContact;
import bouton.btnImage;
import bouton.btnPizza;
import bouton.btnUnlock;

public class panelMenuMilieu extends JPanel 
{
	private panelBase haut = new panelBase();
	public panelBase bas = new panelBase();
	private panelBase milieu = new panelBase();
	public btnContact btnContacts = new btnContact();
	public btnImage btnImage = new btnImage();
	public btnPizza btnContacts2 = new btnPizza();
	
	//public btnBase home = new btnBase("images/Home.png");
	
	public panelMenuMilieu() 
	{
		setLayout(new BorderLayout());
		// Heure		
		
		// Pour avoir plein d'icone 3 sur 4
	/*	milieu.setLayout(new GridBagLayout());
		// Le gridBagConstraints va définir la position et la taille des éléments 
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.BOTH;
		// insets définir la marge entre les composant new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite)
		gc.insets = new Insets(0, 0, 0, 0);
		
		//Défini les case en x et y
		gc.weightx = 3;
		gc.weighty = 4;
		
		gc.gridy = 0;
		gc.gridx = 0;
		
		milieu.add(btnContacts, gc);
		
		gc.gridy = 0;
		gc.gridx = 1;
		milieu.add(btnImage, gc);
		
		gc.gridy = 0;
		gc.gridx = 2;
		milieu.add(btnContacts2, gc);
		
		for (int j = 1; j < 4; j++) 
		{
			for (int i = 0; i < 3; i++) 
			{
				gc.gridy = j;
				gc.gridx = i;
				
				btnBase btn = new btnBase("D:/User/Mes documents/HES/Dropbox/HES/2eme/POO/Contacts.png");
				//btn.setVisible(true);
				btn.setEnabled(false);
				btn.setBorderPainted(false);
				btn.setBorderPainted(false);
				btn.setOpaque(false);
				btn.setContentAreaFilled(false);
				milieu.add(btn, gc);
				
			}
		}*/
		
		milieu.add(btnContacts);		
		milieu.add(btnImage);
		milieu.add(btnContacts2);
	//	bas.add(home);
		
		//add(haut, BorderLayout.NORTH);
		add(milieu,BorderLayout.CENTER);	
		//add(bas,BorderLayout.SOUTH);
			
	}
	
	public void paintComponent(Graphics g)
    {
		try 
	    {
	      Image img = ImageIO.read(new File("images/background.jpg"));
	      //g.drawImage(img, 0, 0, this);
	      //Pour une image de fond
	     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	    } catch (IOException e) {
	     System.out.println("ERREUR : le fond d'écran ne peut pas être chargé ");
	    }                
    }
}
