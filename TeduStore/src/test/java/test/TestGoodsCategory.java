package test;

import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.mapper.GoodsCategoryMapper;

public class TestGoodsCategory {
	GoodsCategoryMapper goodsMapper;
	AbstractApplicationContext ac;
	@Before
	public void init() {
		 		ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		goodsMapper = ac.getBean("goodsCategoryMapper",GoodsCategoryMapper.class);
	}
	@After
	public void after() {
		ac.close();;
	}
	@Test
	public void testSelectGoodsCategory() {
		List<GoodsCategory> list = goodsMapper.selectByParentId(161, 0, 3);
		for (GoodsCategory goodsCategory : list) {
			System.out.println(goodsCategory);
		}
		List<GoodsCategory> list1 = goodsMapper.selectByParentId(162, null, null);
		for (GoodsCategory goodsCategory : list1) {
			System.out.println(goodsCategory);
		}
		List<GoodsCategory> list2 = goodsMapper.selectByParentId(171, null, null);
		Iterator<GoodsCategory> it =list2.iterator();
		while (it.hasNext()) {
			GoodsCategory goods =it.next();
			System.out.println(goods);
		}
	}
}
