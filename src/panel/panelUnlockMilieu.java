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

public class panelUnlockMilieu extends JPanel 
{
	public btnUnlock btnunlock= new btnUnlock();
	private JPanel haut = new JPanel();
	private JPanel bas = new JPanel();
	
	
	private JLabel date = new JLabel();
	private DateFormat FormatDate = new SimpleDateFormat("EEEE dd MMM");
	private Timer timerDate = new Timer(0, new CurrentDate());
	
	public panelUnlockMilieu() 
	{
		// Heure		
						//Date maDate = new Date(); 
		bas.setOpaque(false);
		haut.setOpaque(false);
	
						//lblHeure.setText(maDate.getHours()+" : "+maDate.getMinutes());
		
		
		timerDate.start();
		add(date, BorderLayout.SOUTH);
		date.setHorizontalAlignment(JLabel.CENTER);
		date.setForeground(Color.WHITE);
		date.setFont(new Font("Montserrat", Font.BOLD, 30));
		
		//Boutton
		setLayout(new BorderLayout());
		add(bas);
		bas.setLayout(new BorderLayout());
		btnunlock.setBorder(new EmptyBorder(0, 0, 30, 0));
		
		//add(backgroundImage);
		add(date,BorderLayout.NORTH);
		add(btnunlock,BorderLayout.SOUTH);	

	}
	
	
	class CurrentDate implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Calendar now = Calendar.getInstance();
			date.setText(FormatDate.format(now.getTime()));
		}
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
