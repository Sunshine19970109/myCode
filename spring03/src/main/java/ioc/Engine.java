package ioc;

import org.springframework.stereotype.Component;

@Component("en")
public class Engine {

	public Engine() {
		System.out.println("Engine()");
	}

}
