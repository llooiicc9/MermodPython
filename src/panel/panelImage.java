package panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import bouton.btnUnlock;

public class panelImage extends JPanel 
{
	public btnUnlock btnunlock= new btnUnlock();
	private JLabel lblHeure = new JLabel("Images");
	private JPanel haut = new JPanel();
	private JPanel bas = new JPanel();
	
	public panelImage() 
	{
		setLayout(new BorderLayout());
		add(lblHeure, BorderLayout.CENTER);
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
