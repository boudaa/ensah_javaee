package com.ensah;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;
	
	@Value("${com.ensah.dbname}")
	private String dbName;
	

	public UserServiceImpl(IUserDao pDao) {
		System.out.println("UserServiceImpl est bien crée");
		
		dao = pDao;
	}

	
	@PostConstruct
	public void initBean() {
		System.out.println("initBean  est la");
	}
	
	@PreDestroy
	public void end() {
		System.out.println("end est la ");
	}
	
	
	
	public void tester() {

		System.out.println("dbName= " +dbName);
		
		System.out.println("Le Dao est bien la = " + dao);

	}

}
