package panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
	
	
	public panelHaut() {
		
		setLayout(new BorderLayout());
		setBackground(Color.black);
		
		timerHeure.start();

		lblHeure.setHorizontalAlignment(JLabel.CENTER);
		lblHeure.setForeground(Color.WHITE);
		lblHeure.setFont(new Font("Arial", Font.BOLD, 20));
		reseau.setForeground(Color.WHITE);
		reseau.setFont(new Font("Arial", Font.BOLD,20));
		add(lblHeure, BorderLayout.CENTER);
		add(reseau, BorderLayout.WEST);
	
		
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

