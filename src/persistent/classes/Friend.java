package persistent.classes;

import java.io.Serializable;

public class Friend implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name1; //src
	private String name2; //dest
	//private boolean isValid;
	
	public Friend(){
		
	}
	public Friend(String name1, String name2){
		this.name1 = name1;
		this.name2 = name2;
		//isValid = false;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	
	public boolean equals(Object o){
		Friend f = (Friend) o;
		boolean toRet = false;
		if(this.name1 == f.getName1() && this.name2 == f.getName2())
			toRet = true;
		else if(this.name1 == f.getName2() && this.name2 == f.getName1())
			toRet = true;
		return toRet;
	}
	
}
