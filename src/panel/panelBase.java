package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Auteur : Python Loïc <br/>
 * Extention de la classe : JPanel <br/>
 * Description de la classe : Ce panel est utiliser pour pour définir de base les panel en trasparent 	  <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Entrée(s) : - <br/>
 * Sortie : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Remarque : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 */
public class panelBase extends JPanel {
	
	/**
	 Constructeur de panelBase
	 * @author Loïc
	 */
	public panelBase() {
		setOpaque(false);
	}
	

}
