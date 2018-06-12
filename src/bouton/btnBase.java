package bouton;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Apps.Contact;
import fenetre.MaFrame;

/**
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Auteur : Python Loïc<br/>
 * Extention de la classe : JButton <br/>
 * Description de la classe : Modification du JButton de base permet de mettre une image a la place d'un
 *  boutton. <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Entrée(s) : Chemin de l'image, contacte ou rien - <br/>
 * Sortie : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Remarque : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 */
public class btnBase extends JButton 
{
	public String CheminImage ;
	
	public btnBase() {
		
		definitionBtn();
	}
	/**
	 * Bouton spécial pour les contacts
	 * @author Yannick
	 */
	public btnBase(Contact contact) {
		
		//definitionBtn();
		setBorderPainted(true);
		setSize(100, 100);
		setBackground(Color.white);		
		
	}
	
	public btnBase(String CheminImage)
	{
		this.CheminImage = CheminImage;
		
		definitionBtn();
	}
	
	/**
	 * Modification des paramètres souhaités de JButton
	 * @author Loïc
	 */
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
