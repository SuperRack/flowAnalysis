package cn.hist.flow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hist.flow.dao.UserDao;
import cn.hist.flow.domain.User;
import cn.hist.flow.exception.UserException;
import cn.hist.flow.service.UserService;
import cn.hist.flow.util.MD5;

@Service
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Transactional(readOnly=false)
	public void add(User user)throws Exception {
		//对密码进行md5加密
		MD5 md5 = new MD5();
		md5.getMD5ofStr(user.getPwd());
		user.setPwd(md5.digestHexStr);
		userDao.add(user);
	}
	
	public User login(User user) throws UserException {
		//对密码进行md5加密
		MD5 md5 = new MD5();
		md5.getMD5ofStr(user.getPwd());
		user.setPwd(md5.digestHexStr);
		User us;
		try {
			us = userDao.findByNameAndPwd(user);
			return us;
		} catch (Exception e) {
			throw new UserException("用户名或密码错误!");
		}
	}
	
	public List<User> findAll() {
		return userDao.findAll();
	}
	
	@Transactional(readOnly=false)
	public int updateStatus(String id, String status) {
		return userDao.updateStatus(id,status);
	}
	
	public User get(String id) {
		return userDao.get(id);
	}
	
	@Transactional(readOnly=false)
	public int update(User user) {
		return userDao.update(user);
	}
	
	public List<User> findQuery(User user) {
		return userDao.findQuery(user);
	}
}
