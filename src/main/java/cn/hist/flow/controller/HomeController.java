package cn.hist.flow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 主页面，页面跳转
 */
@Controller
public class HomeController {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(){
		return "login";
	}
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(){
		return "base/main";
	}
}
