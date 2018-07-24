package cn.hist.flow.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.hist.flow.domain.User;
import cn.hist.flow.domain.UserMapper;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String TABLE="flow_user";
	
	public void add(User user) throws Exception {
		String sql="insert into flow_user(id,loginName,name,pwd) values(?,?,?,?)";
		jdbcTemplate.update(sql, user.getId(),user.getLoginName(),user.getName(),user.getPwd());
	}
	
	public User findByNameAndPwd(User user) throws Exception{
		String sql="select * from "+TABLE+" where loginName=? and pwd=?";
		User us=jdbcTemplate.queryForObject(sql, new UserMapper(), user.getLoginName(),user.getPwd());
		return us;
	}
	
	public List<User> findAll() {
		String sql="select * from "+TABLE;
		return jdbcTemplate.query(sql, new UserMapper());
	}
	
	public int updateStatus(String id, String status) {
		String sql="update "+TABLE +" set status=? where id=?";
		return jdbcTemplate.update(sql,status,id);
	}
	
	public User get(String id) {
		String sql="select * from "+TABLE +" where id=?";
		return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
	}
	
	public int update(User user) {
		String sql="update "+TABLE+" set loginName=?,name=?,pwd=?,email=?,phone=? where id=?";
		return jdbcTemplate.update(sql, user.getLoginName(),user.getName(),user.getPwd(),user.getEmail(),user.getPhone(),user.getId());
	}

	public List<User> findQuery(User user) {
		String sql="select * from "+TABLE +" where 1=1 ";
		StringBuilder where=new StringBuilder();
		List<String> params = new ArrayList<String>();
		if(user.getName()!=null && user.getName()!="" && user.getName().length()>0){
			where.append(" and name=? ");
			params.add(user.getName());
		}
		if(user.getEmail()!=null && user.getEmail()!="" && user.getEmail().length()>0){
			where.append(" and email=? ");
			params.add(user.getEmail());
		}
		if(user.getPhone()!=null && user.getPhone()!="" && user.getPhone().length()>0){
			where.append(" and phone=? ");
			params.add(user.getPhone());
		}
		if(user.getStatus()!=null && user.getStatus()!="" && user.getStatus().length()>0){
			where.append(" and status=? ");
			params.add(user.getStatus());
		}
		sql=sql+where.toString();
		return jdbcTemplate.query(sql, params.toArray(), new UserMapper());
	}
}
