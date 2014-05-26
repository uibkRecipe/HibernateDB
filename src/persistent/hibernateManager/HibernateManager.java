package persistent.hibernateManager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import persistent.classes.Ort;
import persistent.classes.Rezept;
import persistent.classes.User;
/**
 * Fassade for hibernate
 * @author mirko
 *
 */
public class HibernateManager {
	private Session session;
	StandardServiceRegistryBuilder ssrb;
	private UserManager userManager;
	private OrtManager ortManager;
	private FriendManager friendManager;
	private RezeptManager rezeptManager;
	/**
	 * Constructor return a new HibernateManager
	 */
	public HibernateManager() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		ssrb = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb
				.build());
		session = sessionFactory.openSession();
		userManager = new UserManager(session);
		ortManager = new OrtManager(session);
		friendManager = new FriendManager(session);
		rezeptManager = new RezeptManager(session);
	}

	/**
	 * Close the session
	 */
	public void closeSession() {
		if(session.isConnected())
			session.close();
		
	}
	
	/****************************************************************
	 * 
	 *  User Functionalities
	 *  
	 ****************************************************************/
	

	public boolean logIn(String userName, String suggestedPassword){
		return userManager.logIn(userName, suggestedPassword);
	}
		
	public boolean addUser(User user){
		return userManager.addUser(user);
	}
	
	/*****************************************************************
	 * 
	 * Ort Functionalities
	 * 
	 *****************************************************************/
	
	public boolean addOrt(Ort ort){
		return ortManager.addOrt(ort);
	}

	public Ort findOrtById(int ortId){
		return ortManager.findOrtById(ortId);
	}
	public List<Ort> findOrtByName(String ortName) {
		return ortManager.findOrtByName(ortName);
	}
	/******************************************************************
	 * 
	 * 
	 * Friends functionalities
	 * 
	 * 
	 ******************************************************************/ 
	public List<String> getFriend(String username){
		return friendManager.getFriend(username);
	}
	public boolean addFriend(String username1, String username2){
		return friendManager.addFriend(username1, username2);
	}
	public boolean deleteFriend(String username1, String username2){
		return friendManager.deleteFriend(username1, username2);
	}
	
	/****************************************************************
	 *  
	 * Rezept functionalities
	 *
	 ****************************************************************/
	public boolean addRezept(Rezept r){
		return rezeptManager.addRezept(r);
	}
	

}
