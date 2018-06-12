package panel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import bouton.btnBase;

/**
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Classe : panelSettings <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Auteur : Python Loic et Mermod Yannick <br/>
 * Nom de la classe : panelSettings <br/>
 * Extension de la classe : JPanel <br/>
 * Description de la classe : Cette classe g�re l'application panelSettings . <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Entr�e(s) : - <br/>
 * Sortie : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Remarque : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 */

public class panelSettings extends JPanel {

	Font police = new Font("Arial",Font.ROMAN_BASELINE,20);
	JLabel fond = new JLabel("Fond d'�cran");
	JLabel applis = new JLabel("Infos sur les applis");
	public btnBase photo = new btnBase("images/Images.png");
	public btnBase application = new btnBase("images/search.png");
	JPanel pane = new JPanel();
	panelImage gallerie = new panelImage();
	String[] listContent = {"liste","gallerie"};
	CardLayout CardLayoutSettings = new CardLayout();
	JPanel content = new JPanel();
	private boolean avion = false;
	CardLayout reglage = new CardLayout();
	String[] list = {"affichage","Infos"};
	JPanel app = new JPanel();
	
	btnBase contact = new btnBase("images/Contacts.png");
	JLabel a = new JLabel("590 lignes de code");
	btnBase images = new btnBase("images/Images.png");
	JLabel b = new JLabel("267 lignes de code");
	btnBase calculette = new btnBase("images/calculator.png");
	JLabel c = new JLabel("391 lignes de code");
	
	btnBase retour = new btnBase("images/retour.png");
	
	JPanel base = new JPanel();
	
	/**
	 * Cr�ation du constructeur panelSettings
	 * @author Yannick
	 */
	
	public panelSettings() {
		
		fond.setFont(police);
		applis.setFont(police);
		pane.setLayout(new GridLayout(2,2));
		pane.add(fond);
		pane.add(photo);
		pane.add(applis);
		pane.add(application);
		
		base.setLayout(reglage);
		base.add(pane, list[0]);
		base.add(app,list[1]);
		
		add(base);
		
		/**
		 * Cr�ation du Listener application
		 * @author Yannick
		 */
		
		application.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				app.setLayout(new GridLayout(4,2));
				app.add(contact);
				a.setFont(police);
				app.add(a);
				app.add(images);
				app.add(b);
				b.setFont(police);
				app.add(calculette);
				c.setFont(police);
				app.add(c);
				app.add(retour);
				
				reglage.show(base, list[1]);
				
				
				retour.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event){				
						
						reglage.show(base, list[0]);
		      }
	        });	
			}
		});
		
		
	}
	
	/**
	 * Permet de changer le fond d'�cran du smartphone
	 * @author Lo�c
	 */
	public void changeBackground()
	{
		String nomBackground = "background.jpg";
		String chemin = "images/";
		//Appelle un fileChooser pour rechercher une image dans windows
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Changer le fond d'�cran");
		 
		//D�finis l'extension autoris�e
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG", "jpg");
		fileChooser.setFileFilter(filter);
	
		 
	    int returnVal = fileChooser.showOpenDialog(null);

	    if(returnVal == JFileChooser.APPROVE_OPTION) 
	    { 
    		
    		//R�cup�re le chemin de l'image choisie
     		Path cheminBase = Paths.get(fileChooser.getSelectedFile().getPath());
    		Path cheminOuEnregistrer = Paths.get(chemin+nomBackground);
		   
			try {
				//Copie l'image s�lectionner en tant que fond d'�cran
				Files.copy(cheminBase, cheminOuEnregistrer, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}	
	    }
	}
	
}
