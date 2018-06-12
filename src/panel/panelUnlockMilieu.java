package panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
/**
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Auteur : Python Loïc - Mermod Yannick <br/>
 * Extention de la classe : JPanel <br/>
 * Description de la classe : Panel de base quand le smartphone est Lock <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Entrée(s) : - <br/>
 * Sortie : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Remarque : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 */
public class panelUnlockMilieu extends JPanel 
{
	public btnUnlock btnunlock= new btnUnlock();
	private JPanel haut = new JPanel();
	private JPanel bas = new JPanel();
	
	
	private JLabel date = new JLabel();
	private DateFormat FormatDate = new SimpleDateFormat("EEEE dd MMM");
	private Timer timerDate = new Timer(0, new CurrentDate());
	
	/**
	 Constructeur de panelUnlockMilieu
	 * @author Loïc
	 */
	public panelUnlockMilieu() 
	{	
		//Rend opaque les panel du haut et du bas		
		bas.setOpaque(false);
		haut.setOpaque(false);

		//Lance le le timer
		timerDate.start();
		date.setHorizontalAlignment(JLabel.CENTER);
		date.setForeground(Color.WHITE);
		date.setFont(new Font("Arial", Font.ROMAN_BASELINE, 50));
		
		setLayout(new BorderLayout());
		add(bas);
		bas.setLayout(new BorderLayout());
		btnunlock.setBorder(new EmptyBorder(0, 0, 30, 0));
		
		//Ajoute la date et le bouton pour dévérouiller au panel
		add(date,BorderLayout.NORTH);
		add(btnunlock,BorderLayout.SOUTH);	

	}
	
	/**
	 Classe qui récupère la date
	 * @author Loïc
	 */
	class CurrentDate implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Calendar now = Calendar.getInstance();
			date.setText(FormatDate.format(now.getTime()));
		}
	}
	
	/**
	 Applique un fond d'écran au smartphone
	 * @author Loïc
	 */
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
