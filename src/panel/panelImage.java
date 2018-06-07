package panel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
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
	private JButton btnAdd = new JButton("Add");
	private JButton btnRetour = new btnBase("images/Retour.png");
	private JButton btnDelete = new btnBase("images/delete.png");
	public JButton btnContact = new btnBase("images/contactImage.png");
	private String chemin="images/Gallerie";
	private String ImgDel ="";
	
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
		//JScrollPane scroll = new JScrollPane(gridPanelGallerie); -- si on veut mettre une scrollbar
		//On définit le layout
		panelContent.setLayout(CardLayoutGallerie);
		
	    //Permet de changer de panel
		panelContent.add(gridPanelGallerie, listContent[0]);
		panelContent.add(PanelImgAgrandie, listContent[1]);
	    
		setLayout(new BorderLayout());
		
		afficheImage();
		
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
			System.out.println("Nombre de photos dans la galerie : "+dossiertest.list().length);
			File list[] = dossiertest.listFiles();
			for (int i = 0; i < list.length; i++) 
			{
				//System.out.println(list[i].getName());
			
				imageGallerie = new btnBase(chemin+"/"+list[i].getName());
				imageGallerie.addActionListener(new AgrandirImg(imageGallerie));
				gridPanelGallerie.add(imageGallerie);
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
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Ajouter une image");
		 
		//Choisis les extensions autorisée
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG , GIF et PNG", "jpg", "gif","png");
		fileChooser.setFileFilter(filter);
		 
	    int returnVal = fileChooser.showOpenDialog(null);

	    if(returnVal == JFileChooser.APPROVE_OPTION) 
	    { 
    		System.out.println("Ajout du fichier : " + fileChooser.getSelectedFile().getName());
     	    		
     		Path cheminBase = Paths.get(fileChooser.getSelectedFile().getPath());
    		Path cheminOuEnregistrer = Paths.get(chemin+"/"+fileChooser.getSelectedFile().getName());
		   
			try {
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
			PanelImgAgrandie.add(imageAagrandir,BorderLayout.CENTER);
			PanelImgAgrandie.add(btnRetour,BorderLayout.SOUTH);
			PanelImgAgrandie.add(btnDelete,BorderLayout.SOUTH);
			if (nomContact!="") 
			{
				PanelImgAgrandie.add(btnContact,BorderLayout.SOUTH);
			}

			
			CardLayoutGallerie.next(panelContent);
		}
	}

	
}
