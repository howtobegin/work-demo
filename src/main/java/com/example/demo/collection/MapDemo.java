package com.example.demo.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapDemo {
	public static void main(String[] args) {
		//testFailFast(); // throw ex
		testWhileAdd();
	}
	
	public static void testFailFast() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key1", "1");
		map.put("key2", "1");
		map.put("key3", "1");
		map.put("key4", "1");
		map.put("key5", "1");
		
		Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
		map.remove(it.next().getKey());
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public static void testWhileAdd() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key1", "1");
		map.put("key2", "1");
		map.put("key3", "1");
		map.put("key4", "1");
		map.put("key5", "1");
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key);
			map.put("key6", 1);
		}
		System.out.println(map);
	}
	
	
}
