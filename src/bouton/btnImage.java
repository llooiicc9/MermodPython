package bouton;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import fenetre.MaFrame;
/**
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Auteur : Python Loïc<br/>
 * Extention de la classe : btnBase <br/>
 * Description de la classe : Définis une image au bouton gallerie en héritant de btnBase		          <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Entrée(s) : - <br/>
 * Sortie : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Remarque : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 */
public class btnImage extends btnBase  
{
	/**
	 * Constructeur btnImage
	 * @author Loïc
	 */
	public btnImage() 
	{
		super("images/Images.png");
	}
	
	
}
