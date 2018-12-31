package com.example.demo.alg;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
	public static void main(String[] args) {
		//Map<String, Object> map = new LinkedHashMap<String, Object>(); // 按插入顺序输出
		Map<String, Object> map = new HashMap<String, Object>();// 按key的位置输出
		map.put("a1", 1);
		map.put("a3", 1);
		map.put("a4", 1);
		map.put("a2", 1);

		for (String key : map.keySet()) {
			System.out.println(key);
			System.out.println(map.get(key));
		}
	}
}
