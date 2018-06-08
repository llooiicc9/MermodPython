package panel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import bouton.btnBase;
import bouton.btnUnlock;

/**
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Auteur : Python Loïc<br/>
 * Extention de la classe : JPanel <br/>
 * Description de la classe : Ce panel gère la gallerie d'image. <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Entrée(s) : - <br/>
 * Sortie : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Remarque : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 */

public class panelImage extends JPanel 
{
	private JPanel gridPanelGallerie = new JPanel(new GridLayout(0, 3, 7, 7));
	private JPanel PanelImgAgrandie = new JPanel();
	private JButton btnAdd = new btnBase("images/addPicture.png");
	private JButton btnRetour = new btnBase("images/Retour.png");
	private JButton btnDelete = new btnBase("images/delete.png");
	public JButton btnContact = new btnBase("images/contactImage.png");
	private String chemin="images/Gallerie";
	private String ImgDel ="";
	private int tailleVerticaleGallerie=0;
	
	public String nomContact="";
	
	CardLayout CardLayoutGallerie = new CardLayout();
	JPanel panelContent = new JPanel();
	String[] listContent = {"gallerie", "imgAgrandie"};
	
	/**
	 * Constructeur panelImage
	 * @param mainFrame
	 * @author Loïc
	 */
	public panelImage() 
	{		
		//On définit le cardLayout pour passé de la gallerie a une image seul
		panelContent.setLayout(CardLayoutGallerie);
		
		//Défini le flowLayout pour la gallerie
		FlowLayout flGallerie = new FlowLayout( FlowLayout.LEFT, 2, 2 );
		
		//Défini la taille de la gallerie
		gridPanelGallerie.setLayout(flGallerie);
		
	    //Ajoute une scroll bar à la gallerie
		JScrollPane scroll = new JScrollPane(gridPanelGallerie, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // si on veut mettre une scrollbar
		
		//Permet de changer de panel
		panelContent.add(scroll, listContent[0]);
		panelContent.add(PanelImgAgrandie, listContent[1]);
	    
		afficheImage();
		
		setLayout(new BorderLayout());
		add(btnAdd, BorderLayout.NORTH);
		add(panelContent, BorderLayout.CENTER);
		
		btnAdd.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent event){						   
		        addImage();
		        CardLayoutGallerie.next(panelContent);
				CardLayoutGallerie.show(panelContent, listContent[0]);
		      }
	        });
		
		btnDelete.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent event){						   
			        delImage();
			        afficheImage();
					CardLayoutGallerie.next(panelContent);
			      }
		        });

		
		btnRetour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){				
				afficheImage();
				CardLayoutGallerie.show(panelContent, listContent[0]);
			}
		});

	}

	/**
	 Affiche les images au panel
	 * @author Loïc
	 *
	 */
	public void afficheImage()
	{
		btnBase imageGallerie;
		gridPanelGallerie.removeAll();

		File dossiertest= new File(chemin);		
		
		if(dossiertest.isDirectory())
		{
			
			File list[] = dossiertest.listFiles();
			
			//Remet a 0 la taille de la gallerie
			tailleVerticaleGallerie=0;
			for (int i = 0; i < list.length; i++) 
			{				
				imageGallerie = new btnBase(chemin+"/"+list[i].getName());
				//Définis la taille souhaitée au cas ou une image est trop grande cela la redimensionne
				imageGallerie.setPreferredSize(new Dimension(140, 140));
				//Ajoute l'actionListener qui permet d'agrandire au images
				imageGallerie.addActionListener(new AgrandirImg(imageGallerie));
				gridPanelGallerie.add(imageGallerie);
				
				//Chaque 3 image ont augemente la taille de la gallerie
				if (i%3==0) {
					tailleVerticaleGallerie+=140;
					gridPanelGallerie.setPreferredSize(new Dimension(400, tailleVerticaleGallerie));
				}
			}
		
		}
	}
	
	/**
	 Ajoute une image dans le dossier prévu a cette effet
	 * @author Loïc
	 *
	 */
	public void addImage()
	{
		//Appelle un fileChooser pour rechercher une image dans windows
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Ajouter une image");
		 
		//Choisis les extensions autorisée
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG , GIF et PNG", "jpg", "gif","png");
		fileChooser.setFileFilter(filter);
		 
	    int returnVal = fileChooser.showOpenDialog(null);

	    if(returnVal == JFileChooser.APPROVE_OPTION) 
	    { 
    		System.out.println("Ajout du fichier : " + fileChooser.getSelectedFile().getName());
     	    
    		//Récupère le chemin de l'image choisie
     		Path cheminBase = Paths.get(fileChooser.getSelectedFile().getPath());
    		Path cheminOuEnregistrer = Paths.get(chemin+"/"+fileChooser.getSelectedFile().getName());
		   
			try {
				//Copie l'image sélectionner dans la gallerie du smartphone
				Files.copy(cheminBase, cheminOuEnregistrer, StandardCopyOption.REPLACE_EXISTING);
				afficheImage();
				
			} catch (IOException e) {
				e.printStackTrace();
			}	
	    }
	}
	
	/**
	Suppression de l'image
	 * @author Loïc
	 *
	 */
	public void delImage()
	{
		File monFichier = new File(ImgDel);
		monFichier.delete();
	}
	
	/**
	Retourne le chemin de l'image choisie au contact
	 * @author Loïc
	 *
	 */
	public String getImageContact()
	{
		return ImgDel;
	}
	
	/**
	 Quand on clique sur une image ça l'agrandit
	 * @author Loïc
	 *
	 */
	class AgrandirImg implements ActionListener
	{
		private btnBase imageAagrandir;

		public AgrandirImg(btnBase imageAagrandir) 
		{
			this.imageAagrandir = imageAagrandir;
		}

		public void actionPerformed(ActionEvent e) 
		{
			//Defini le chemin de l'image à supprimer
			ImgDel = imageAagrandir.CheminImage;
			
			//Remet a 0 le panel
			PanelImgAgrandie.removeAll();
			imageAagrandir.setPreferredSize(new Dimension(450, 500));
			PanelImgAgrandie.add(imageAagrandir,BorderLayout.CENTER);
			PanelImgAgrandie.add(btnRetour,BorderLayout.SOUTH);
			PanelImgAgrandie.add(btnDelete,BorderLayout.SOUTH);
			
			//Ajoute le bouton contact quand l'utilisateur vient de l'app contact
			if (nomContact!="") 
			{
				PanelImgAgrandie.add(btnContact,BorderLayout.SOUTH);
				
				btnContact.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event){				
						afficheImage();
						CardLayoutGallerie.show(panelContent, listContent[0]);
					}
				});
			}

			//Affiche la panel avec une seul image
			CardLayoutGallerie.show(panelContent, listContent[1]);
		}
	}

	
}
