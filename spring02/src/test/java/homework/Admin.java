package homework;

public class Admin {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Admin [name=" + name + "]";
	}
	public Admin(String name){
		this.name = name;
	}
	public Admin(){
		
	}
}
