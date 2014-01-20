package main.classes;

public class Position extends EntitiBase {

	private String name;
	private int sallary;
	private int id;
	
	public Position(){
		
	}
	
	public Position(int id, String name, int sallary){
		this.id = id;
		this.name = name;
		this.sallary = sallary;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSallary() {
		return sallary;
	}

	public void setSallary(int sallary) {
		this.sallary = sallary;
	}
	
	
}
