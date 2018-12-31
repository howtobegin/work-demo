package com.example.demo.alg;

/**
 * 贪心算法
 * 面值100, 50, 20, 10, 5, 2, 1，给定数字，输出最小张数
 * @author admin
 *
 */
public class TanXin {
	public static void main(String[] args) {
		run(232);
	}
	public static void run(int money) {
		run(money, 0);
	}
	
	public static void run(int money, int index) {
		int[] baseMoney = {100, 50, 20, 10, 5, 2, 1};
		if (index > baseMoney.length - 1) {
			return;
		}
		int nums = money / baseMoney[index];
		System.out.println(baseMoney[index] + " - " + nums);
		int mod = money % baseMoney[index];
		if (mod > 0) {
			index++;
			run(mod, index);
		}
	}
}
