package persistent;

import java.util.List;

import persistent.classes.City;
import persistent.classes.IngredientType;
import persistent.classes.Region;
import persistent.classes.User;
import persistent.hibernateManager.HibernateUtil;


public class Test {
	
	/**
	 * Use mock for the DB test
	 * @param args
	 */
	public static void main(String[] args) {
	
	
		HibernateUtil hm = HibernateUtil.getInstance();
		User u = new User("mirko", "ciao", "sad", hm.findCityByName("Bolzano").get(0));
		
			System.out.println(hm.addUser(u));
		
		hm.closeSession();
	}
}