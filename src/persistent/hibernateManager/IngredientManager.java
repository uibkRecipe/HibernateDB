package persistent.hibernateManager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import persistent.classes.Ingredient;
import persistent.interfaces.IngredientManagerInterface;

public class IngredientManager extends PersistentManager implements IngredientManagerInterface
{

	public IngredientManager(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public boolean addIngredient(Ingredient ingredient) {
		boolean success = true;
		Transaction transaction = null;
		Session session = sessionFactory.openSession();
		try {
			
			transaction = session.beginTransaction();
			session.save(ingredient);
			
		} catch(Exception e){
			if(transaction != null)
				transaction.rollback();
			e.printStackTrace();
			success = false;
		}
		transaction.commit();
		
		return success;
	}
	
	public List<Ingredient> findIngredientsByIngredientType(int IngredientTypeID){
		return null;
	}

	@Override
	public Ingredient findIngredient(int ingredientTypeID) {
		// TODO Auto-generated method stub
		return null;
	}

}
