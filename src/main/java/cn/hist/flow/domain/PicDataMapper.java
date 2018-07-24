package cn.hist.flow.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PicDataMapper implements RowMapper<PicData> {

	private PicData picData;
	public PicData mapRow(ResultSet rs, int count) throws SQLException {
		picData=new PicData();
		picData.setValue(rs.getDouble(1));
		return picData;
	}
}