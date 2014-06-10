package persistent.junitTest;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import persistent.hibernateManager.HibernateUtil;

public class UserManagerTest extends PersistentManagerTest {
	
	@BeforeClass
	public static void setUp() throws Exception{
		HibernateUtil.getInstance().setUserAsActive("TEST_ACTIVE_USER");
		HibernateUtil.getInstance().setUserAsNotActive("TEST_NOT_ACTIVE_USER");
		HibernateUtil.getInstance().setUserAsActive("mirko");
	}
	
	@Test
	public void logIn(){
		//Correct data --> return User
		assertTrue(hm.logIn("mirko","ciao") != null);
		//False Password --> return null
		assertTrue(hm.logIn("mirko", "falsePassword") == null);
		//False Username --> return null
		assertTrue(hm.logIn("notExistingUserName123", "password") == null);
		//False inactive user --> return null
		assertTrue(hm.logIn("TEST_NOT_ACTIVE_USER", "test") == null);
	}
	
	@Test
	public void ActiveInactiveTest(){
		assertTrue(hm.logIn("TEST_NOT_ACTIVE_USER", "test") == null);
		assertTrue(hm.logIn("TEST_ACTIVE_USER", "test") != null);
		hm.setUserAsNotActive("TEST_ACTIVE_USER");
		hm.setUserAsActive("TEST_NOT_ACTIVE_USER");
		assertTrue(hm.logIn("TEST_NOT_ACTIVE_USER", "test") != null);
		assertTrue(hm.logIn("TEST_ACTIVE_USER", "test") == null);
	}
	
	@Test
	public void changePassword(){
		assertTrue(hm.changePassword("testUser1", "test", "test1", "test1"));
		assertTrue(hm.changePassword("testUser1", "test1", "test", "test"));
	}
	
	@AfterClass
	public static void finish(){
		HibernateUtil.getInstance().setUserAsActive("testUser");
	
	}
}
