package persistent.classes;

import java.util.List;

import Interfaces.RezeptInterface;

public class Rezept  {
	private int rez_id;
	private String autor;
	private String name;
	private String zubereitung;
	private List<Zutaten> zutaten;
	private Category category;
	private byte[] image;
	
	
	public Rezept(){
		
	}
	
	public Rezept(String autor, String name, String zubereitung, List<Zutaten> zutaten, Category category) {
		this.autor = autor;
		this.name = name;
		this.zubereitung = zubereitung;
		this.zutaten = zutaten;
		this.category = category;
	}

	public void setRez_id(int rez_id) {
		this.rez_id = rez_id;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setZubereitung(String zubereitung) {
		this.zubereitung = zubereitung;
	}

	public void setZutaten(List<Zutaten> zutaten) {
		this.zutaten = zutaten;
	}

	public int getRez_id() {
		return rez_id;
	}

	public String getAutor() {
		return autor;
	}

	public String getName() {
		return name;
	}

	public String getZubereitung() {
		return zubereitung;
	}

	public List<Zutaten> getZutaten() {
		return zutaten;
	}
	public Category getCategory(){
		return this.category;
	}
	public void setCategory(Category category){
		this.category = category;
	}
	
	public byte[] getImage(){
		return this.image;
	}
	public void setImage(byte[] image){
		this.image = image;
	}
	
}
