package persistent;

import persistent.classes.IngredientType;
import persistent.classes.RecipeIngredients;
import persistent.help.CO2Calculation;
import persistent.hibernateManager.HibernateUtil;


public class Test {
	
	/**
	 * Use mock for the DB test
	 * @param args
	 */
	public static void main(String[] args) {
	
		
		HibernateUtil hm = HibernateUtil.getInstance();
		
		System.out.println(CO2Calculation.getInstance().calculateCO2(3, "mirko").getDistance());
	
		hm.closeSession();
	}
}