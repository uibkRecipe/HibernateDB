package persistent;

import java.util.List;

import persistent.classes.Ort;
import persistent.hibernateManager.HibernateManager;


public class Test {
	
	private static void printList(List lo){
		for(int i = 0; i < lo.size(); i++){
			System.out.println(lo.get(i));
		}
	}
	
	
	public static void main(String[] args) {
		HibernateManager hm = new HibernateManager();
		List<Ort> ort = hm.findOrtByName("o");
		printList(ort);
	}
}