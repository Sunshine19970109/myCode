package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.vo.CartVo;
@Repository
public interface CartMapper {
	void insertCart(Cart cart);
	/**
	 * 根据uid查询购物车的商品
	 * @param uid
	 * @return
	 */
	List<CartVo> selectByUid(Integer uid);
	/**
	 * 批量删除购物车商品
	 * @param ids
	 */
	void deleteByIds(Integer[] ids);
	/**
	 * 根据id删除购物车的商品
	 * @param id
	 */
	void deleteById(Integer id);
	/**
	 * 根据id修改购物车商品数量
	 * @param id
	 * @param num
	 */
	void updateById(@Param("id")Integer id,@Param("num")Integer num);
}
