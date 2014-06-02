package persistent;

import java.util.List;

import persistent.classes.City;
import persistent.classes.Region;
import persistent.hibernateManager.HibernateManager;


public class Test {
	
	/**
	 * Use mock for the DB test
	 * @param args
	 */
	public static void main(String[] args) {
	
	
		HibernateManager hm = HibernateManager.getInstance();
	
		String code = hm.findCountryCodeByName("AUSTRIA");
		List<Region> region = hm.getRegionByCountryCode(code);
		
		System.out.println("" + region);
		List<City> c1 = hm.findCityByName("Innsbruck");
		List<City> c = hm.findCityNameByCountryAndRegion(code, c1.get(0).getRegion());
		System.out.println(c);
		hm.closeSession();
	}
}