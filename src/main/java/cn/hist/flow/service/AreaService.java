package cn.hist.flow.service;

import java.util.List;

import cn.hist.flow.domain.Area;

public interface AreaService {

	public List<Area> findParent();

	public List<Area> findAll();
	
}
