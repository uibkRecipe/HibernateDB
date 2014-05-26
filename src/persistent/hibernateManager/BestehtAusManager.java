package persistent.hibernateManager;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import persistent.classes.Rezept;
import persistent.classes.Zutaten;

public class BestehtAusManager extends PersistentManager{
	

	public BestehtAusManager(Session session){
		super(session);
	}
	
	/*public List<Zutaten> getZutaten(Rezept r){
		List<Zutaten> ls;
		session.beginTransaction();
		try {
			SQLquery query = 
					session.createSQLQuery("SELECT zut_typ_id FROM ")
		}
		
		
		
		return new ArrayList<Zutaten>();
	}*/
}
