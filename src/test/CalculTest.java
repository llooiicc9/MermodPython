package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Apps.Calcul;

/**
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Auteur : Python Loïc<br/>
 * Description de la classe : Test de la classe Calcul avec Junit. <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Entrée(s) : - <br/>
 * Sortie : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Remarque : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 */
public class CalculTest {
	protected Calcul test;

	@Before
	public void setUp() throws Exception {
		//Test de la déclaration de Calcul()
		test = new Calcul();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test 
	public void testAddition() throws Exception {
		test.operation( 10,"+", 5);
	}
	
	@Test
	public void testSoustraction() throws Exception {
		test.operation(10,"-", 5);
	}
	
	@Test
	public void testMultiplication() throws Exception {
		test.operation(10,"*", 5);
	}
	
	@Test
	public void testDivision() throws Exception {
		test.operation(10,"/", 0);
	}
	
	@Test
	public void testAutreSimbole() throws Exception {
		test.operation(10,"test", 55);
	}

}
