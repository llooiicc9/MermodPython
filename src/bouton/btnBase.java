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
 * Auteur : Python Lo�c<br/>
 * Extention de la classe : JButton <br/>
 * Description de la classe : Modification du JButton de base permet de mettre une image a la place d'un
 *  boutton. <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Entr�e(s) : Chemin de l'image, contacte ou rien - <br/>
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
	 * Bouton sp�cial pour les contacts
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
	 * Modification des param�tres souhait�s de JButton
	 * @author Lo�c
	 */
	private void definitionBtn()
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
	
	public void setcheminImage(String chemin) {
		// TODO Auto-generated method stub
		this.CheminImage=chemin;
	}
	
	
	
}
