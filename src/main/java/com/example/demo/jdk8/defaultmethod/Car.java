package com.example.demo.jdk8.defaultmethod;

public interface Car {
	
	public void move();
	
	public void in();
	
	default void go() {
		System.out.println("gooooooooo");
	}
}
