package com.better.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.better.bean.User;
import com.better.dao.UserDao;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User login(User user) {
		System.out.println("111111111111");
		return userDao.login(user);
	}

}
