package persistent.hibernateManager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import persistent.classes.Ort;
import persistent.classes.User;
/**
 * Fassade for hibernate
 * @author mirko
 *
 */
public class HibernateManager {
	Session session;
	UserManager userManager;
	OrtManager ortManager;
	
	/**
	 * Constructor return a new HibernateManager
	 */
	public HibernateManager() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb
				.build());
		session = sessionFactory.openSession();
		userManager = new UserManager(session);
		ortManager = new OrtManager(session);
	}

	/**
	 * Close the session
	 */
	public void closeSession() {
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
	public List<Ort> findOrtByName(String ortName){
		return ortManager.findOrtByName(ortName);
	}
}
