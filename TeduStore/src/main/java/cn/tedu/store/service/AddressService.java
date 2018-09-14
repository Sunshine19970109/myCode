package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.DictMapper;
@Service
public class AddressService implements IAddressService {
	@Resource
	private AddressMapper addressMapper;
	@Resource
	private DictMapper dictMapper;
	public void addAddress(Address address) {
		if(address!=null) {
			address.setRecvDistrict(getDistrict(address));
			List<Address> list = addressMapper.selectByUid(address.getUid());
			if(list.size()>0) {
				address.setIsDefault(0);
			}else {
				address.setIsDefault(1);
			}
			addressMapper.insertAddress(address);
		}
	}
	public List<Address> getByUid(Integer uid) {
		return addressMapper.selectByUid(uid);
	}
	public void setDefault(Integer uid, Integer id) {
		int num1 = addressMapper.updateByUid(uid);
		if(num1==0) {
			throw new RuntimeException("uid修改错误");
		}
		int num2 = addressMapper.updateById(id);
		if(num2==0) {
			throw new RuntimeException("id修改错误");
		}
	}
	public Address getById(Integer id) {
		return addressMapper.selectById(id);
	}
	public void updateAddress(Address address) {
		address.setRecvDistrict(getDistrict(address));
		addressMapper.updateAddressById(address);
	}
	//把省市区的名称通过该方法返回
	private String getDistrict(Address address) {
		String s1 = dictMapper.selectByProvinceCode(address.getRecvProvince());
		String s2 = dictMapper.selectByCityCode(address.getRecvCity());
		String s3 = dictMapper.selectByAreaCode(address.getRecvArea());
		return s1+s2+s3;
	}
	public void removeAddress(Integer id) {
		addressMapper.deleteById(id);
	}

}
