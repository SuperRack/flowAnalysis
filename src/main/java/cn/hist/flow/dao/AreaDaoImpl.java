package cn.hist.flow.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.hist.flow.domain.Area;
import cn.hist.flow.domain.AreaMapper;

@Repository
public class AreaDaoImpl implements AreaDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Area> findParent() {
		String sql="select * from flow_area where parentId is null";
		return jdbcTemplate.query(sql, new AreaMapper());
	}

	public List<Area> findAll() {
		String sql="select * from flow_area";
		return jdbcTemplate.query(sql,new AreaMapper());
	}
}