package panel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SpringLayout;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Apps.Contact;

import bouton.btnBase;
import bouton.btnUnlock;
import fenetre.MaFrame;


public class panelContact extends JPanel 
{
	public btnBase ajout = new btnBase("images/add.png");
	private JLabel text = new JLabel("Ajouter un contact");
	private JPanel haut = new JPanel();
	private JPanel bas = new JPanel();
	private JPanel pane = new JPanel();
	private MaFrame maFrame;
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	private JLabel Nom = new JLabel("Nom :");
	private JTextField nom = new JTextField();
	private JLabel Prenom = new JLabel("Prenom :");
    private JTextField prenom = new JTextField();
    private JLabel Numero = new JLabel("Numero :");
    private JTextField numero = new JTextField();
    private JLabel Adresse = new JLabel("Adresse :");
    private JTextField adresse = new JTextField();
    private JLabel Mail = new JLabel("Mail : ");
    private JTextField mail = new JTextField();
    
	
	public panelContact() {
		
		this.setBackground(Color.WHITE);
		this.add(text);
		this.add(ajout);
		
		ajout.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent event){				
				   
				   System.out.println("Salut");
				   
			        	/* Pour avoir plein d'icone
						pane.setLayout(new GridBagLayout());
						// Le gridBagConstraints va définir la position et la taille des éléments 
						GridBagConstraints gc = new GridBagConstraints();
						gc.fill = GridBagConstraints.BOTH;
						// insets définit la marge entre les composants new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite)
						gc.insets = new Insets(0, 0, 0, 0);
						
						//Défini les case en x et y
						gc.weightx = 1;
						gc.weighty = 4;
						
						gc.gridy = 0;
						gc.gridx = 0;
						pane.add(nom, gc);
						
						gc.gridy = 1;
						gc.gridx = 0;
						pane.add(prenom, gc);
						
						gc.gridy = 2;
						gc.gridx = 0;
						pane.add(numero, gc);
						
						gc.gridy = 3;
						gc.gridx = 0;
						pane.add(adresse,gc);*/
				   
				   	pane.setLayout(new GridLayout(5,2));
					
					pane.add(Nom);
					pane.add(nom);
					pane.add(Prenom);
					pane.add(prenom);
					pane.add(Numero);
					pane.add(numero);
					pane.add(Adresse);
					pane.add(adresse);
					pane.add(Mail);
					pane.add(mail);
		
					
					pane.setVisible(true);
				   

			      }
		        });
		
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
