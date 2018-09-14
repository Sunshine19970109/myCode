package cn.tedu.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Address;
@Service
public interface IAddressService {
	/**
	 * 插入收货地址
	 * @param address
	 */
	void addAddress(Address address);
	/**
	 * 通过uid获取所有的地址
	 * @param uid
	 * @return
	 */
	List<Address> getByUid(Integer uid);
	/**
	 * 将收货地址设置为默认
	 * @param uid 用户id
	 * @param id 地址id
	 */
	void setDefault(Integer uid,Integer id);
	/**
	 * 根据id获取对应的地址对象
	 * @param id
	 * @return Address地址对象
	 */
	Address getById(Integer id);
	/**
	 * 修改地址信息
	 * @param address
	 */
	void updateAddress(Address address);
	/**
	 * 根据id删除收货人地址
	 * @param id
	 */
	void removeAddress(Integer id);
}
