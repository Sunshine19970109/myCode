package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.AddressService;

@Controller
@RequestMapping("/address")
public class AddressController extends BaseController {
	@Resource
	private AddressService addressService;
	@RequestMapping("/showAddress.do")
	/**
	 * 显示地址管理页面
	 * @return
	 */
	public String showAddress() {
		return "addressAdmin";
	}
	@RequestMapping("/addAddress.do")
	@ResponseBody//只要不返回视图就需要
	public ResponseResult<Void> addAddress(
			HttpSession session,
			@RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince,
			@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea,
			@RequestParam("receiverAddress") String recvAddress,
			@RequestParam("receiverMobile") String recvPhone,
			@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip,
			@RequestParam("addressName") String recvTag
			) {
		ResponseResult<Void> rr = new ResponseResult<Void>(1, "添加地址成功");
		Address address = new Address();
		address.setUid(this.getId(session));
		address.setRecvName(recvName);
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvArea(recvArea);
		address.setRecvAddress(recvAddress);
		address.setRecvPhone(recvPhone);
		address.setRecvTel(recvTel);
		address.setRecvZip(recvZip);
		address.setRecvTag(recvTag);
		addressService.addAddress(address);
		return rr;
	}
	@RequestMapping("/getByUid.do")
	@ResponseBody
	public ResponseResult<List<Address>> getByUid(HttpSession session){
		ResponseResult<List<Address>> rr = new ResponseResult<List<Address>>(1, "成功");
		rr.setData(addressService.getByUid(this.getId(session)));
		return rr;
	}
	@RequestMapping("/setDefault.do")
	@ResponseBody
	public ResponseResult<Void> setDefault(HttpSession session,Integer id){
		ResponseResult<Void> rr = null;
		try {
			addressService.setDefault(this.getId(session), id);
			rr= new ResponseResult<Void>(1,"设置成功");
		} catch (RuntimeException e) {
			rr = new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	}
	@RequestMapping("/goUpdate.do")
	@ResponseBody
	public ResponseResult<Address> goUpdate(Integer id){
		ResponseResult<Address> rr = new ResponseResult<Address>(1, "获取地址成功");
		rr.setData(addressService.getById(id));
		return rr;
	}
	@RequestMapping("/updateAddress.do")
	@ResponseBody
	//修改收货人信息
	public ResponseResult<Void> updateAddress(Integer id,
			@RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince,
			@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea,
			@RequestParam("receiverAddress") String recvAddress,
			@RequestParam("receiverMobile") String recvPhone,
			@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip,
			@RequestParam("addressName") String recvTag
			){
		Address address = new Address();
		address.setId(id);
		address.setRecvName(recvName);
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvArea(recvArea);
		address.setRecvAddress(recvAddress);
		address.setRecvPhone(recvPhone);
		address.setRecvTel(recvTel);
		address.setRecvZip(recvZip);
		address.setRecvTag(recvTag);
		addressService.updateAddress(address);
		ResponseResult<Void> rr = new ResponseResult<Void>(1, "添加地址成功");
		return rr;
	}
	@RequestMapping("/removeAddress.do")
	@ResponseBody
	public ResponseResult<Void> removeAddress(Integer id){
		ResponseResult<Void> rr = new ResponseResult<Void>(1, "删除成功");
		addressService.removeAddress(id);
		return rr;
	}
}

