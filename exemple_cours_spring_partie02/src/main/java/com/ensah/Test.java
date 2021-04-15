package com.ensah;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.AppConf;

public class Test {
	
	public static void main(String[] args) {
		
		//On r�cup�re le context de Spring
		AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext(AppConf.class);
		
		IUserService  ser =  context.getBean("getUserService",  UserServiceImpl.class);
		
		IUserService  ser1 = (IUserService)	context.getBean("getUserService");
		
		
	
		System.out.println(" ser1 = " + ser1);
		
		ser.tester();
		
		
	
		
		context.close();
		
		
	}

}
