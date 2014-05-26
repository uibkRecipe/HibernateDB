package persistent.hibernateManager;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import persistent.classes.Friend;
import persistent.classes.User;

public class FriendManager extends PersistentManager {
	
	
	public FriendManager(Session session){
		super(session);
	}
	
	public List<String> getFriend(String username){
		List<String> lf = new ArrayList<String>();
		List<String> lf1 = new ArrayList<String>();
		session.beginTransaction();
		/** If the object is not already contained **/
		try {
			SQLQuery query = session.createSQLQuery("SELECT name2 FROM freunde WHERE name1='" + username + "'");
			SQLQuery query1 = session.createSQLQuery("SELECT name1 FROM freunde WHERE name2='" + username + "'");
			lf = (List<String>)query.list();
			lf1 = (List<String>)query1.list();
			lf.addAll(lf1);
		} catch (Exception e) {
			System.out.println("ERROR " + e.getMessage());
			
		} finally {
			
		}
		return lf;
		
	}
	public boolean addFriend(String username1, String username2){
		boolean ret = true;
		session.beginTransaction();
		try {
			Friend f = new Friend(username1, username2);
			session.save(f);
			session.getTransaction().commit();
		}catch (Exception e){
			System.out.println("ERROR : " + e.getMessage());
			ret = false;
		}
		finally{
			
			
		}
		return ret;
	}
	public boolean deleteFriend(String username1, String username2){
		boolean ret = true;
		if(!existFriend(username1, username2)){
			System.err.println("You cannot delete a not existing friend");
			return false;
		}
		session.beginTransaction();
		try {
			session.delete(new Friend(username1, username2));
			session.getTransaction().commit();
		} catch(Exception e){
			
		} finally {
			
		}
		
		return ret;
		
	}
	public boolean existFriend(String username1, String username2){
		boolean exist = true;
		int count = 0;
		session.beginTransaction();
		try {
			SQLQuery query = session.createSQLQuery
					("SELECT count(*) FROM freunde WHERE name1='" + username1 + "' AND name2='" + username2 + "'");
			List<Integer> l = (List<Integer>)query.list();
			count = l.get(0);
			query = session.createSQLQuery
					("SELECT count(*) FROM freunde WHERE name2='" + username1 + "' AND name1='" + username2 + "'");
			
			l = (List<Integer>)query.list();
			count += l.get(0);
			if(count == 0)
				exist = false;
		} catch(Exception e){
			
		} finally {
			session.getTransaction().commit();
		}
		
		return exist;
	}
}
