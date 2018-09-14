package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.IGoodsService;

@Controller
@RequestMapping("/Main")
public class MainController {
	@Resource
	private IGoodsCategoryService goodsCategoryService;
	@Resource
	private IGoodsService goodsService;
	@RequestMapping("/showIndex.do")
	public String showIndex(ModelMap map) {
		List<List<GoodsCategory>> list3 = 
				new ArrayList<List<GoodsCategory>>();
		List<GoodsCategory> list2 =
				new ArrayList<GoodsCategory>();
		list2 = goodsCategoryService.getByParentId(161, 0, 3);
		//获取热卖的商品
		List<Goods> list4 = goodsService.getByCategoryId(163, 0, 3);
		Iterator<GoodsCategory> it = list2.iterator();
		while(it.hasNext()) {
			GoodsCategory goods = it.next();
			list3.add(goodsCategoryService.getByParentId(goods.getId(), null, null));
		}
		map.put("list2", list2);
		map.put("list3", list3);
		//把热卖的商品的集合添加代map中
		map.addAttribute("goodsList", list4);
		return "index";
	}
}
