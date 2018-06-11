package panel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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


// mettre en mode avion ! 


public class panelSettings extends JPanel {

	Font police = new Font("Arial",Font.ROMAN_BASELINE,30);
	JLabel fond = new JLabel("Fond d'écran");
	JLabel modeAvion = new JLabel("Mode Avion");
	btnBase photo = new btnBase("images/Images.png");
	btnBase valide = new btnBase("images/turn.png");
	JPanel pane = new JPanel();
	panelImage gallerie = new panelImage();
	String[] listContent = {"liste","gallerie"};
	CardLayout CardLayoutSettings = new CardLayout();
	JPanel content = new JPanel();
	private boolean avion = false;
	
	public panelSettings() {
		
		fond.setFont(police);
		modeAvion.setFont(police);
		pane.setLayout(new GridLayout(2,2));
		pane.add(fond);
		pane.add(photo);
		pane.add(modeAvion);
		pane.add(valide);
		
		add(pane);
		
		
		photo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			
				gallerie.afficheImage();
				
				//CardLayoutSettings.show(content, listContent[1]);
				
				
				/*gallerie.btnContact.addActionListener(new ActionListener(){
					   public void actionPerformed(ActionEvent event){	
						   	photo.setText(gallerie.getImageContact());*/
			}

		
		});
		
	}
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
     	    //On récupère l'heure actuel en milisec pour avoir un nom unique pour chaque photo
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		
    		//Récupère le chemin de l'image choisie
     		Path cheminBase = Paths.get(fileChooser.getSelectedFile().getPath());
    		Path cheminOuEnregistrer = Paths.get(chemin+"/"+timestamp.getTime()+fileChooser.getSelectedFile().getName());
		   
			try {
				//Copie l'image sélectionner dans la gallerie du smartphone
				Files.copy(cheminBase, cheminOuEnregistrer, StandardCopyOption.REPLACE_EXISTING);
				afficheImage();
			} catch (IOException e) {
				e.printStackTrace();
			}	
	    }
	}
	
}
