package com.ensah;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		// On récupère le context
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// On peut récupérer le bean par son identifiant
		UserService bean1 = (UserService) context.getBean("userS");

		// On peut récupérer le bean par son identifiant et son type
		UserService bean2 = context.getBean("userS", UserServiceImpl.class);

		// On peut récupérer le bean par son identifiant et son type
		UserService bean3 = context.getBean(UserServiceImpl.class);
		

		System.out.println(" ======Test 1====== ");
		bean1.test();
		
		System.out.println(" ======Test 2====== ");
		bean2.test();
		
		System.out.println(" ======Test 3====== ");
		bean3.test();
		
		context.close();

	}
}
