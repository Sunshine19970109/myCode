package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.tedu.store.bean.Goods;

@Repository
public interface GoodsMapper {
	/**
	 * 根据目录id分页查询商品
	 * @param categoryId
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> selectByCategoryId(
			@Param("categoryId")Integer categoryId,
			@Param("offset")Integer offset,
			@Param("count")Integer count);
	/**
	 * 查寻商品的个数
	 * @param categoryId
	 * @return
	 */
	Integer selectCount(Integer categoryId);
	/**
	 * 根据id查询对应的商品
	 * @param id
	 * @return
	 */
	Goods selectById(String id);
}
