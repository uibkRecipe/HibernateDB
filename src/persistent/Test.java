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
		
		System.out.println(hm.logIn("mirko", "ciao"));;
		
		
		hm.closeSession();
	}
}