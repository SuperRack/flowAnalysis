package cn.hist.flow.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hist.flow.domain.User;
import cn.hist.flow.exception.UserException;
import cn.hist.flow.service.UserService;
import cn.hist.flow.util.MD5;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//用户登录
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user,HttpSession session,HttpServletResponse response){
		try {
			User us=userService.login(user);
			session.setAttribute("LOGIN_USER",us);
			return "base/main";
		} catch (UserException e) {
			e.printStackTrace();
			session.setAttribute("LOGIN_ERROR", e.getMessage());
			//否则，则返回登录页面
			try {
				response.sendRedirect("/");
			} catch (IOException e1) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}
	
	/**
	 * 查询所有的学生信息
	 */
	@RequestMapping(value="/findAll",method=RequestMethod.GET)
	public String findAll(Map<String,Object> data){
		List<User> users=userService.findAll();
		data.put("userList", users);
		return "user/userList";
	}
	
	/**
	 * 修改用户状态
	 */
	@RequestMapping(value="/updateStatus",method=RequestMethod.POST)
	@ResponseBody
	public String updateStatus(String id,String status){
		String flag="OK";
		try {
			userService.updateStatus(id,status);
		} catch (Exception e) {
			flag="ERROR";
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return flag;
	}
	
	@RequestMapping(value="/editUser/{id}",method=RequestMethod.GET)
	public String editUser(@PathVariable("id")String id,Map<String,Object> data){
		User user=userService.get(id);
		data.put("user",user);
		return "user/update";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(User user,Map<String,Object> data){
		User oldNews = userService.get(user.getId());
		user.setStatus(oldNews.getStatus());
		if(user.getPwd()!=null && user.getPwd()!="" && user.getPwd().length()>0){
			MD5 md5 = new MD5();
			md5.getMD5ofStr(user.getPwd());
			user.setPwd(md5.digestHexStr);
		}else{
			user.setPwd(oldNews.getPwd());
		}
		userService.update(user);
		data.put("user", user);
		data.put("updateStatus","ok");
		return "user/update";
	}
	
	/**
	 * 多条件用户查询
	 */
	@RequestMapping(value="/findQuery",method=RequestMethod.POST)
	public String findQuery(User user,Map<String,Object> data){
		List<User> list=userService.findQuery(user);
		data.put("userList", list);
		return "user/userList";
	}
	
	/**
	 * 用户退出
	 */
	@RequestMapping(value="/exit",method=RequestMethod.GET)
	public void exit(HttpServletResponse response,HttpServletRequest request,HttpSession session){
		session.removeAttribute("LOGIN_USER");
		try {
			String path="http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
			response.sendRedirect(path);
			return ;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}