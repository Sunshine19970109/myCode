package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IGoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Resource
	private IGoodsService goodsService;
	@RequestMapping("/showSearch.do")
	public String showSearch(Integer categoryId,Integer page,
			ModelMap map) {
		//判断三级分类的点击事件
		if(page==null) {
			page=1;
		}
		//获取每一页的商品
		List<Goods> list = goodsService.getByCategoryId(
			categoryId, (page-1)*12, 12);
		map.addAttribute("list", list);
		//计算页数
		Integer count = goodsService.getCount(categoryId);
		Integer pageSize = count%12==0?count/12:count/12+1;
		//添加计算的页数和商品数
		map.addAttribute("count", count);
		map.addAttribute("pageSize", pageSize);
		//把categoryId传入map中
		map.addAttribute("categoryId", categoryId);
		//把当前页添加到map中
		map.addAttribute("currentPage", page);
		return "search";
	}
	@RequestMapping("/showProductDetails.do")
	public String showProductDetails(String id,ModelMap map){
		map.addAttribute("goods", goodsService.getById(id));
		return "product_details";
	}
}
