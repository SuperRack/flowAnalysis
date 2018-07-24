package cn.hist.flow.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

	private User user=null;
	public User mapRow(ResultSet rs, int rowNumber) throws SQLException {
		user=new User();
		user.setId(rs.getString(1));
		user.setLoginName(rs.getString(2));
		user.setName(rs.getString(3));
		user.setPwd(rs.getString(4));
		user.setEmail(rs.getString(5));
		user.setPhone(rs.getString(6));
		user.setStatus(rs.getString(7));
		return user;
	}
}
