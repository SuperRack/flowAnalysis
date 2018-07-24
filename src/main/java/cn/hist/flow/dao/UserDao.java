package cn.hist.flow.dao;

import java.util.List;

import cn.hist.flow.domain.User;

public interface UserDao {

	void add(User user)throws Exception;

	User findByNameAndPwd(User user) throws Exception;

	List<User> findAll();

	int updateStatus(String id, String status);

	User get(String id);

	int update(User user);

	List<User> findQuery(User user);
}
