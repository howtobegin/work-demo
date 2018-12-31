package com.example.demo.dp.singleton;

public class SingletonDemo {
	
}
class Singleton1 {
	private Singleton1 ins = new Singleton1();
	private Singleton1() {}
	public Singleton1 getInstance() {
		return ins;
	}
}

class Singleton2 {
	private Singleton2 ins = null;
	private Singleton2() {}
	public Singleton2 getInstance() {
		if (ins == null) {
			synchronized (ins) {
				if (ins == null) {
					ins = new Singleton2();
				}
			}
		}
		
		return ins;
	}
}
