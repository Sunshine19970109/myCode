package test;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.AddressService;

public class TestAddress {
	ClassPathXmlApplicationContext ac;
	AddressMapper addMapper;
	AddressService addressService;
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("application-dao.xml",
				"application-service.xml");
		addMapper = ac.getBean("addressMapper",AddressMapper.class);
		addressService = ac.getBean("addressService",AddressService.class);
		System.out.println("初始化完成");
	}
	@After
	public void after() {
		ac.close();
	}
	@Test
	public void testInsertAddress() {
		Address address = new Address();
		address.setUid(1);
		address.setRecvName("我爹");
		address.setRecvProvince("天津");
		address.setRecvCity("天津市");
		address.setRecvArea("西青区");
		address.setRecvDistrict("天津城建大学");
		address.setRecvPhone("13132105223");
		address.setRecvTel("8653254");
		address.setRecvZip("300384");
		address.setRecvTag("tag");
		address.setIsDefault(1);
		address.setCreatedTime(new Date());
		address.setCreatedUser("sunshine");
		address.setModifiedTime(new Date());
		address.setModifiedUser("你猜啊");
		addMapper.insertAddress(address);
	}
	@Test
	public void testSelectByUid() {
		List<Address> list = addMapper.selectByUid(1);
		System.out.println(list);
	}
	@Test
	public void testAddAddress() {
		Address address = new Address();
		address.setUid(1);
		address.setRecvName("我爹");
		address.setRecvProvince("陕西");
		address.setRecvCity("西安市");
		address.setRecvArea("周至县");
		address.setRecvPhone("13132105223");
		address.setRecvTel("8653254");
		address.setRecvZip("300384");
		address.setRecvTag("tag");
		address.setCreatedTime(new Date());
		address.setCreatedUser("sunshine");
		address.setModifiedTime(new Date());
		address.setModifiedUser("你猜啊");
		addressService.addAddress(address);
	}
	@Test
	public void testUpdate() {
		int num = addMapper.updateByUid(1);
		System.out.println(num);
		int num1 = addMapper.updateById(1);
		System.out.println(num1);
	}
	@Test
	public void testSetDefault() {
		addressService.setDefault(1, 3);
	}
	@Test
	public void testSelectById() {
		Address a = addMapper.selectById(2);
		System.out.println(a);
	}
	@Test
	public void testUpdateAddressById() {
		Address a = addMapper.selectById(2);
		System.out.println(a);
		a.setRecvName("赵玉");
		a.setRecvProvince("130000");
		a.setRecvCity("130100");
		a.setRecvArea("130102");
		a.setRecvDistrict("沙河");
		a.setRecvAddress("不告诉你");
		a.setRecvPhone("1232365455");
		a.setRecvTel("226556");
		a.setRecvZip("710400");
		a.setRecvTag("锦州新成");
		addMapper.updateAddressById(a);
		Address a1 = addMapper.selectById(2);
		System.out.println(a1);
	}
	@Test
	public void testUpdateAddress() {
		Address a = addMapper.selectById(2);
		System.out.println(a);
		a.setRecvName("赵玉");
		a.setRecvProvince("130000");
		a.setRecvCity("130100");
		a.setRecvArea("130102");
		a.setRecvDistrict("沙河");
		a.setRecvAddress("不告诉你");
		a.setRecvPhone("1232365455");
		a.setRecvTel("226556");
		a.setRecvZip("710400");
		a.setRecvTag("锦州新成");
		addressService.updateAddress(a);
		Address a1 = addMapper.selectById(2);
		System.out.println(a1);
	}
	@Test
	public void testDeleteById() {
		addMapper.deleteById(4);
	}
}


















