package ioc;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Plane {
//	@Resource(name="en")
	private Engine engine;
	@Override
	public String toString() {
		return "Plane [engine=" + engine + "]";
	}
	public Engine getEngine() {
		return engine;
	}
	@Autowired
	public void setEngine(@Qualifier("en") Engine engine) {
		this.engine = engine;
	}
	public Plane() {
		System.out.println("Plane()");
	}

}
