package com.example.demo.alg;

import java.util.Random;

public class IntDemo {
	// 随机生成20以内的一亿个数
	public static int num = 1000 * 1000 * 100, max = 20;
	public static void main(String[] args) {
		int[] res = init(num, max);
		
		int deNum = 5;
		int count = count(res, deNum);
		
		System.out.println("数字" + deNum + "出现的次数 ：" + count);
	}
	
	/**
	 * 给定指定数，求出现次数
	 * @param res
	 * @param value
	 * @return
	 */
	public static int count(int[] res, int value) {
		int[] de = new int[max];
		for (int i : res) {
			int v = de[i];
			de[i] = v == 0 ? 1 : v + 1;
		}
		
		return de[value];
	}
	
	public static int count2(int[] res, int value) {
		return 0;
	}
	
	/**
	 * init
	 * @param len
	 * @param max
	 * @return
	 */
	public static int[] init(int len, int max) {
		int[] res = new int[len];
		for (int i = 0; i < res.length; i++) {
			res[i] = new Random().nextInt(max);
		}
		
		return res;
	}
}
