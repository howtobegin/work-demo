package com.example.demo.dp.proxy;

import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		UserDaoHandler handler = new UserDaoHandler(userDao);
		
		UserDao userDaoProxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), handler);
		userDaoProxy.hello();
	}
}
