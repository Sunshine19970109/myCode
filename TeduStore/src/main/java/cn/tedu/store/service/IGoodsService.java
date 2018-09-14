package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Goods;

public interface IGoodsService {
	/**
	 * 根据商品目录id查询商品列表
	 * @param categoryId
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getByCategoryId(Integer categoryId,Integer offset,Integer count);
	/**
	 * 根据categoryId获取商品数量
	 * @param categoryId
	 * @return
	 */
	Integer getCount(Integer categoryId);
	/**
	 * 根据商品id获取商品
	 * @param id
	 * @return
	 */
	Goods getById(String id);
}
