package cn.hist.flow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hist.flow.dao.AreaDao;
import cn.hist.flow.domain.Area;

@Service
@Transactional(readOnly=true)
public class AreaServiceImpl implements AreaService{
	
	@Autowired
	private AreaDao areaDao;
	
	public List<Area> findParent() {
		return areaDao.findParent();
	}
	
	public List<Area> findAll() {
		List<Area> list = areaDao.findAll();
		//中间我们需要处理数据，将没有父级地区的数据设置为 "0"
		//将id中的点号，全部替换成空
		for (Area area : list) {
			area.setId(area.getId().replace(".", ""));
			if(area.getParentId()!=null && area.getParentId()!=""){
				area.setParentId(area.getParentId().replace(".",""));
			}else{
				area.setParentId("0");
			}
		}
		return list;
	}
}
