package test;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;

public class TestUser {
	public UserMapper mapper;
	public IUserService userService;
	//如果直接用容器接口就没有关闭方法，所以应该用对应的实现类
	public AbstractApplicationContext ac;
	@Before
	public void init() {
		String config = "application-dao.xml";
		ac = new ClassPathXmlApplicationContext(config,"application-service.xml");
		mapper = ac.getBean("userMapper",UserMapper.class);
		userService = ac.getBean("userService",IUserService.class);
	}
	@After
	public void close() {
		ac.close();
	}
	@Test
	public void test1() {
		User u1 = new User("Tom","123456","13132105223@163.com","13132105223");
		User u2 = new User("myAdmin","123456","tedu@.cn.com","863526554");
		
		mapper.insertUser(u2);
	}
	@Test
	public void testSelectByUsername() {
		/*
		 * 1.获取spring容器
		 * 2.从容器中获取bean对象
		 * 3.调用方法
		 * 4.关闭容器
		 */
		User u = mapper.selectByUsername("Tom");
		System.out.println(u);
		Integer num = 10;
	}
	@Test
	public void testSelectById() {
		User u = mapper.selectUserById(2);
		System.out.println(u);
	}
	@Test
	public void TestAddUser() {
		User user = new User("jerry","125634","18632105223@163.com","18632105223");
		userService.addUser(user);
	}
	@Test
	public void TestSelectByEmail() {
		User user = new User("jerry","125634","1863210223@163.com","18632105223");
		int num = mapper.selectByEmail(user.getEmail());
		System.out.println(num);
	}
	@Test
	public void testFindByEmail() {
		User user = new User("jerry","125634","1863210523@163.com","18632105223"); 
		userService.checkEmail(user.getEmail());
	}
	@Test
	public void testSelectByPhone() {
		User user = new User("jerry","125634","1863210523@163.com","18632105233"); 
		int num = mapper.selectByPhone(user.getPhone());
		System.out.println(num);
	}
	@Test
	public void testFindByPhone() {
		User user = new User("jerry","125634","1863210523@163.com","18632105223"); 
		boolean flag = userService.checkPhone(user.getPhone());
		System.out.println(flag);
	}
	@Test
	public void testCheckUsername() {
		User user = new User("jerry","125634","1863210523@163.com","18632105223"); 
		boolean flag = userService.checkUsername(user.getUsername());
		System.out.println(flag);
	}
	@Test
	public void testLogin() {
		User user = new User("jerry","125634","1863210523@163.com","18632105223"); 
		User user1 = userService.login(user.getUsername(), user.getPassword());
		System.out.println(user1);
	}
	@Test
	public void testUpdateUser() {
		User user = new User("jerry","895442","8623210523@163.com","86232105223"); 
		user.setId(3);//session中有的
		user.setGender(1);
		user.setModifiedTime(new Date());
		user.setModifiedUser("朱高宏");
		mapper.updateUser(user);
	}
	@Test
	public void testChangePassword() {
		User user = mapper.selectUserById(2);
		userService.changePassword(2,user.getPassword(), "856123664");
	}
	@Test
	public void testUpdateUserService() {
		userService.updateUser(2,"jerry",0, "12354896636@163.com", "12545663366");
	}
	@Test
	public void testUpdateImage() {
		mapper.updateImage(2, "afcewsf");
	}
}
