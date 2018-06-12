package bouton;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


import fenetre.MaFrame;
import main.test;
/**
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Auteur : Python Loïc<br/>
 * Extention de la classe : btnBase <br/>
 * Description de la classe : Définis une image au bouton contact en héritant de btnBase		          <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Entrée(s) : - <br/>
 * Sortie : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Remarque : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 */
public class btnContact extends btnBase 
{
	/**
	 * Constructeur btnContact
	 * @author Loïc
	 */
	public btnContact() 
	{
		super("images/Contacts.png");
	}

}
