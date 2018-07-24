package cn.hist.flow.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONArray;

import cn.hist.flow.domain.BarData;
import cn.hist.flow.domain.Data;
import cn.hist.flow.domain.LineData;
import cn.hist.flow.domain.PicData;
import cn.hist.flow.service.DateService;

@Controller
@RequestMapping(value="/flow")
public class DataController {
	
	@Autowired
	private DateService dataService;
	
	
	/**
	 * 流量统计按年份 柱状图
	 * 分别统计每个省份下的上行与下行流量
	 */
	@RequestMapping(value="/findUpDownByPro",method={RequestMethod.GET,RequestMethod.POST})
	public String findUpDownByPro(Data data,Map<String,Object> paramData){
		List<String> provinces=dataService.findProvince();
		//将数据转成json，保存到paramData中去。
		String prosJson = JSONArray.toJSONString(provinces);
		paramData.put("prosJson", prosJson);
		List<BarData> barListData=dataService.findUpDownByPro(data);
		String barDataJson = JSONArray.toJSONString(barListData);
		paramData.put("barDataJson", barDataJson);
		return "flow/flow";
	}
	
	/**
	 * 流量统计按年份 饼图
	 * @param flowYear
	 * @param paramData
	 * @return
	 */
	@RequestMapping(value="/findFlowByPcPic",method={RequestMethod.GET,RequestMethod.POST})
	public String findFlowByPcPic(String flowYear,Map<String,Object> paramData){
		List<String> provinces=dataService.findProvince();
		//将数据转成json，保存到paramData中去。
		String prosJson = JSONArray.toJSONString(provinces);
		paramData.put("prosJson", prosJson);
		List<PicData> listsUp=dataService.findFlowByPcPicUp(flowYear);
		String picDataUps = JSONArray.toJSONString(listsUp);
		paramData.put("picDataUps", picDataUps);
		
		List<PicData> listsDown=dataService.findFlowByPcPicDown(flowYear);
		String picDataDowns = JSONArray.toJSONString(listsDown);
		paramData.put("picDataDowns", picDataDowns);
		
		return "flow/pcflow";
	}
	
	/**
	 * 流量统计按年份 折线图
	 */
	@RequestMapping(value="/findFlowByMobleLine",method={RequestMethod.GET,RequestMethod.POST})
	public String findFlowByMobleLine(String flowYear,Map<String,Object> paramData){
		List<String> provinces=dataService.findProvince();
		//将数据转成json，保存到paramData中去。
		String prosJson = JSONArray.toJSONString(provinces);
		paramData.put("prosJson", prosJson);
		
		//上行流量
		List<LineData> lineDataUp=dataService.findFlowByLineUp(flowYear);
		String lineDatasUpStr = JSONArray.toJSONString(lineDataUp);
		
		System.out.println(lineDatasUpStr);
		
		paramData.put("lineDataUp", lineDatasUpStr);
		
		//下行流量
		List<LineData> lineDataDown=dataService.findFlowByLineDown(flowYear);
		String lineDatasDownStr= JSONArray.toJSONString(lineDataDown);
		paramData.put("lineDataDown", lineDatasDownStr);
		return "flow/lineflow";
	}
}
