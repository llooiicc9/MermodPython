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



public class panelHaut extends JPanel {
	
	private JLabel lblHeure = new JLabel();
	private DateFormat FormatHeure = new SimpleDateFormat("HH:mm");
	private Timer timerHeure = new Timer(0, new CurrentTime());
	private JLabel reseau = new JLabel("Swisscom 4G");
	private JButton hp = new btnBase("images/top.png");
	private Icon batery = new ImageIcon("images/battery.png");
	private JLabel battery = new JLabel();
	private JPanel a = new JPanel();
	
	
	public panelHaut() {
		
		setLayout(new GridLayout(1,3));
		setBackground(Color.black);
		battery.setIcon(batery);
		a.setLayout(new BorderLayout());
		a.add(battery,BorderLayout.EAST);
		a.setBackground(Color.BLACK);
		
		timerHeure.start();

		lblHeure.setHorizontalAlignment(JLabel.CENTER);
		lblHeure.setForeground(Color.WHITE);
		lblHeure.setFont(new Font("Arial", Font.BOLD, 23));
		reseau.setForeground(Color.WHITE);
		reseau.setFont(new Font("Arial", Font.BOLD,23));
		add(reseau);
		add(lblHeure);
		add(a, BorderLayout.EAST);
		
	
		
	}

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

