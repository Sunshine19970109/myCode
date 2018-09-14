package cn.tedu.store.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
@Repository
public interface DictMapper {
	/**
	 * 查询所有的省份
	 * @return 省份集合
	 */
	List<Province> selectProvince();
	/**
	 * 根据省份编码查询城市
	 * @param provinceCode
	 * @return  省份对应的城市
	 */
	List<City> selectCity(String provinceCode);
	/**
	 * 根据城市编码查询地区
	 * @param cityCode
	 * @return	每个城市对应的区县
	 */
	List<Area> selectArea(String cityCode);
	/**
	 * 根据省的编号获取省的名称
	 * @param provinceCode
	 * @return
	 */
	String selectByProvinceCode(String provinceCode);
	/**
	 * 根据城市编号查询城市名称
	 * @param cityCode
	 * @return
	 */
	String selectByCityCode(String cityCode);
	/**
	 * 根据区县编号查询区县名称	
	 * @param areaCode
	 * @return
	 */
	String selectByAreaCode(String areaCode);
}
