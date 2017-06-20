package com.better.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.better.bean.User;
import com.better.dao.UserDao;
import com.better.service.UserService;

@Controller
@SessionAttributes(value="user")			//声明在model中的属性放入到session中，
public class loginController {
	
	@Autowired
	private UserService userServiceImpl;
	
	@RequestMapping("/login")
	public String login(String username,Model model){
		User user = new User();
		user.setUsername(username);
		user = userServiceImpl.login(user);
		if(null!=user){
			model.addAttribute("user",user);
			return "WEB-INF/index.jsp";
		}else{
			model.addAttribute("error","用户名密码错误");
			return "login.jsp";
		}
	}
}
