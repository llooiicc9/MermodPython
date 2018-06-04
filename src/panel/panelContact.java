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
import javax.swing.JScrollPane;
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
	//Permet de rentrer un nouveau contact
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

	//bouton et texte affich� dans la page principale contact avec la liste des contacts
	public btnBase ajout = new btnBase("images/add.png");
	private JLabel text = new JLabel("Ajouter un contact");
	
	//panel de base d'affichage
	private JPanel haut = new JPanel();
	private JPanel bas = new JPanel();
	//Panel du listener du bouton ajout
	private JPanel pane = new JPanel(new GridLayout(6,2));
	//Panel d'affichage de la liste
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	
	
    //CardLayout + panel conteneur qui va changer les fen�tre selon l'action de l'utilisateur (ajout, retour, etc)
    CardLayout CardLayoutContact = new CardLayout();
	String[] listContent = {"liste", "ajout","affiche"};
	JPanel base = new JPanel();
	JPanel north= new JPanel();
	JPanel affiche = new JPanel();
	
	
	public panelContact() {
		
		text.setFont(new Font("Arial", Font.BOLD, 40));
		setLayout(new BorderLayout());
		north.add(text);
		north.add(ajout);
		add(north,BorderLayout.NORTH);

		JPanel center= new JPanel();
		
		base.setLayout(CardLayoutContact);
		setBackground(Color.WHITE);
		base.add(center, listContent[0]);
		base.add(pane, listContent[1]);
		base.add(affiche,listContent[2]);
		add(base,BorderLayout.CENTER);
		
		
		ajout.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent event){				
					   
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
						
						//En cliquant sur retour on revient � la page d'affichage des contacts
					    retour.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent event){				
								
								north.add(text);
								north.add(ajout);
								add(north,BorderLayout.NORTH);
								CardLayoutContact.show(base, listContent[0]);
				      }
			        });
					   //En cliquant sur valider, on revient sur la page d'affichage des contacts avec le nouveau contact int�gr�
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
	//Enregistre les contacts cr��s
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
	// Charge les contacts
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
	//Ajoute le contact dans la liste et l'�crit dans un fichier
	public void addContact() {
		
		Contact test = new Contact(nom.getText(), prenom.getText(), numero.getText(), adresse.getText(), mail.getText());
		contacts.add(test);
		serializeObject();
		
	}
	
	// vraiment utile ? pas mieux de faire un panel gridlayout de la taille de l'arrayList avec une taille d�finie de bouton et une scrollbar
	class ContactList extends JPanel {
		private JPanel panelListe = new JPanel();
		private JScrollPane scroll = new JScrollPane(panelListe);

		/**
		 * Constructeur de la liste des contacts
		 * @author Rafael Peixoto
		 */
		public ContactList() 
		{
			panelListe.setLayout(new BoxLayout(panelListe, BoxLayout.Y_AXIS));
			afficheContact();
		}
	
		//Modifie la liste de contact
		public void updateContact() {
		
		
		}
		
		//Modifie le contact
		private void modifyContact(Contact contact) {
		
			contacts.set(contacts.indexOf(contact), contact);
			updateContact();
		}
		
		//Supprime le contact
		private void delete(Contact contact) {
			contacts.remove(contact);
			updateContact();
		}
	
		//Affiche les contacts sous forme de bouton en nom pr�nom
		public void afficheContact() {
		
			btnBase contact;
		
			for(int i=0; i<contacts.size();i++) {
				contact = new btnBase(contacts.get(i).getNom()+" "+contacts.get(i).getPrenom());
				panelListe.add(contact);
				contact.setBackground(Color.BLACK);
				contact.setFont(new Font("Arial", Font.BOLD, 60));
		}
		
		
		ContactList liste = new ContactList();
		liste.setLayout(new GridLayout(contacts.size(),1));
		liste.add(panelListe);
		this.add(liste);
		
		
		/*contact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				JPanel affiche = new JPanel();
				JLabel infos = new JLabel();
				CardLayoutContact.show(base, listContent[2]);
				
			}
		});*/
	}
	}
}
	
	     
	
