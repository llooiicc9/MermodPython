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
 * Auteur : Python Lo�c<br/>
 * Extention de la classe : btnBase <br/>
 * Description de la classe : D�finis une image au bouton contact en h�ritant de btnBase		          <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Entr�e(s) : - <br/>
 * Sortie : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Remarque : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 */
public class btnContact extends btnBase 
{
	/**
	 * Constructeur btnContact
	 * @author Lo�c
	 */
	public btnContact() 
	{
		super("images/Contacts.png");
	}

}
