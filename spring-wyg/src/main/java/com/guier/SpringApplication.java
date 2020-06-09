package com.guier;

import com.guier.pojo.Person;
import com.guier.service.UserService;
import com.guier.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {
	public static void main(String[] args) {
		// helloSpring();
		beanLifeCycle();
	}

	public static void helloSpring() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(UserServiceImpl.class);
		applicationContext.refresh();
		UserService userService = applicationContext.getBean(UserService.class);
		userService.sayHello();
	}

	public static void beanLifeCycle() {
		System.out.println("现在开始初始化容器");

		ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("容器初始化成功");
		//得到Preson，并使用
		Person person = factory.getBean("person", Person.class);
		System.out.println(person);

		System.out.println("现在开始关闭容器！");
		((ClassPathXmlApplicationContext) factory).registerShutdownHook();
	}
}
