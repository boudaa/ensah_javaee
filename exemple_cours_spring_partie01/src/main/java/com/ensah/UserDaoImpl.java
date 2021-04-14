package com.ensah;

import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {

	public UserDaoImpl() {

		System.out.println("UserDaoImpl est bien crée ");

	}

}
