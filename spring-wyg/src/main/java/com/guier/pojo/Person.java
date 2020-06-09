package com.guier.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
	private String name;
	private String address;
	private String phone;
	private BeanFactory beanFactory;
	private String beanName;

	public Person() {
		System.out.println("<构造方法> " + this.getClass().getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println(this.getClass().getName() + "<属性注入> name: " + name);
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		System.out.println(this.getClass().getName() + "<属性注入> address: " + address);
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		System.out.println(this.getClass().getName() + "<属性注入> phone: " + phone);
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", address='" + address + '\'' +
				", phone=" + phone +
				'}';
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("BeanFactoryAware接口-调用BeanFactoryAware.setBeanFactory()");
		this.beanFactory = beanFactory;
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("BeanNameAware接口-调用BeanNameAware.setBeanName() > " + name);
		this.beanName = name;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DiposibleBean接口-调用DiposibleBean.destory()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean接口-调用InitializingBean.afterPropertiesSet()");
	}

	// 通过<bean>的init-method属性指定的初始化方法
	public void myInit() {
		System.out.println("init-method-调用<bean>的init-method属性指定的初始化方法");
	}

	// 通过<bean>的destroy-method属性指定的初始化方法
	public void myDestory() {
		System.out.println("destroy-method调用<bean>的destroy-method属性指定的初始化方法");
	}
}
