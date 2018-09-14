package service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import entity.User;

@WebService
public interface HelloWorld {
	@WebMethod
	String sayHi(@WebParam(name="text")String text);
	@WebMethod
	String sayHiToUser(User user);
	@WebMethod
	String[] SayHiToUserList(List<User> userList);
}
