package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ensah.IUserDao;
import com.ensah.IUserService;
import com.ensah.UserDaoImpl;
import com.ensah.UserServiceImpl;

@Configuration
//@ComponentScan("com.ensah")
 
@PropertySource("classpath:test.properties")
public class AppConf {

	@Bean
	public IUserDao getUserDao() {

		System.out.println("getUserDao appelée");

		return new UserDaoImpl();
	}

	@Bean
	public IUserService getUserService() {

		System.out.println("getUserService appelée");

		return new UserServiceImpl(getUserDao());
	}

}
