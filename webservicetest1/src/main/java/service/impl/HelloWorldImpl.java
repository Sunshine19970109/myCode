package service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

import entity.User;
import service.HelloWorld;
@WebService(endpointInterface="service.HelloWorld",serviceName="HelloWorld")
public class HelloWorldImpl implements HelloWorld {
	Map<Integer,User> users = new LinkedHashMap<Integer,User>();
	@WebMethod
	public String sayHi(String text) {
		return "hello"+text;
	}
	@WebMethod
	public String sayHiToUser(User user) {
		return "hello"+user.getName();
	}
	@WebMethod
	public String[] SayHiToUserList(List<User> userList) {
		String[] result = new String[userList.size()];
		int i=0;
		for (User user : userList) {
			result[i] = "hello"+user.getName();
		}
		return result;
	}

}
