package com.example.demo.dp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserDaoHandler implements InvocationHandler {
	
	private Object proxy;
	
	public UserDaoHandler(Object proxy) {
		this.proxy = proxy;
	}

	@Override
	public Object invoke(Object o, Method method, Object[] arg2) throws Throwable {
		System.out.println(1);
		method.invoke(proxy, arg2);
		System.out.println(2);
		return null;
	}

}
