package persistent.hibernateManager;

import org.hibernate.Session;

import Interfaces.ZutatentypInterface;

public class ZutatentypManager extends PersistentManager implements
		ZutatentypInterface {

	public ZutatentypManager(Session session) {
		super(session);
	}
	
	

}
