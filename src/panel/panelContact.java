package panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Apps.Contact;
import bouton.btnBase;
import bouton.btnUnlock;
import fenetre.MaFrame;


public class panelContact extends JPanel 
{
	public btnUnlock btnunlock= new btnUnlock();
	public btnBase add = new btnBase("images/add.png");
	private JPanel haut = new JPanel();
	private JPanel bas = new JPanel();
	private MaFrame maFrame;
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	
	public panelContact() {
		
	}
	public panelContact(MaFrame maFrame) 
	{
		this.maFrame=maFrame;
		this.setBackground(Color.WHITE);
		
	}
	
	//Enregistre les contacts créés
	public void serializeObject() 
	{
		try 
		{
			FileOutputStream FichierContact = new FileOutputStream("C/Users/mermo/Desktop/Cours/Semestre 2/POO/MermodPython/Serialize/contact.ser");
			ObjectOutputStream OutputContact = new ObjectOutputStream(FichierContact);
			OutputContact.writeObject(contacts);
			OutputContact.flush();
			OutputContact.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	//A l'inverse, va supprimer le fichier enregistrer
	public void deSerializeObject() 
	{
		try 
		{
			FileInputStream FichierContact = new FileInputStream("C/Users/mermo/Desktop/Cours/Semestre 2/POO/MermodPython/Serialize/contact.ser");
			ObjectInputStream InputContact = new ObjectInputStream(FichierContact);
			contacts = (ArrayList<Contact>) InputContact.readObject();
			InputContact.close();
		} 
		catch (IOException e) 
		{
			contacts = new ArrayList<Contact>();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();

		}
	}
	
	     
   
}

class ListeContact extends JList<Contact>{
	
	public ListeContact() {
		
		
	}
}
