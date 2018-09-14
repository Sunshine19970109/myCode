package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.GoodsCategory;

public interface IGoodsCategoryService {
	/**
	 * 根据父级id获取商品目录
	 * @param parentId
	 * @param offset
	 * @param count
	 * @return
	 */
	List<GoodsCategory> getByParentId(Integer parentId,Integer offset,Integer count);
}
