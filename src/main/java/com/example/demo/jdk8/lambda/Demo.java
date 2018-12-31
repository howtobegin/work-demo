package com.example.demo.jdk8.lambda;

import java.util.Arrays;
import java.util.List;

public class Demo {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3);
		
		list.forEach((Integer i) ->{System.out.println(i);});
		list.forEach(i ->{System.out.println(i);});
		// 方法引用
		list.forEach(System.out::println);
		// 可以是任意类的静态方法
		list.forEach(Person::sayHello);
		
	}
}
