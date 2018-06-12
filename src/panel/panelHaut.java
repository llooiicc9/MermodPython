package panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import bouton.btnBase;

/**
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Classe : panelHaut <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Auteur : Mermod Yannick <br/>
 * Nom de la classe : panelHaut <br/>
 * Extension de la classe : JPanel <br/>
 * Description de la classe : Cette classe gère le panel Haut du smartphone. <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Entrée(s) : - <br/>
 * Sortie : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Remarque : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 */

public class panelHaut extends JPanel {
	
	private JLabel lblHeure = new JLabel();
	private DateFormat FormatHeure = new SimpleDateFormat("HH:mm");
	private Timer timerHeure = new Timer(0, new CurrentTime());
	private JLabel reseau = new JLabel(" Swisscom 4G");
	private JButton hp = new btnBase("images/top.png");
	private Icon batery = new ImageIcon("images/battery.png");
	private JLabel battery = new JLabel();
	private JPanel a = new JPanel();
	private JPanel b = new JPanel();
	private JPanel c = new JPanel();
	private JPanel d = new JPanel(new GridLayout(1,3));
	
	
	/**
	 * Création du constructeur panelHaut
	 * @author Yannick
	 */
	
	public panelHaut() {
		
		setLayout(new BorderLayout());
		setBackground(Color.black);
		battery.setIcon(batery);
		a.setLayout(new BorderLayout());
		a.add(battery,BorderLayout.EAST);
		a.setBackground(Color.BLACK);
		
		timerHeure.start();

		lblHeure.setHorizontalAlignment(JLabel.CENTER);
		lblHeure.setForeground(Color.WHITE);
		lblHeure.setFont(new Font("Arial", Font.ROMAN_BASELINE, 20));
		reseau.setForeground(Color.WHITE);
		reseau.setFont(new Font("Arial", Font.ROMAN_BASELINE,20));
		
		b.setBackground(Color.BLACK);
		c.setBackground(Color.BLACK);
		d.add(reseau);
		d.add(lblHeure);
		d.add(a);
		d.setBackground(Color.BLACK);
		
		add(b,BorderLayout.WEST);
		add(c,BorderLayout.EAST);
		add(d,BorderLayout.CENTER);
		
	}

	/**
	 * Création du Listener CurrentTime
	 * @author Yannick
	 */
	
	class CurrentTime implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Calendar now = Calendar.getInstance();
			lblHeure.setText(FormatHeure.format(now.getTime()));
		}
	}
	
}

