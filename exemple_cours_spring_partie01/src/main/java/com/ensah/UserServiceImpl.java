package com.ensah;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userS")
public class UserServiceImpl implements UserService{

	
	@Autowired
	private RoleDao roleDao ;
	
	@Autowired
	private UserDao userDao;

	public UserServiceImpl() {
		
		System.out.println(" UserServiceImpl est bien cr�e ");
	
	}
	
	public void test() {
		System.out.println("roleDao="+roleDao);
		System.out.println("userDao="+userDao);
	}
	
	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	
	
	
}
