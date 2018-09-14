package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.tedu.store.bean.GoodsCategory;

/**
 * 商品分类的接口
 * @author soft01
 */
@Repository
public interface GoodsCategoryMapper {
	/**
	 * 根据id查询指定位置的商品
	 * @param parentId
	 * @param offset
	 * @param count
	 * @return
	 * 1.mybatis如果参数多与一个，那么需要处理
	 * 2.解决方法有两种:第一种：把参数封装为bean
	 * 第二种通过@Param注解分别给变量做映射。
	 */
	List<GoodsCategory> selectByParentId(
			@Param("parentId") Integer parentId,
			@Param("offset") Integer offset,
			@Param("count") Integer count);
}
