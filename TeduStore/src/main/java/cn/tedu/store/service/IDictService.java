package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

public interface IDictService {
	/**
	 * 查询所有的省份
	 * @return 返回所有的省份
	 */
	List<Province> getProvince();
	/**
	 * 根据省份的编码获取所有的城市
	 * @return
	 */
	List<City> getCity(String provinceCode);
	/**
	 * 根据省份的编码获取所有的区县
	 * @param cityCode
	 * @return 某个城市对应的区县集合
	 */
	List<Area> getArea(String cityCode);
}
