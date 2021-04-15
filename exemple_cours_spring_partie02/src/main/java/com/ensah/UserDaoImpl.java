package com.ensah;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements IUserDao {

	public UserDaoImpl() {
		System.out.println("UserDaoImpl");
	}

}
