package com.example.demo.alg;

/**
 * 两个超大整数和
 * @author admin
 *
 */
public class TwoBigNumber {
	public static void main(String[] args) {
		String s1 = "63242342423513";
		String s2 = "63242342423513";
		add(s1, s2);
	}
	
	public static int[] add(String s1, String s2) {
		int maxLen = s1.length() > s2.length() ? s1.length() : s2.length();
		int minLen = s1.length() > s2.length() ? s2.length() : s1.length();
		int[] result = new int[maxLen + 1];
		for (int i = minLen, j = maxLen; i > 0; i--, j --) {
			int sum = result[i];
			int num1 = toNum(s1.charAt(j - 1));
			int num2 = toNum(s2.charAt(i - 1));
			sum = sum + num1 + num2;
			if (sum > 9) {
				result[j - 1] = 1;
				sum = sum % 10;
			}
			result[j] = sum;
		}
		if (maxLen > minLen) {
			for (int i = maxLen - minLen - 1; i >= 0; i --)
			result[i + 1] += toNum(s1.charAt(i));
		}
		
		for(int i = 0; i < result.length; i ++) {
			if (i == 0 && result[i] == 0) continue;
			System.out.print(result[i]);
		}
		
		return result;
	}
	
	public static int toNum(char c) {
		return Integer.valueOf(String.valueOf(c));
	}
	
	public static int toNum(String s) {
		return Integer.valueOf(s);
	}
}
