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
 * Auteur : Python Lo�c <br/>
 * Extention de la classe : JPanel <br/>
 * Description de la classe : Ce panel est utiliser pour pour d�finir de base les panel en trasparent 	  <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Entr�e(s) : - <br/>
 * Sortie : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Remarque : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 */
public class panelBase extends JPanel {
	
	/**
	 Constructeur de panelBase
	 * @author Lo�c
	 */
	public panelBase() {
		setOpaque(false);
	}
	

}
