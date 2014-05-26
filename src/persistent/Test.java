package persistent;

import java.util.ArrayList;

import persistent.classes.Category;
import persistent.classes.Rezept;
import persistent.classes.Zutaten;
import persistent.hibernateManager.HibernateManager;


public class Test {
	
	
	public static void main(String[] args) {
		
		Rezept r = new Rezept("mirko", "pasta alla matriciana", "CIAO", new ArrayList<Zutaten>(), Category.CO2NEUTRAL);
	
		HibernateManager hm = new HibernateManager();
		
		
		
		hm.closeSession();
	}
}