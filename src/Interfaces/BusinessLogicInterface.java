package Interfaces;

import persistent.classes.User;

public interface BusinessLogicInterface {
	/** register a user */
	public boolean register(UserInterface u);
	/** */
	public boolean logIn();
	/** */
	public boolean logOut();
	/** Add recipe */
	public boolean addRecipe(RezeptInterface r);
	
}
