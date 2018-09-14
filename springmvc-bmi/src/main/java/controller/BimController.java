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
		//����bmiָ�����ж��û�����״��
		String status = "����";
		if(bmi<19){
			status = "����";
		}
		if(bmi>24){
			status = "����";
		}
		mm.addAttribute("status", status);
		return "result";
	}
	@RequestMapping("/Bim.do")
	public String bim(){
		return "bmi";
	}
}
