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

public class panelImage extends JPanel 
{
	private JPanel gridPanel = new JPanel(new GridLayout(0, 3, 7, 7));
	private JButton btnAdd = new JButton("Add");
	private String chemin="images/Gallerie";
	
	public panelImage() 
	{
		setLayout(new BorderLayout());
		
		afficheImage();
		
		add(btnAdd, BorderLayout.NORTH);
		add(gridPanel, BorderLayout.CENTER);
		
		btnAdd.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent event){				
			   
		        addImage();
		      }
	        });

	}

	public void afficheImage()
	{
		JButton vignette;

		File dossiertest= new File(chemin);		
		
		if(dossiertest.isDirectory())
		{
			System.out.println("Nombre de photo dans la galerie : "+dossiertest.list().length);
			File list[] = dossiertest.listFiles();
			for (int i = 0; i < list.length; i++) 
			{
				System.out.println(list[i].getName());
				vignette = new btnBase("images/Gallerie/"+list[i].getName());
				gridPanel.add(vignette);
			}
		
		}
		/*for (Photo photo : photos) 
		{
			vignette = new btnBase("images/Gallerie/photo1.jpg");
			//vignette.addActionListener(new PhotoClick(photo));
			gridPanel.add(vignette);
			//photoDetail = new PhotoDetail(photo);
			//contentPanelPhoto.add(photoDetail, "" + photos.indexOf(photo));
		}*/
	}
	
	public void addImage()
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Open Resource File");
		 
		 FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "JPG & GIF Images", "jpg", "gif","png");
		 fileChooser.setFileFilter(filter);
			    int returnVal = fileChooser.showOpenDialog(null);
		
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       System.out.println("Ajout du fichier : " + fileChooser.getSelectedFile().getName());
			     
			 
			       Path cheminBase = Paths.get(fileChooser.getSelectedFile().getPath());
			       Path cheminOuEnregistrer = Paths.get(chemin+"/"+fileChooser.getSelectedFile().getName());
				   
					try {
						Files.copy(cheminBase, cheminOuEnregistrer, StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
		
			    }
	}
	
}
