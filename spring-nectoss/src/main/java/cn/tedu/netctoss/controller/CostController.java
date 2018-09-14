package cn.tedu.netctoss.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.netctoss.entity.Cost;
import cn.tedu.netctoss.service.CostService;

/**
 * Ç°¶Ë¿ØÖÆÆ÷
 * @author dell
 *
 */
@Controller
public class CostController {
	@Resource(name="costService")
	private CostService costService;
	@RequestMapping("/cost.do")
	public String findAll(ModelMap mm){
		List<Cost> costs = costService.findAll();
		mm.addAttribute("costs",costs);
		return "cost";
	}
}
