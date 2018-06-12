package Apps;

/**
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Auteur : Python Lo�c<br/>
 * Description de la classe : Fonction calcul pour la calculette et le Junit. <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Entr�e(s) : - <br/>
 * Sortie : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Remarque : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 */
public class Calcul {
	
	public Calcul() 
	{
		
	}
	
	/**
	 * G�re les calculs
	 * @author Lo�c
	 * @param chiffre1, op�rateur et chiffre 2
	 * @return r�sultats en double
	 */
	public double operation ( double chiffre1, String operateur, double chiffre2)
	{
		
		switch (operateur) {
		case "+":
			chiffre1 = chiffre1 + chiffre2;
			break;
		case "-":
			chiffre1 = chiffre1 - chiffre2;
			break;
		case "*":
			chiffre1 = chiffre1 * chiffre2;
			break;
		case "/":
			try{
		        chiffre1 = chiffre1 / chiffre2;
		        //En cas de division par 0 
		      } catch(ArithmeticException e) {
		    	  return 0;
		      }
			break;

		default:
			return 0;
		}
		    
		return chiffre1;
	}

	
	
	 

}
