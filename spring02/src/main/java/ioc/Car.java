package ioc;

public class Car {
	private Engineer engineer;
	public Car(Engineer engineer) {
		System.out.println("Car(Engineer engineer)");
		this.engineer = engineer;
	}
	public Car() {
		System.out.println("Car()");
	}
	@Override
	public String toString() {
		return "Car [engineer=" + engineer + "]";
	}

}
