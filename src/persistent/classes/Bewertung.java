package persistent.classes;

public class Bewertung {
	int bew_id;
	int rez_id;
	String username;
	int sterne;
	String kommentar;
	
	public Bewertung(){
		
	}
	
	public int getBew_id() {
		return bew_id;
	}
	public void setBew_id(int bew_id) {
		this.bew_id = bew_id;
	}
	public int getRez_id() {
		return rez_id;
	}
	public void setRez_id(int rez_id) {
		this.rez_id = rez_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getSterne() {
		return sterne;
	}
	public void setSterne(int sterne) {
		this.sterne = sterne;
	}
	public String getKommentar() {
		return kommentar;
	}
	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}
	
}
