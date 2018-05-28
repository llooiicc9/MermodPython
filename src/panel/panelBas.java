package panel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import bouton.btnBase;

public class panelBas extends JPanel {
	
	public JButton btnHome = new btnBase("images/Home.png");
	
	public panelBas() {
		setBackground(Color.black);
		add(btnHome);
		
	}

}
