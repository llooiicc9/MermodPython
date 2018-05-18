package fenetre;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MonDialog extends JDialog 
{
	private JPanel panel_Sud = new JPanel();
	private JLabel lblTextRecu= new JLabel("...");
	private JButton btnRenvoyer = new JButton("Changer text");
	
	public MonDialog(String valeur) 
	{		
		setValeur(valeur);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		panel_Sud.add(lblTextRecu);	
		add(panel_Sud,BorderLayout.SOUTH);
		add(btnRenvoyer, BorderLayout.NORTH);
		pack();

	}
	
	public void setValeur(String valeur)
	{
		lblTextRecu.setText(valeur);
	}
	
	
	
}
