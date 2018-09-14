package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello.abc")
public class HelloController {
	/**
	 * http://localhost:8080/EbizTest/hello.abc?action=showIndex
	 * @return
	 */
	@RequestMapping(params = "action=showIndex")
	public ModelAndView showIndex(){
		ModelAndView mav = new ModelAndView("page/index");
		
		return mav;
	}
}
