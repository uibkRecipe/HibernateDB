package persistent.junitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import persistent.hibernateManager.HibernateUtil;
/**
 * 
 * @author mirko
 *
 */
public class HibernateUtilJUnitTest {
	HibernateUtil hm = HibernateUtil.getInstance();
	@Test
	/**
	 * This test check if we using a false password if it yields a null object
	 */
	public void falsePassword() {
		
		assertTrue(hm.logIn("mirko", "thomas") == null);
		
	}
	
	@Test
	/**
	 * This test check if a non existent User yields a null object
	 */
	public void notExistentUser() {
		
		assertTrue(hm.logIn("maria", "ciao") == null);
		
	}
	
	
	
	
}
