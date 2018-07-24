package cn.hist.flow.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AreaMapper implements RowMapper<Area> {

	private Area area=null;
	
	public Area mapRow(ResultSet rs, int count) throws SQLException {
		area=new Area();
		area.setId(rs.getString(1));
		area.setName(rs.getString(2));
		area.setParentId(rs.getString(3));
		return area;
	}
}
