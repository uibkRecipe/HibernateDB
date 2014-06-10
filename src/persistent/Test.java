package persistent;

import java.util.List;

import persistent.classes.City;
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
		City c = hm.findCityByName("Bolzano").get(0);
		User u = new User("mirko", "ciao", "mirko@hello.gmail.com", c.getID(), c.getCountry());
		hm.addUser(u);
		hm.closeSession();
	}
}