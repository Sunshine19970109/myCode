package cn.tedu.store.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.ICartService;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController {
	@Resource
	private ICartService cartService;
	@RequestMapping("/addCart.do")
	@ResponseBody
	public ResponseResult<Void> addCart(
				HttpSession session,
				String goodsId,
				Integer num){
		ResponseResult<Void> rr = 
				new ResponseResult<Void>(1, "添加成功");
		Cart cart = new Cart();
		cart.setUid(this.getId(session));
		cart.setNum(num);
		cart.setGoodsId(goodsId);
		cartService.addCart(cart);
		return rr;
	}
	@RequestMapping("/showCart.do")
	public String showCart(HttpSession session,
			ModelMap map) {
		map.put("listVo", cartService.getByUid(this.getId(session)));
		return "cart";
	}
	@RequestMapping("/removeByIds")
	public String removeByIds(Integer[] ids) {
			cartService.removeByIds(ids);
		return "redirect:../cart/showCart.do";
	}
	@RequestMapping("/removeById")
	public String removeById(Integer id) {
			cartService.removeById(id);
		return "redirect:../cart/showCart.do";
	}
	@RequestMapping("/changeById")
	@ResponseBody
	public ResponseResult<Void> changeById(Integer id,Integer num){
		ResponseResult<Void> rr=
				new ResponseResult<Void>(1, "修改成功");
		cartService.changeById(id, num);
		return rr;
	}
}
