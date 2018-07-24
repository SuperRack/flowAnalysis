package cn.hist.flow.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hist.flow.dao.DataDao;
import cn.hist.flow.domain.BarData;
import cn.hist.flow.domain.Data;
import cn.hist.flow.domain.LineData;
import cn.hist.flow.domain.PicData;

@Service
public class DateServiceImpl implements DateService {
	
	@Autowired
	private DataDao dataDao;
	
	public List<String> findProvince() {
		return dataDao.findProvince();
	}
	
	/**
	 * 获取所有的省份id
	 */
	public List<String> findParendId(){
		return dataDao.findParendId();
	}
	
	
	private List<String> ids = null;
	private List<String> findProvince =null;
	
	public List<BarData> findUpDownByPro(Data data) {
		//查询所有的省份，循环查询每个省份下的上行与下行的流量数据。
		if((ids==null ||  ids.size()<=0) && (findProvince==null || findProvince.size()<=0)){
			ids = dataDao.findParendId();
			findProvince = findProvince();
		}
		
		List<BarData> barDatas=new ArrayList<BarData>();
		
		BarData barData = null;
		for(int i=0;i<findProvince.size();i++){
			//通守省份去统计
			barData=dataDao.countByPro(data,ids.get(i));
			barData.setName(findProvince.get(i));
			barDatas.add(barData);
		}
		return barDatas;
	}
	
	public List<PicData> findFlowByPcPicUp(String flowYear) {
		//查询所有的省份，循环查询每个省份下的上行与下行的流量数据。
		if((ids==null ||  ids.size()<=0) && (findProvince==null || findProvince.size()<=0)){
			ids = dataDao.findParendId();
			findProvince = findProvince();
		}
		
		
		List<PicData> picDatas=new ArrayList<PicData>();
		
		PicData picData=null;
		for(int i=0;i<findProvince.size();i++){
			picData = dataDao.findFlowByPcPicUp(flowYear,ids.get(i));
			picData.setName(findProvince.get(i));
			picDatas.add(picData);
		}
		return picDatas;
	}
	
	public List<PicData> findFlowByPcPicDown(String flowYear) {
		if((ids==null ||  ids.size()<=0) && (findProvince==null || findProvince.size()<=0)){
			ids = dataDao.findParendId();
			findProvince = findProvince();
		}
		List<PicData> picDatas=new ArrayList<PicData>();
		PicData picData=null;
		for(int i=0;i<findProvince.size();i++){
			picData = dataDao.findFlowByPcPicDown(flowYear,ids.get(i));
			picData.setName(findProvince.get(i));
			picDatas.add(picData);
		}
		return picDatas;
	}
	
	public List<LineData> findFlowByLineUp(String flowYear) {
		if((ids==null ||  ids.size()<=0) && (findProvince==null || findProvince.size()<=0)){
			ids = dataDao.findParendId();
			findProvince = findProvince();
		}
		//name   data
		List<LineData> lineDatas=new ArrayList<LineData>();
		LineData lineData=null;
		for(int i=0;i<findProvince.size();i++){
			lineData=dataDao.findFLowByLineUp(flowYear,ids.get(i));
			lineData.setName(findProvince.get(i));
			lineDatas.add(lineData);
		}
		return lineDatas;
	}
	
	public List<LineData> findFlowByLineDown(String flowYear) {
		if((ids==null ||  ids.size()<=0) && (findProvince==null || findProvince.size()<=0)){
			ids = dataDao.findParendId();
			findProvince = findProvince();
		}
		//name   data
		List<LineData> lineDatas=new ArrayList<LineData>();
		LineData lineData=null;
		for(int i=0;i<findProvince.size();i++){
			lineData=dataDao.findFLowByLineDown(flowYear,ids.get(i));
			lineData.setName(findProvince.get(i));
			lineDatas.add(lineData);
		}
		return lineDatas;
	}
	
}
