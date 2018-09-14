package ws.impl;

import org.springframework.stereotype.Service;

import ws.HelloWebService;
@Service
public class HelloWebServiceImpl implements HelloWebService {

	public String sayWebHello() {
		
		return "hello web service";
	}

}
