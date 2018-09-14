package ws.impl;

import ws.HelloWebService;

public class HelloWebServiceImpl implements HelloWebService{

	@Override
	public String sayWebHello() {
		return "hello webservice";
	}

}
