package com.example.demo;

import java.util.concurrent.ConcurrentHashMap;

public class Demo2 {
	private static ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();
	public static void main(String[] args) {
		Object key = map.putIfAbsent("key", "hello");
		System.out.println(key);
	}
}
