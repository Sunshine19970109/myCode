package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.vo.CartVo;

public interface ICartService {
	/**
	 * 添加购物车
	 * @param cart
	 */
	void addCart(Cart cart);
	/**
	 * 根据uid查询购物车中的商品
	 * @param uid
	 * @return
	 */
	List<CartVo> getByUid(Integer uid);
	/**
	 * 批量删除购物车商品
	 * @param ids
	 */
	void removeByIds(Integer[] ids);
	/**
	 * 删除购物车商品
	 * @param ids
	 */
	void removeById(Integer id);
	/**
	 * 根据id更改购物车商品数量
	 * @param id
	 * @param num
	 */
	void changeById(Integer id,Integer num);
}
