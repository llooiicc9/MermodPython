package panel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import bouton.btnBase;


// mettre en mode avion ! 


public class panelSettings extends JPanel {

	Font police = new Font("Arial",Font.ROMAN_BASELINE,30);
	JLabel fond = new JLabel("Fond d'écran");
	JLabel modeAvion = new JLabel("Mode Avion");
	btnBase photo = new btnBase("images/Images.png");
	btnBase valide = new btnBase("images/turn.png");
	JPanel pane = new JPanel();
	panelImage gallerie = new panelImage();
	String[] listContent = {"liste","gallerie"};
	CardLayout CardLayoutSettings = new CardLayout();
	JPanel content = new JPanel();
	private boolean avion = false;
	
	public panelSettings() {
		
		fond.setFont(police);
		modeAvion.setFont(police);
		pane.setLayout(new GridLayout(2,2));
		pane.add(fond);
		pane.add(photo);
		pane.add(modeAvion);
		pane.add(valide);
		
		
		add(pane);
		
		
		photo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			
				gallerie.afficheImage();
				
				//CardLayoutSettings.show(content, listContent[1]);
				
				
				
				/*gallerie.btnContact.addActionListener(new ActionListener(){
					   public void actionPerformed(ActionEvent event){	
						   	photo.setText(gallerie.getImageContact());*/
			}

		
		});
		
	}
}
