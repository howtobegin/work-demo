package com.example.demo.jdk8.lambda;

public class Person {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	
	public String getName() {
		return "car name";
	}

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public static void create(int id, String name, PersonCallBack callBack) {
		Person p = new Person(1, name);
		callBack.callBack(p);
	}
	
	public static void main(String[] args) {
		create(1, "t", new PersonCallBack() {
			
			@Override
			public void callBack(Person person) {
				System.out.println("go to login");
			}
		});
		create(1, "t", person -> {System.out.println("go to login");});
	}
	
	public static void sayHello(Integer i) {
		System.out.println("hello " + i);
	}
}
