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

public class panelUnlockMilieu extends JPanel 
{
	public btnUnlock btnunlock= new btnUnlock();
	private JLabel lblHeure = new JLabel();
	private JPanel haut = new JPanel();
	private JPanel bas = new JPanel();
	
	public panelUnlockMilieu() 
	{
		// Heure		
		Date maDate = new Date(); 
		bas.setOpaque(false);
		haut.setOpaque(false);
	
		lblHeure.setText(maDate.getHours()+" : "+maDate.getMinutes());
		lblHeure.setHorizontalAlignment(JLabel.CENTER);
		lblHeure.setForeground(Color.BLACK);
		lblHeure.setFont(new Font("Arial", Font.BOLD, 70));
		
		//Boutton
		setLayout(new BorderLayout());
		add(bas);
		bas.setLayout(new BorderLayout());
		btnunlock.setBorder(new EmptyBorder(0, 0, 30, 0));
		
		//add(backgroundImage);
		add(lblHeure, BorderLayout.NORTH);
		add(btnunlock,BorderLayout.SOUTH);	

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
    	     System.out.println("ERREUR : le fond d'écran ne peut pas être chargé  ");
    	    }                
    }
}
