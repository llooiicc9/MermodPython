package panel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javax.swing.plaf.synth.SynthSeparatorUI;

import Apps.Contact;

import bouton.btnBase;
import bouton.btnUnlock;
import fenetre.MaFrame;
import panel.panelImage.AgrandirImg;



/**
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Classe : panelContact <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Auteur : Mermod Yannick <br/>
 * Nom de la classe : panelContact <br/>
 * Extension de la classe : JPanel <br/>
 * Description de la classe : Cette classe gère l'application des contacts. <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Entrée(s) : - <br/>
 * Sortie : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Remarque : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 */

public class panelContact extends JPanel 
{
	public buttonok ok = new buttonok(this);
	private String lienImage = "";
	public btnBase retour = new btnBase("images/Retour.png");
	//Permet de rentrer un nouveau contact
	private JLabel Nom = new JLabel("Nom :");
	JTextField nom = new JTextField();
	private JLabel Prenom = new JLabel("Prenom :");
    JTextField prenom = new JTextField();
    private JLabel Numero = new JLabel("Numero :");
    JTextField numero = new JTextField();
    private JLabel Adresse = new JLabel("Adresse :");
    JTextField adresse = new JTextField();
    private JLabel Mail = new JLabel("Mail : ");
    JTextField mail = new JTextField();
    private JLabel Photo = new JLabel("Photo : ");
    btnBase photo = new btnBase("images/Images.png");
    JButton a; 
    public String chemin=null;
    
    
  //bouton et texte affiché dans la page principale contact avec la liste des contacts
  	public btnBase ajout = new btnBase("images/add.png");
  	JLabel text = new JLabel("Ajouter un contact");
  	
  	//panel de base d'affichage
  	private JPanel haut = new JPanel();
  	private JPanel bas = new JPanel();
  	//Panel du listener du bouton ajout
  	private JPanel pane = new JPanel(new GridLayout(7,2));
  	//Panel d'affichage de la liste
  	ArrayList<Contact> contacts = new ArrayList<Contact>();
  	public panelImage gallerie = new panelImage();
  	public btnBase photoProfil;
  	private Dimension dimension = new Dimension(450,80);
  

  	
  	//CardLayout + panel conteneur qui va changer les fenêtre selon l'action de l'utilisateur (ajout, retour, etc)
    CardLayout CardLayoutContact = new CardLayout();
	String[] listContent = {"liste", "ajout","affiche","gallerie"};
	JPanel base = new JPanel();
	JPanel north= new JPanel();
	JPanel affiche = new JPanel();
	JPanel center= new JPanel();
	Font police = new Font("Arial",Font.ROMAN_BASELINE,20);
	JPanel scrollbar = new JPanel();
	
	/**
	 * Constructeur du panelContact
	 * @author Yannick
	 */
	
	public panelContact() {
		
		JScrollPane scroll = new JScrollPane(center, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // si on veut mettre une scrollbar

		center.setLayout(new BoxLayout(center,BoxLayout.PAGE_AXIS));
		
		text.setFont(new Font("Arial", Font.ROMAN_BASELINE, 40));
		setLayout(new BorderLayout());
		north.add(text);
		north.add(ajout);
		add(north,BorderLayout.NORTH);
		
		base.setLayout(CardLayoutContact);
		setBackground(Color.WHITE);
		
		base.add(scroll, listContent[0]);
		base.add(pane, listContent[1]);
		base.add(affiche,listContent[2]);
		base.add(gallerie, listContent[3]);
		
		add(base,BorderLayout.CENTER);
		
		afficheContact();
		
		/**
		 * Création du Listener d'ajout d'un contact
		 * @author Yannick
		 */
		
		ajout.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent event){				
					   
					    north.removeAll();
					    pane.add(Nom);
					    Nom.setFont(police);
					    pane.add(nom);
					    nom.setFont(police);
					    pane.add(Prenom);
					    Prenom.setFont(police);
					    pane.add(prenom);
					    prenom.setFont(police);
						pane.add(Numero);
						Numero.setFont(police);
						pane.add(numero);
						numero.setFont(police);
						pane.add(Adresse);
						Adresse.setFont(police);
						pane.add(adresse);
						adresse.setFont(police);
						pane.add(Mail);
						Mail.setFont(police);
						pane.add(mail);
						mail.setFont(police);
						pane.add(Photo);
						Photo.setFont(police);
						pane.add(photo);
						pane.add(ok);
						pane.add(retour);
						
						CardLayoutContact.show(base, listContent[1]);
						
						/**
						 * Création du Listener pour ajouter une photo à un contact 
						 * @author Yannick
						 */
						
						photo.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent event) {
								
								gallerie.nomContact = nom.getText();
								gallerie.afficheImage();
								CardLayoutContact.show(base, listContent[3]);
								
								/**
								 * Création du Listener du bouton ajouter la photo à un contact
								 * @author Yannick
								 */
								
								gallerie.btnContact.addActionListener(new ActionListener(){
									   public void actionPerformed(ActionEvent event){	
										   	photo.setText(gallerie.getImageContact());
									        CardLayoutContact.show(base, listContent[1]);
									      }
								        });
								
							}
						});
						
						/**
						 * Création du Listener pour le retour en arrière 
						 * @author Yannick
						 */
						
					    retour.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent event){				
								
								north.add(text);
								north.add(ajout);
								add(north,BorderLayout.NORTH);
							
								CardLayoutContact.show(base, listContent[0]);
				      }
			        });	
	}
    
});
		
	}
	
	/**
	 * Création de la méthode afficheContact()
	 * @author Yannick
	 */
	
	public void afficheContact() {

		center.removeAll();
		deSerializeObject();

	    System.out.println(contacts.size());
		for(int i=0; i<contacts.size();i++) {
			a= new JButton();
			a.setText(contacts.get(i).getNom()+" "+contacts.get(i).getPrenom());
			a.setName(""+i);
			a.setFont(new Font("Arial", Font.BOLD, 30));
			a.setMaximumSize(dimension);
			a.setMinimumSize(dimension);
			a.setPreferredSize(dimension);
			if(i%2==0) {
				//a.setBackground(new Color(210, 202, 236));
				a.setBackground(new Color(115, 194, 251));
			} else {
				//a.setBackground(new Color(201, 160, 220));
				a.setBackground(new Color(187, 210, 225));
			}
			center.add(a);
		
		
			CardLayoutContact.show(base, listContent[0]);
			
			a.addActionListener(new ClickContact(a));
			
	}}
	
	/**
	 * Création du Listener ClickContact
	 * @author Yannick
	 */
	
	class ClickContact implements ActionListener
	{
		private JButton btnContact;

		
		public ClickContact(JButton btnContact) 
		{
			this.btnContact = btnContact;
		}

		public void actionPerformed(ActionEvent e) 
		{
			afficherUnContact(btnContact);
			
		}
	}
	
	/**
	 * Création de la méthode afficherUnContact
	 * @author Yannick
	 */
	
	private void afficherUnContact(JButton btnContacte)
	{
		north.removeAll();
		affiche.removeAll();
		affiche.setLayout(new GridLayout(9,2));
		
		btnBase modifier = new btnBase("images/save.png");
		btnBase delete = new btnBase("images/delete.png");
		
		if (chemin!=null) {
			
			chemin=null;
		}
		else
		{	photoProfil = new btnBase(contacts.get(getID(btnContacte)).getcheminImage());
			
		}
		System.out.println(getID(btnContacte));
		
			  for( ActionListener al : photoProfil.getActionListeners() ) {
			    photoProfil.removeActionListener( al );
			  }
			
	  /**
	   * Création du Listener de changement de photo de profil
	   * @author Yannick
	   */
			  
	    photoProfil.addActionListener(new modifiePhoto(btnContacte));		
		
		affiche.add(Photo);
		affiche.add(photoProfil);
		affiche.add(Nom);
		nom.setText(contacts.get(getID(btnContacte)).getNom());
		affiche.add(nom);
		affiche.add(Prenom);
		prenom.setText(contacts.get(getID(btnContacte)).getPrenom());
		affiche.add(prenom);
		affiche.add(Numero);
		numero.setText(contacts.get(getID(btnContacte)).getTelephone());
		affiche.add(numero);
		affiche.add(Adresse);
		adresse.setText(contacts.get(getID(btnContacte)).getAdresse());
		affiche.add(adresse);
		affiche.add(Mail);
		mail.setText(contacts.get(getID(btnContacte)).getMail());
		affiche.add(mail);
		
		affiche.add(modifier);
		affiche.add(delete);
		affiche.add(retour);
		
		
		CardLayoutContact.show(base, listContent[2]);
		
		delete.addActionListener(new delContact(btnContacte));
		modifier.addActionListener(new modifierContact(btnContacte));
		retour.addActionListener(new retourContact(btnContacte));
	}

	/**
	 * Création du Listener qui modifie la photo de profil
	 * @author Yannick
	 */
	
	class modifiePhoto implements ActionListener
	{
		private JButton btnContact;

		public modifiePhoto(JButton btnContact) 
		{
			this.btnContact = btnContact;
		}

		public void actionPerformed(ActionEvent e) 
		{
			gallerie.nomContact = nom.getText();
			gallerie.afficheImage();
			CardLayoutContact.show(base, listContent[3]);
			
			  for( ActionListener al : gallerie.btnContact.getActionListeners() ) {
				  gallerie.btnContact.removeActionListener( al );
				  }
				
			  /**
				 * Création du Listener qui retourne l'image au contact après son changement de photo
				 * @author Yannick
				 */
			  
			gallerie.btnContact.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){	
					   
					   	chemin = (gallerie.getImageContact());
					   
					   	photoProfil.remove(photoProfil);
					   	photoProfil = new btnBase(chemin);
						
						afficherUnContact(btnContact);
				      }
			});
		}
	}
	
	/**
	 * Création du Listener de retour
	 * @author Yannick
	 */
	
	class retourContact implements ActionListener
	{
		private JButton btnContact;

		public retourContact(JButton btnContact) 
		{
			this.btnContact = btnContact;
		}

		public void actionPerformed(ActionEvent e) 
		{
		 	north.add(text);
			north.add(ajout);
			add(north,BorderLayout.NORTH);
			
			nom.setText("");
			prenom.setText("");
			numero.setText("");
			adresse.setText("");
			mail.setText("");
			photo.setText("");
			
			CardLayoutContact.show(base, listContent[0]);
		}
	}
	
	/**
	 * Création du Listener de modification d'un contact
	 * @author Yannick
	 */
	
	class modifierContact implements ActionListener
	{
		private JButton btnContact;

		public modifierContact(JButton btnContact) 
		{
			this.btnContact = btnContact;
		}

		public void actionPerformed(ActionEvent e) 
		{
			  north.add(text);
			  north.add(ajout);
			  add(north,BorderLayout.NORTH);
			  
			  modify(btnContact);
			  serializeObject();
			  afficheContact();
			
			  CardLayoutContact.show(base, listContent[0]);
		}
	}
	
	/**
	 * Création du Listener de suppression d'un contact
	 * @author Yannick
	 */
	
	class delContact implements ActionListener
	{
		private JButton btnContact;
		
		public delContact(JButton btnContact) 
		{
			this.btnContact = btnContact;
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			north.removeAll();
			north.add(text);
			north.add(ajout);
			add(north,BorderLayout.NORTH);
			delete(btnContact);
			
			afficheContact();
			CardLayoutContact.show(base, listContent[0]);
		}
	}
	
	/**
	 * Création de la méthode getID qui retourne l'id du bouton contact
	 * @author Yannick
	 */

	public int getID( JButton contact) {
		return Integer.parseInt(contact.getName());
	}
	
	/**
	 * Création de la méthode modify
	 * @author Yannick
	 */
	
	public void modify(JButton contact) {
		 
		contacts.get(getID(contact)).setNom(nom.getText());
		contacts.get(getID(contact)).setPrenom(prenom.getText());
		contacts.get(getID(contact)).setAdresse(adresse.getText());
		contacts.get(getID(contact)).setTelephone(numero.getText());
		contacts.get(getID(contact)).setMail(mail.getText());
		contacts.get(getID(contact)).setcheminImage(photoProfil.CheminImage);
		serializeObject();
		
		nom.setText("");
		prenom.setText("");
		numero.setText("");
		adresse.setText("");
		mail.setText("");
		photo.setText("");
		
	}
	
	/**
	 * Création de la méthode delete 
	 * @author Yannick
	 */
	
	public void delete(JButton contact) {
		
		contacts.remove(getID(contact));
		serializeObject();
		
	}

	   /**
	    * Création de la méthode serilaizeObject qui écrit dans un fichier
	    * @author Yannick
	    */
	
		public void serializeObject() 
		{
			try 
			{
				FileOutputStream FichierContact = new FileOutputStream("Serialize/contact.ser");
				ObjectOutputStream OutputContact = new ObjectOutputStream(FichierContact);
				OutputContact.writeObject(contacts);
				OutputContact.flush();
				OutputContact.close();
				FichierContact.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		/**
		 * Création de la méthode deSerializeObject qui permet de lire dans le fichier
		 * @author Yannick
		 */
		
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
		
		/**
		 * Création de la classe buttonOk qui valide la création d'un contact 
		 * @author Yannick
		 */
		
class buttonok extends JButton implements ActionListener {
    
  panelContact pc;

	buttonok(panelContact pc)
	{
		this.pc=pc;
		Icon valide = new ImageIcon("images/validate.png");
		setIcon(valide);
		addActionListener(this);
		setFocusPainted(false);
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		pc.north.add(pc.text);
		pc.north.add(pc.ajout);
		pc.add(pc.north,BorderLayout.NORTH);
		pc.contacts.add(new Contact(pc.nom.getText(), pc.prenom.getText(), pc.numero.getText(), pc.adresse.getText(), pc.mail.getText(),pc.photo.getText()));
		serializeObject();
		pc.afficheContact();	
		nom.setText("");
		prenom.setText("");
		numero.setText("");
		adresse.setText("");
		mail.setText("");
		photo.setText("");
	
	}
	}

	/**
	 * Création de la méthode setLienImage
	 * @author Yannick
	 */

	public void setLienImage(String lienImage) {
		this.lienImage = lienImage;
	}
}
	
