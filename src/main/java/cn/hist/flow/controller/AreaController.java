package cn.hist.flow.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;

import cn.hist.flow.domain.Area;
import cn.hist.flow.domain.Data;
import cn.hist.flow.service.AreaService;

@Controller
@RequestMapping("/area")
public class AreaController {

	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value="/findParent",method=RequestMethod.GET)
	public String findParent(Map<String,Object> data){
		List<Area> lists = areaService.findParent();
		data.put("areas",lists);
		return "area/areaList";
	}
	
	@RequestMapping(value="/findAll",method=RequestMethod.GET)
	public String findAll(Map<String,Object> data){
		List<Area> list=areaService.findAll();
		data.put("areas",list);
		return "area/areaList";
	}
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test() {
		return "ui-elements";
	}
}
