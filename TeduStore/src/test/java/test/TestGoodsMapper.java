package test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.mapper.GoodsMapper;

public class TestGoodsMapper {
	AbstractApplicationContext ac;
	GoodsMapper goodsMapper;
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext(
			  "application-dao.xml","application-service.xml");
		goodsMapper = ac.getBean("goodsMapper",GoodsMapper.class);
	}
	@After
	public void after() {
		ac.close();
	}
	@Test
	public void testSelectByCategoryId() {
		List<Goods> list = goodsMapper.selectByCategoryId(163,0,3);
		for (Goods goods : list) {
			System.out.println(goods);
		}
	}
	@Test
	public void testSelectCount() {
		System.out.println(goodsMapper.selectCount(163));
	}
	@Test
	public void testSelectById() {
		Goods goods = goodsMapper.selectById("10000022");
		System.out.println(goods);
	}
}
