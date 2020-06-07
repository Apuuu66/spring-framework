package com.guier;

import com.guier.service.UserService;
import com.guier.service.impl.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(UserServiceImpl.class);
		applicationContext.refresh();
		UserService userService = applicationContext.getBean(UserService.class);
		userService.sayHello();
	}
}
