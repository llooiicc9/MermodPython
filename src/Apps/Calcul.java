package Apps;


public class Calcul {
	
	public Calcul() {
	}
	
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
