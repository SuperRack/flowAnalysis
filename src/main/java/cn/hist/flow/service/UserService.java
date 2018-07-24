package cn.hist.flow.service;

import java.util.List;

import cn.hist.flow.domain.User;
import cn.hist.flow.exception.UserException;

public interface  UserService {
	
	void add(User user)throws Exception;

	User login(User user) throws UserException;

	List<User> findAll();

	int updateStatus(String id, String status);

	User get(String id);

	int update(User user);

	List<User> findQuery(User user);
}
