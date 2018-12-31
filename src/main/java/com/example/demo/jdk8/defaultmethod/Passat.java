package com.example.demo.jdk8.defaultmethod;

public class Passat implements Car {

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public void in() {
		// TODO Auto-generated method stub

	}

	@Override
	public void go() {
		System.out.println("passat gooooooooooo");
	}

	public static void main(String[] args) {
		Passat p = new Passat();
		p.go();
	}
	
}
