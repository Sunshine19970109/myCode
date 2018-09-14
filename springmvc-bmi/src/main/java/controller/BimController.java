package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BimController {
	@RequestMapping("/toBmi.do")
	public String getBmi(Bmi b,ModelMap mm){
		double weight = b.getWeight();
		double height = b.getHeight();
		System.out.println("weight: "+weight);
		System.out.println("height: "+height);
		mm.addAttribute("weight", weight);
		mm.addAttribute("height", height);
		double bmi = weight/(height*height);
		mm.addAttribute("bmi", bmi);
		//依据bmi指数，判断用户身体状况
		String status = "正常";
		if(bmi<19){
			status = "过轻";
		}
		if(bmi>24){
			status = "过重";
		}
		mm.addAttribute("status", status);
		return "result";
	}
	@RequestMapping("/Bim.do")
	public String bim(){
		return "bmi";
	}
}
