package com.example.demo.java;

public class Demo {
	public static void main(String[] args) {
		int x=0,y=10;
		do {
			y--;
			++x;
		} while(x < 5);

		System.out.println(x);
		System.out.println(y);
	}
}
