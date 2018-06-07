package panel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import bouton.btnBase;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.border.Border;
 

public class panelBas extends JPanel {
	
	public JButton btnHome = new btnBase("images/Home.png");
	
	public panelBas() {
		
		add(btnHome);
		//setBorder(new RoundedBorder(Color.WHITE,100,100));
		setBackground(Color.BLACK);
		
	}

}


 
 
 
 class RoundedBorder implements Border {  
 
	private Color couleur;
	private int largeurArc;
	private int hauteurArc;
 
 
 
 
	public RoundedBorder(Color couleur, int largeurArc, int hauteurArc)  {
		this.couleur = couleur;
		this.largeurArc = largeurArc;
		this.hauteurArc = hauteurArc;
		
	}  
 
 
 
 
 
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)  {
        g.setColor(this.couleur);//ou une autre couleur que tu peux rendre paramétrable
        int adjustXY = 1;//pour ajuster le dessin en x et y
        int adjustWH = 2;//idem pour width et height
        //pour eviter les escalier sur l'arrondi
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawRoundRect(x+adjustXY, y+adjustXY, width-adjustWH, height-adjustWH, this.largeurArc, this.hauteurArc);
       
	}  
 
 
 
	public Insets getBorderInsets(Component c)  {  
		return new Insets(0,0,0,0); 
	}  
 
 
	public boolean isBorderOpaque()  {
		return true; 
	} 
 
}