package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CityController {
	@RequestMapping("showCity.do")
	public String showCity(ModelMap mm){
		City c1 = new City();
		c1.setId(1);
		c1.setName("Ìì½ò");
		City c2 = new City();
		c2.setId(2);
		c2.setName("Î÷°²");
		List<City> allCity = new ArrayList<City>();
		
		allCity.add(c1);
		allCity.add(c2);
		mm.addAttribute("allCity", allCity);
		return "showCity";
	}
}
