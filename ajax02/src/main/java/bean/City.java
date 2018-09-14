package bean;

public class City {
	public City(String name, String value) {
		this.name = name;
		this.value = value;
	}
	private String name;
	private String value;
	@Override
	public String toString() {
		return "City [name=" + name + ", value=" + value + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
