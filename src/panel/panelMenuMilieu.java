package panel;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import bouton.btnBase;
import bouton.btnCalculette;
import bouton.btnContact;
import bouton.btnImage;
import bouton.btnSettings;

/**
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Auteur : Python Loïc - Mermod Yannick <br/>
 * Extention de la classe : JPanel <br/>
 * Description de la classe : Ce panel gère la redirection entre les différentes applications. <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Entrée(s) : - <br/>
 * Sortie : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Remarque : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 */
public class panelMenuMilieu extends JPanel 
{
	private panelBase haut = new panelBase();
	public panelBase bas = new panelBase();
	private panelBase milieu = new panelBase();
	public btnContact btnContacts = new btnContact();
	public btnImage btnImage = new btnImage();
	private btnBase btnEteindre = new btnBase("images/eteindre.png");
	public btnCalculette btnCalcul = new btnCalculette();
	public btnSettings reglage = new btnSettings();

	/**
	 Constructeur de panelMenuMilieu
	 * @author Loïc
	 */
	public panelMenuMilieu() 
	{
		setLayout(new BorderLayout());
		
		//Ajoute les différents applications au menu principal
		milieu.add(btnContacts);		
		milieu.add(btnImage);
		milieu.add(btnCalcul);
		milieu.add(btnEteindre);
		milieu.add(reglage);
	
		
		add(milieu,BorderLayout.CENTER);
		
		btnEteindre.addActionListener(new fermerApplication());
			
	}
	
	/**
	 Classe qui permet sur le clique du btnEteindre de fermer l'application
	 * @author Loïc
	 *
	 */
	class fermerApplication implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			System.exit(0);
		}
		
	}
	
	/**
	 Fonction pour afficher un fond d'écran 
	 * @author Loïc
	 *
	 */
	public void paintComponent(Graphics g)
    {
		try 
	    {
	      Image img = ImageIO.read(new File("images/background.jpg"));
	      //Pour une image de fond
	     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	    } catch (IOException e) {
	     System.out.println("ERREUR : le fond d'écran ne peut pas être chargé ");
	    }                
    }
}
