package cn.hist.flow.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BarDataMapper implements RowMapper<BarData> {

	private BarData barData;
	Double [] arr=null;
	public BarData mapRow(ResultSet rs, int count) throws SQLException {
		arr=new Double[2];
		barData=new BarData();
		barData.setName(rs.getString(1));
		arr[0]=rs.getDouble(2);
		arr[1]=rs.getDouble(3);
		barData.setData(arr);
		return barData;
	}
}
