package Interfaces;

import java.util.List;

import persistent.classes.Category;
import persistent.classes.Rezept;

public interface RezeptInterface {
	public List<Rezept> getRezeptByCategory(Category C);
	public List<Rezept> getRezeptByCategory();
}
