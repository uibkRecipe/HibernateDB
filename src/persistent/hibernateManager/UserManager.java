package persistent.hibernateManager;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import persistent.classes.User;
import persistent.help.ByteConverter;

public class UserManager extends PersistentManager {

	ByteConverter byteConverter;

	/**
	 * Constructor given a session it return an UserManager
	 * 
	 * @param session
	 */
	public UserManager(Session session) {
		super(session);
		ByteConverter byteConverter = new ByteConverter();
	}

	/**
	 * Add a user to the table user
	 * 
	 * @param user
	 *            the user to add
	 * @return true on success, false on failure
	 */
	public boolean addUser(User user) {
		boolean success = true;
		session.beginTransaction();
		/** If the object is not already contained **/
		try {
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("We are sorry but your username already exists");
			success = false;
		} finally {
			session.close();
		}
		return success;
	}

	/**
	 * Find a user by user_name
	 * 
	 * @param userName
	 * @return a user on success otherwise null
	 */
	public User findUserById(String userName) {
		User u = null;
		session.beginTransaction();
		try {
			u = (User) session.get(User.class, userName);
		} catch (Exception e) {
			System.out.println("User " + userName + "could not be found");
		} finally {
			session.close();
		}
		return u;
	}

	/**
	 * Return true if the given data matches the one in the database
	 * 
	 * @param userName
	 * @param suggestedPassword
	 * @return true if suggestedPassword matches the real password of the user
	 *         identified by userName
	 */
	public boolean logIn(String userName, String suggestedPassword) {
		User u = findUserById(userName);
		if (u == null) {
			System.out.println("The user " + userName + " does not exist");
			return false;
		}
		if (suggestedPassword.equals(u.getPassword())) {
			System.out.println("Your Data are correct");
		} else {
			System.out.println("You entered the false password");
		}
		return true;
	}
	
	public byte[] getUserFoto(String username){
		byte [] image = new byte[0];
		session.beginTransaction();
		try {
			SQLQuery query1 = session.createSQLQuery
					("SELECT Foto FROM user WHERE user_name='" + username +"'");
			List lbyte = query1.list();
			image = byteConverter.serialize(lbyte.get(0));
		} catch(Exception e){
			
		} finally {
			
		}
		return image;
	}


	
}
