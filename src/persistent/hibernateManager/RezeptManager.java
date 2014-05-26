package persistent.hibernateManager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistent.classes.Category;
import persistent.classes.Rezept;
import Interfaces.RezeptInterface;

public class RezeptManager extends PersistentManager implements RezeptInterface{
	public RezeptManager(Session session){
		super(session);
	}
	
	/**
	 * Add a Recipe in the DB.
	 * @param r the recipe to add
	 * @return true on success; false otherwise;
	 */
	public boolean addRezept(Rezept r){
		boolean ret = true;
		Transaction t = null;
		try{
			t = session.beginTransaction();
		
			session.save(r);
			t.commit();
		} catch(Exception e){
			t.rollback();
			System.out.println("Error " + e.getMessage());
			ret = false;
			t.rollback();
		} finally {
			
		}
		return ret;
		
	}
	/**
	 * ... Only the admin & the authors could remove recipes
	 */
	public boolean removeRezept(String username, int rez_id){
		Transaction t = null;
		boolean isSuccessful = true;
		try {
			t = session.beginTransaction();
			Rezept r = new Rezept();
			r.setRez_id(rez_id);
			
			session.delete(r);
		} catch(Exception e){
			t.rollback();
			isSuccessful = false;
		}
		
		return isSuccessful;
	}

	@Override
	public List<Rezept> getRezeptByCategory(Category C) {
	
		return null;
	}

	@Override
	public List<Rezept> getRezeptByCategory() {
		
		return null;
	}
	public byte [] getFoto(){
		// TO DO
		return new byte[0];
	}
	/*public String getTitle(){
		//TO DO
		
	}
	public String getDescriptionShort(){
		//Erster Satz 50 character
	}*/
}
