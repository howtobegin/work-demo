package com.example.demo.java;

public class StringBufferDemo {
	public static void main(String[] args) {
		StringBuffer a = new StringBuffer("A");
		StringBuffer b = new StringBuffer("B");
		
		append(a, b);
		
		System.out.println(a + "," + b);
		
	}
	
	public static void append(StringBuffer a, StringBuffer b) {
		a.append(b);
		a=b;
	}
}
