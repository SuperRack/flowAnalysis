package cn.hist.flow.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import org.springframework.jdbc.core.RowMapper;

public class LineDataMapper implements RowMapper<LineData>{

	private LineData lineData=null;
	private Double [] yearCount=null;
	int row;
	public LineData mapRow(ResultSet rs, int rowNum) throws SQLException {
		lineData=new LineData();
		int i=0;
		if(rs!=null){
			rs.last();
			row=rs.getRow();
			yearCount=new Double[row];
			rs.beforeFirst();
			while(rs.next()){
				yearCount[i++]=rs.getDouble(1);
			}
		}
		lineData.setData(yearCount);
		return lineData;
	}
}
