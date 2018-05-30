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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
	//bouton de validation et de retour lors de l'ajout d'un client (ajouter la suppression)
	public btnBase ok = new btnBase("images/validate.png");
	public btnBase retour = new btnBase("images/Retour.png");
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

	//bouton et texte affiché dans la page principale contact avec la liste des contacts
	public btnBase ajout = new btnBase("images/add.png");
	private JLabel text = new JLabel("Ajouter un contact");
	
	//panel de base d'affichage
	private JPanel haut = new JPanel();
	private JPanel bas = new JPanel();
	//Panel du listener du bouton ajout
	private JPanel pane = new JPanel(new GridLayout(6,2));
	//Panel d'affichage de la liste
	private JPanel liste = new JPanel();
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	
    //CardLayout + panel conteneur qui va changer les fenêtre selon l'action de l'utilisateur (ajout, retour, etc)
    CardLayout CardLayoutContact = new CardLayout();
	String[] listContent = {"liste", "ajout"};
	JPanel base = new JPanel();
	JPanel north= new JPanel();
	
	public panelContact() {
		
		setLayout(new BorderLayout());
		north.add(text);
		north.add(ajout);
		
		add(north,BorderLayout.NORTH);
		
		JPanel center= new JPanel();
		
		base.setLayout(CardLayoutContact);
		setBackground(Color.WHITE);
		base.add(center, listContent[0]);
		base.add(pane, listContent[1]);
		add(base,BorderLayout.CENTER);
		
		
		
	
		ajout.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent event){				
				   
					//   System.out.println("Salut");
					   
					    north.removeAll();
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
						pane.add(ok);
						pane.add(retour);

						CardLayoutContact.show(base, listContent[1]);
						
					    retour.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent event){				
								
								north.add(text);
								north.add(ajout);
								add(north,BorderLayout.NORTH);
								CardLayoutContact.show(base, listContent[0]);
				      }
			        });
					   
					   ok.addActionListener(new ActionListener() {
						   public void actionPerformed(ActionEvent event) {
							    north.add(text);
								north.add(ajout);
								add(north,BorderLayout.NORTH);
								
							   addContact();
							   
							   CardLayoutContact.show(base, listContent[0]);
						   }
					   });
				   }
		});

	}
	//Enregistre les contacts créés
	public void serializeObject() 
	{
		try 
		{
			FileOutputStream FichierContact = new FileOutputStream("Serialize/contact.ser");
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
			FileInputStream FichierContact = new FileInputStream("Serialize/contact.ser");
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
	
	public void addContact() {
		
		Contact test = new Contact(nom.getText(), prenom.getText(), numero.getText(), adresse.getText(), mail.getText());
		String a = nom.getText() + prenom.getText();
		btnBase contact = new btnBase(test);
		contact.setText(a);
		
		JPanel liste = new JPanel();
		liste.add(contact);
		this.add(liste);
		
	}
}
	
	     
	
