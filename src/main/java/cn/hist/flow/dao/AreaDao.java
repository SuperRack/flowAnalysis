package cn.hist.flow.dao;

import java.util.List;

import cn.hist.flow.domain.Area;

public interface AreaDao {
	
	public List<Area> findParent();

	public List<Area> findAll();
}
