package test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.vo.CartVo;

public class TestCart {
	private CartMapper cartMapper;
	AbstractApplicationContext ac;
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext(
				"application-dao.xml","application-service.xml");
		cartMapper = ac.getBean("cartMapper",CartMapper.class);
	}
	@After
	public void after() {
		ac.close();
	}
	@Test
	public void testInsertCart() {
		Cart cart = new Cart();
		cart.setUid(2);
		cart.setNum(10);
		cart.setGoodsId("10000038");
		cart.setCreatedUser("sunshine");
		cart.setCreatedTime(new Date());
		cartMapper.insertCart(cart);
	}
	@Test
	public void testSelectByUid() {
		List<CartVo> list = cartMapper.selectByUid(4);
		Iterator<CartVo> it = list.iterator();
		while (it.hasNext()) {
			CartVo cartVo = (CartVo) it.next();
			System.out.println(cartVo);
		}
	}
	@Test
	public void testDeleteByIds() {
		Integer[] ids = new Integer[]{1,2};
		cartMapper.deleteByIds(ids);
	}
	@Test
	public void testDeleteById() {
		cartMapper.deleteById(10);
	}
	@Test
	public void changeById() {
		cartMapper.updateById(14, 5);
	}
}
