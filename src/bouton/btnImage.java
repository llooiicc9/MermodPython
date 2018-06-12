package bouton;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import fenetre.MaFrame;
/**
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Auteur : Python Lo�c<br/>
 * Extention de la classe : btnBase <br/>
 * Description de la classe : D�finis une image au bouton gallerie en h�ritant de btnBase		          <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Entr�e(s) : - <br/>
 * Sortie : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Remarque : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 */
public class btnImage extends btnBase  
{
	/**
	 * Constructeur btnImage
	 * @author Lo�c
	 */
	public btnImage() 
	{
		super("images/Images.png");
	}
	
	
}
