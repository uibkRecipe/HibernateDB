package persistent.hibernateManager;

import org.hibernate.Session;

import Interfaces.ZutatenInterface;

public class ZutatenManager extends PersistentManager 
implements ZutatenInterface{

	public ZutatenManager(Session session) {
		super(session);
	}

}
