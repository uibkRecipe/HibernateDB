package persistent.junitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import persistent.hibernateManager.HibernateManager;
/**
 * 
 * @author mirko
 *
 */
public class HibernateUtilJUnitTest {
	HibernateManager hm = HibernateManager.getInstance();
	@Test
	public void falsePassword() {
		
		assertTrue(hm.logIn("mirko", "thomas") == null);
		
	}
	
	@Test
	public void notExistentUser() {
		
		assertTrue(hm.logIn("maria", "ciao") == null);
		
	}
	
	
	@Test 
	public void twoSameCityTest(){
		assertEquals(hm.findCityByName("Bolzano").get(0), hm.findCityByName("Bozen").get(0));
	}
	
	
	
}
