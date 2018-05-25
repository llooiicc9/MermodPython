package panel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import bouton.btnBase;
import bouton.btnUnlock;

public class panelImage extends JPanel 
{
	private JPanel gridPanel = new JPanel(new GridLayout(0, 3, 7, 7));
	
	
	public panelImage() 
	{
		setLayout(new BorderLayout());
		
		afficheImage();
		
		add(gridPanel);

	}
	
	public void afficheImage()
	{
		JButton vignette;
		for (int i = 1; i <= 8; i++)  
		{
			vignette = new btnBase("images/Gallerie/photo"+i+".jpg");
			gridPanel.add(vignette);
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
	
	public void paintComponent(Graphics g)
    {
    		try 
    	    {
    	      Image img = ImageIO.read(new File("images/background.jpg"));
    	      //g.drawImage(img, 0, 0, this);
    	      //Pour une image de fond
    	     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    	    } catch (IOException e) {
    	     System.out.println("ERREUR : le fond d'écran ne peut pas être chargé ");
    	    }                
    }
}
