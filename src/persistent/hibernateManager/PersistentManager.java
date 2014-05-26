package persistent.hibernateManager;

import org.hibernate.Session;

public abstract class PersistentManager {
	protected Session session;
	
	public PersistentManager(Session session){
		this.session = session;
	}
}
