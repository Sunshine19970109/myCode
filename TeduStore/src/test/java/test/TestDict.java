package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.mapper.DictMapper;
import cn.tedu.store.service.DictService;

public class TestDict {
	AbstractApplicationContext ac;
	DictMapper dictMapper;
	DictService dictService;
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext(
				"application-dao.xml","application-service.xml");
		dictMapper = ac.getBean("dictMapper",DictMapper.class);
		dictService = ac.getBean("dictService",DictService.class);
	}
	@After
	public void after() {
		ac.close();
	}
	@Test
	public void testSelectProvince() {
		List<Province> provinces = dictMapper.selectProvince();
		System.out.println(provinces);
	}
	@Test
	public void testSelectCity() {
		List<City> city = dictMapper.selectCity("610000");
		System.out.println(city);
	}
	@Test
	public void testSelectArea() {
		List<Area> areas = dictMapper.selectArea("610100");
		System.out.println(areas);
	}
	@Test
	public void testGetArea() {
		List<Area> areas = dictService.getArea("610100");
		System.out.println(areas);
	}
	@Test
	public void testSelectByProvinceCode() {
		String provinceName = dictMapper.selectByProvinceCode("120000");
		System.out.println(provinceName);
	}
	@Test
	public void testSelectByCityCode() {
		String CityName = dictMapper.selectByCityCode("210100");
		assertEquals("沈阳市", CityName);
		System.out.println(CityName);
	}
	@Test
	public void testSelectByAreaCode() {
		String AreaName = dictMapper.selectByAreaCode("110101");
		assertEquals("东城区", AreaName);
		System.out.println(AreaName);
	}
}






















