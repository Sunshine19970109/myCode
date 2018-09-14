package cn.tedu.store.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.tedu.store.bean.Address;
@Repository
public interface AddressMapper {
	/**
	 * 插入收货地址
	 * @param address
	 */
	void insertAddress(Address address);
	/**
	 * 根据uid查询收货地址
	 * @param uid
	 * @return
	 */
	List<Address> selectByUid(Integer uid);
	/**
	 * 根据uid更新所有的地址的isDefault属性为0
	 * @param uid
	 * @return 更新的行数
	 */
	Integer updateByUid(Integer uid);
	/**
	 * 根据id更新地址为默认
	 * @param id
	 * @return 更新的行数
	 */
	Integer updateById(Integer id);
	/**
	 * 根据id做地址查询
	 * @param id
	 * @return Address地址对象
	 */
	Address selectById(Integer id);
	/**
	 * 根据id修改地址
	 * @param id
	 */
	void updateAddressById(Address address);
	/**
	 * 通过id删除收货人地址
	 * @param id
	 */
	void deleteById(Integer id);
}
