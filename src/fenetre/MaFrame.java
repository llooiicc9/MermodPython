package fenetre;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import bouton.btnUnlock;
import panel.panelBas;
import panel.panelCalculette;
import panel.panelContact;
import panel.panelHaut;
import panel.panelImage;
import panel.panelMenuMilieu;
import panel.panelUnlockMilieu;


public class MaFrame extends JFrame 
{
	CardLayout cl = new CardLayout();
	JPanel content = new JPanel();
	String[] listContent = {"Lock", "Menu", "Contact", "Image","Demineur","Calculette"};
	
	private panelHaut nord = new panelHaut();
	private panelBas sud = new panelBas();
	private panelUnlockMilieu milieu = new panelUnlockMilieu();
	private panelMenuMilieu Menu = new panelMenuMilieu();
	private panelContact contacts = new panelContact();
	private panelImage gallerieImage = new panelImage();
	private panelCalculette calcul = new panelCalculette();
	

	public MaFrame()
	{
		super("");
		
		
	 
	    
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setLocation(500, 200);
		//Pour arrondir les bords
		setShape(new RoundRectangle2D.Float(0,0,449,799,75,75));

		   //On définit le layout
	    content.setLayout(cl);
	    //Permet de changer de panel
	    content.add(milieu, listContent[0]);
	    content.add(Menu, listContent[1]);
	    content.add(contacts, listContent[2]);
	    content.add(gallerieImage, listContent[3]);
	    content.add(calcul,listContent[5]);
	    
	    
		add(nord,BorderLayout.NORTH);
		add(sud,BorderLayout.SOUTH);
		//add(milieu,BorderLayout.CENTER);
		
		setSize(450, 800);
	    getContentPane().add(content, BorderLayout.CENTER);
	    setVisible(true);
 
	   //Lance l'application contacts
	   Menu.btnContacts.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent event){				
			   
		        cl.show(content, listContent[2]);
		        contacts.gallerie.afficheImage();
		      }
	        });
	   
	   //Lance l'application image
	   Menu.btnImage.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent event){				
			   
		        cl.show(content, listContent[3]);
		        gallerieImage.afficheImage();
		      }
	        });
	   
	   //Retour au menu
	   sud.btnHome.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent event){				
			   
		        cl.show(content, listContent[1]);
		      }
	        });
	   
	   Menu.btnCalcul.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent event) {
			   cl.show(content, listContent[5]);
		   }
	   });

	}	

}


