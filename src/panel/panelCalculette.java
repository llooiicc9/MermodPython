package panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import bouton.btnBase;
  
public class panelCalculette extends JPanel {
	
  private JPanel container = new JPanel(new BorderLayout());
  
  //Tableau stockant les éléments à afficher dans la calculatrice
  
  String[] tab_string = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "=", "C", "+", "-", "*", "/"};
  
  //tableau de bouton de la même taille que le nombre d'élément
  JButton[] tab_button = new JButton[tab_string.length];
  private JLabel ecran = new JLabel();
  //deux dimensions différentes selon les boutons pour l'affichage
  private Dimension dim = new Dimension(50, 40);
  private Dimension dim2 = new Dimension(50, 31);
  //variables qui seront utilisées lors des calculs
  private double chiffre1;
  private boolean clicOperateur = false, update = false;
  private String operateur = "";
  
  public panelCalculette(){
  
	  //création des composants
	 initComposant();
	  
    this.add(container);
    this.setVisible(true);
  }
      
  private void initComposant(){
    //On définit la police d'écriture à utiliser pour l'affichage du résultat
    Font police = new Font("Arial", Font.BOLD, 90);
    //on initialise l'écran a 0
    ecran = new JLabel("0");
    ecran.setFont(police);
    ecran.setForeground(Color.BLACK);
    //On aligne les informations à droite dans le JLabel
    ecran.setHorizontalAlignment(JLabel.RIGHT);
    JPanel operateur = new JPanel();      
    operateur.setPreferredSize(new Dimension(50, 440));
    JPanel chiffre = new JPanel();
    chiffre.setPreferredSize(new Dimension(165, 450));
    JPanel panEcran = new JPanel();
    panEcran.setPreferredSize(new Dimension(400, 120));
    panEcran.setBackground(Color.WHITE);
    
    
    
    //création des boutons personnalisés
    tab_button[0]=new btnBase("images/one.png");
    tab_button[1]=new btnBase("images/two.png");
    tab_button[2]=new btnBase("images/three.png");
    tab_button[3]=new btnBase("images/four.png");
    tab_button[4]=new btnBase("images/five.png");
    tab_button[5]=new btnBase("images/six.png");
    tab_button[6]=new btnBase("images/seven.png");
    tab_button[7]=new btnBase("images/eight.png");
    tab_button[8]=new btnBase("images/nine.png");
    tab_button[9]=new btnBase("images/zero.png");
    tab_button[10]=new btnBase("images/dot.png");
    tab_button[11]=new btnBase("images/equal.png");
    tab_button[12]=new btnBase("images/clear.png");
    tab_button[13]=new btnBase("images/plus.png");
    tab_button[14]=new btnBase("images/minus.png");
    tab_button[15]=new btnBase("images/multiply.png");
    tab_button[16]=new btnBase("images/division.png");
    
    //donne un nom au bouton afin de pouvoir le récupérer et effectuer des calculs
    for(int i=0;i<9;i++) {
    	int a=i+1;
    	tab_button[i].setName(""+a);
    }
    tab_button[9].setName(""+0);
    tab_button[10].setName(".");


    //On parcourt le tableau avec un switch pour ajouter les listener
    for(int i = 0; i < tab_string.length; i++){
      tab_button[i].setPreferredSize(dim);
      switch(i){
        //Pour chaque élément situé à la fin du tableau
        //et qui n'est pas un chiffre
        //on définit le comportement à avoir grâce à un listener
        case 11 :
          tab_button[i].addActionListener(new EgalListener());
          chiffre.add(tab_button[i]);
          break;
        case 12 :
          tab_button[i].setForeground(Color.red);
          tab_button[i].addActionListener(new ResetListener());
          operateur.add(tab_button[i]);
          break;
        case 13 :
          tab_button[i].addActionListener(new PlusListener());
          tab_button[i].setPreferredSize(dim2);
          operateur.add(tab_button[i]);
          break;
        case 14 :
          tab_button[i].addActionListener(new MoinsListener());
          tab_button[i].setPreferredSize(dim2);
          operateur.add(tab_button[i]);
          break;	
        case 15 :	
          tab_button[i].addActionListener(new MultiListener());
          tab_button[i].setPreferredSize(dim2);
          operateur.add(tab_button[i]);
          break;
        case 16 :
          tab_button[i].addActionListener(new DivListener());
          tab_button[i].setPreferredSize(dim2);
          operateur.add(tab_button[i]);
          break;
        default :
          //Par défaut, ce sont les premiers éléments du tableau
          //donc des chiffres, on affecte alors le bon listener
          tab_button[i].addActionListener(new ChiffreListener());
          break;
      }
    }
    
    	operateur.setLayout(new GridBagLayout());
    	GridBagConstraints gc2 = new GridBagConstraints();
    	gc2.insets = new Insets(0,0,0,0);
    	
    	gc2.weightx=1;
    	gc2.weighty=5;
    	
    	gc2.gridy = 0;
    	gc2.gridx = 0;
    	operateur.add(tab_button[12], gc2);
    	
    	gc2.gridy = 1;
    	gc2.gridx = 0;
    	operateur.add(tab_button[13], gc2);
    	
    	gc2.gridy = 2;
    	gc2.gridx = 0;
    	operateur.add(tab_button[14], gc2);
    	
    	gc2.gridy = 3;
    	gc2.gridx = 0;
    	operateur.add(tab_button[15], gc2);
    	
    	gc2.gridy = 4;
    	gc2.gridx = 0;
    	operateur.add(tab_button[16], gc2);
    	
    	
    	
 	    chiffre.setLayout(new GridBagLayout());
 	    //Le gridBagConstraints va définir la position et la taille des éléments 
 		GridBagConstraints gc = new GridBagConstraints();
 		gc.fill = GridBagConstraints.BOTH;
 		//insets définir la marge entre les composant new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite)
 		gc.insets = new Insets(0, 0, 0, 0);
 		
 		//Défini les case en x et y
 		gc.weightx = 3;
 		gc.weighty = 4;
 		
 		gc.gridy = 0;
 		gc.gridx = 0;
 		chiffre.add(tab_button[0], gc);
 		
 		gc.gridy = 0;
 		gc.gridx = 1;
 		chiffre.add(tab_button[1], gc);
 		
 		gc.gridy = 0;
 		gc.gridx = 2;
 		chiffre.add(tab_button[2], gc);
 		
 		gc.gridy = 1;
 		gc.gridx = 0;
 		chiffre.add(tab_button[3], gc);
 		
 		gc.gridy = 1;
 		gc.gridx = 1;
 		chiffre.add(tab_button[4], gc);
 		
 		gc.gridy = 1;
 		gc.gridx = 2;
 		chiffre.add(tab_button[5], gc);
 		
 		gc.gridy = 2;
 		gc.gridx = 0;
 		chiffre.add(tab_button[6], gc);
 		
 		gc.gridy = 2;
 		gc.gridx = 1;
 		chiffre.add(tab_button[7], gc);
 		
 		gc.gridy = 2;
 		gc.gridx = 2;
 		chiffre.add(tab_button[8], gc);
 		
 		gc.gridy = 3;
 		gc.gridx = 0;
 		chiffre.add(tab_button[9], gc);
 		
 		gc.gridy = 3;
 		gc.gridx = 1;
 		chiffre.add(tab_button[10], gc);
 		
 		gc.gridy = 3;
 		gc.gridx = 2;
 		chiffre.add(tab_button[11], gc);
 		
    panEcran.add(ecran,BorderLayout.NORTH);
    panEcran.setBorder(BorderFactory.createLineBorder(Color.black));
    container.add(panEcran, BorderLayout.NORTH);
    container.add(chiffre, BorderLayout.CENTER);
    container.add(operateur, BorderLayout.EAST);
  }

  //Méthode permettant d'effectuer un calcul selon l'opérateur sélectionné
  private void calcul(){
    if(operateur.equals("+")){
      chiffre1 = chiffre1 + 
            Double.valueOf(ecran.getText()).doubleValue();
      ecran.setText(String.valueOf(chiffre1));
    }
    if(operateur.equals("-")){
      chiffre1 = chiffre1 - 
            Double.valueOf(ecran.getText()).doubleValue();
      ecran.setText(String.valueOf(chiffre1));
    }          
    if(operateur.equals("*")){
      chiffre1 = chiffre1 * 
            Double.valueOf(ecran.getText()).doubleValue();
      ecran.setText(String.valueOf(chiffre1));
    }     
    if(operateur.equals("/")){
      try{
        chiffre1 = chiffre1 / 
              Double.valueOf(ecran.getText()).doubleValue();
        ecran.setText(String.valueOf(chiffre1));
      } catch(ArithmeticException e) {
        ecran.setText("0");
      }
    }
  }

  //Listener utilisé pour les chiffres
  //Permet de stocker les chiffres et de les afficher
  class ChiffreListener implements ActionListener {
    public void actionPerformed(ActionEvent e){
      //On affiche le chiffre additionnel dans le label
      String str = ((JButton)e.getSource()).getName();
      if(update){
        update = false;
      }
      else{
        if(!ecran.getText().equals("0"))
          str = ecran.getText() + str;
      }
      ecran.setText(str);
    }
  }

  //Listener affecté au bouton =
  class EgalListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      calcul();
      update = true;
      clicOperateur = false;
    }
  }

  //Listener affecté au bouton +
  class PlusListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      if(clicOperateur){
        calcul();
        ecran.setText(String.valueOf(chiffre1));
      }
      else{
        chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
        clicOperateur = true;
      }
      operateur = "+";
      update = true;
    }
  }

  //Listener affecté au bouton -
  class MoinsListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      if(clicOperateur){
        calcul();
        ecran.setText(String.valueOf(chiffre1));
      }
      else{
        chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
        clicOperateur = true;
      }
      operateur = "-";
      update = true;
    }
  }

  //Listener affecté au bouton *
  class MultiListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      if(clicOperateur){
        calcul();
        ecran.setText(String.valueOf(chiffre1));
      }
      else{
        chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
        clicOperateur = true;
      }
      operateur = "*";
      update = true;
    }
  }

  //Listener affecté au bouton /
  class DivListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      if(clicOperateur){
        calcul();
        ecran.setText(String.valueOf(chiffre1));
      }
      else{
        chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
        clicOperateur = true;
      }
      operateur = "/";
      update = true;
    }
  }

  //Listener affecté au bouton de remise à zéro
  class ResetListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      clicOperateur = false;
      update = true;
      chiffre1 = 0;
      operateur = "";
      ecran.setText("");
    }
  }      
}

