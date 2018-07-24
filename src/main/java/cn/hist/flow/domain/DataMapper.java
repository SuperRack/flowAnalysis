package cn.hist.flow.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DataMapper implements RowMapper<Data> {

	private Data data=null;
	
	public Data mapRow(ResultSet rs, int count) throws SQLException {
		data=new Data();
		data.setId(rs.getString(1));
		data.setFlowUp(rs.getDouble(2));
		data.setFlowDown(rs.getDouble(3));
		data.setFlowArea(rs.getString(4));
		data.setFlowDate(rs.getString(5));
		data.setFlowYear(rs.getString(6));
		data.setFlowMonth(rs.getString(7));
		data.setFlowDay(rs.getString(8));
		data.setFlowType(rs.getString(9));
		
		return data;
	}
}
