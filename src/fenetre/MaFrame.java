package fenetre;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import bouton.btnBase;
import bouton.btnUnlock;
import panel.panelBas;
import panel.panelContact;
import panel.panelHaut;
import panel.panelMenuMilieu;
import panel.panelUnlockMilieu;

//SMB
public class MaFrame extends JFrame 
{
	CardLayout cl = new CardLayout();
	JPanel content = new JPanel();
	String[] listContent = {"Lock", "Menu", "Contact","AjoutContact","Gallerie"};
	
	private panelHaut nord = new panelHaut();
	private panelBas sud = new panelBas();
	private panelUnlockMilieu milieu = new panelUnlockMilieu();
	private panelMenuMilieu Menu = new panelMenuMilieu();
	private panelContact contacts = new panelContact();
	

	public MaFrame()
	{
		super("");

	    //On définit le layout
	    content.setLayout(cl);
	    //Permet de changer de panel
	    content.add(milieu, listContent[0]);
	    content.add(Menu, listContent[1]);
	    content.add(contacts, listContent[2]);
	    //content.add(image, listContent[3]);
	    //content.add(image, listContent[4]);
	    
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setLocation(500, 200);

		
		add(nord,BorderLayout.NORTH);
		add(sud,BorderLayout.SOUTH);
		//add(milieu,BorderLayout.CENTER);
		
		setSize(638, 1050);
	    getContentPane().add(content, BorderLayout.CENTER);
	    setVisible(true);
		
	    //Passe de lock au menu principal
	    milieu.btnunlock.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent event){
	            //Via cette instruction, on passe au prochain conteneur de la pile
	            cl.next(content);
	          }
	        });
	    
	   //Lance l'application contacts
	   Menu.btnContacts.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent event){				
			   
		       cl.show(content, listContent[2]);
		        
				//setLayout(new BorderLayout());
				
				btnBase add = new btnBase("images/add.png");
				JLabel label = new JLabel("Tous les contacts");
				add.setBackground(Color.BLUE);
			
				
				contacts.add(label);
				contacts.add(add);
				setVisible(true);
				
				
				contacts.add.addActionListener(new ActionListener(){
					   public void actionPerformed(ActionEvent event){				
						   
						   cl.show(content, listContent[3]);
						    
					        JTextField nom = new JTextField("Nom");
					        JTextField prenom = new JTextField("Prénom");
					        JTextField numero = new JTextField("Numéro");
					        JTextField adresse = new JTextField("Adresse");
					        
					        contacts.add(nom);
					        contacts.add(prenom);
					        setVisible(true);
					        
					       
					        
					      }
				        });
				
		      }
	        });
	   
	   //Lance l'application gallerie
	   Menu.btnImage.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent event){				
			   
		       cl.show(content, listContent[4]);
		        
				//setLayout(new BorderLayout());
				
				btnBase add = new btnBase("images/add.png");
				JLabel ekcfslq = new JLabel("Est-ce que ça jouuuuue");
				
				
				
				

				
				
				setVisible(true);
				
				
				add.addActionListener(new ActionListener(){
					   public void actionPerformed(ActionEvent event){				
						   
						    
					        JTextField nom = new JTextField("Nom");
					        JTextField prenom = new JTextField("Prénom");
					        JTextField numero = new JTextField("Numéro");
					        JTextField adresse = new JTextField("Adresse");
					        
					       
					        
					      }
				        });
				
		      }
	        });
	   
	   
	   //Retour au menu
	   Menu.home.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent event){				
			   
		        cl.show(content, listContent[1]);
		      }
	        });
		
	
	}	


	
}


