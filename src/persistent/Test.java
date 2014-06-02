package persistent;

import java.util.List;

import persistent.classes.City;
import persistent.classes.Region;
import persistent.hibernateManager.HibernateManager;


public class Test {
	
	
	public static void main(String[] args) {
	
	
		HibernateManager hm = new HibernateManager();
	
		String code = hm.findCountryCodeByName("Jamaica");
		List<Region> region = hm.getRegionByCountryCode(code);
		
		System.out.println("" + region);
		List<City> c = hm.findCityNameByCountryAndRegion(code, region.get(0).getCode());
		System.out.println(c);
		hm.closeSession();
	}
}