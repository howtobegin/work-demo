package com.example.demo.juc.thread;

public class ThreadLocalDemo {
	private static ThreadLocal<String> tl = new ThreadLocal<String>();
	
	public static void main(String[] args) {
		new Thread(()->{
			tl.set("a1");
		}, "one").start();
		new Thread(()->{
			tl.set("a2");
		}, "two").start();
		
		System.out.println(tl.get());

		setValue("a3");
		System.out.println(getValue());//拿不到a3
	}
	
	public static void setValue(String value) {
		ThreadLocal<String> tl = new ThreadLocal<String>();
		tl.set(value);
	}
	
	public static String getValue() {
		ThreadLocal<String> tl = new ThreadLocal<String>();
		return tl.get();
	}

}
