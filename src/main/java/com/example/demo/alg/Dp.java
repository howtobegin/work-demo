package com.example.demo.alg;

/**
 * 小偷
 * @author admin
 *
 */
public class Dp {
	public static void main(String[] args) {
		run();
	}
	
	/**
	 * 
	 * 价值60，100，120
	 * 重量10，20，30
	 * 
	 * 
	 * 0		10		20		30		40		50		// 物品容积
	 * 第1个物品		60		60		60		60		60
	 * 第2个物品		60		10		10		10		10
	 * 第3个物品		60		10		160		180		220
	 * 
	 * 
	 */
	public static void run() {
		int value[] = {60, 100, 120};
		int weight[] = {10, 20, 30};
		
		int w = 50; // 袋子的容积
		int n = 3;
		
		int dp[][] = new int[n + 1][w + 1];
		
		// 表示每次加第几个物品进来
		for (int i = 1; i <= n; i++) {
			// 表示袋子在cw这个容积的时候所能保存的最大价值
			for (int cw = 1; cw <= w; cw++) {
				// 表示这个物品在cw容积的时候能不能加
				if (weight[i - 1] <= cw) {
					dp[i][cw] = Math.max(value[i - 1] + dp[i - 1][cw - weight[i - 1]], 
							dp[i - 1][cw]);
				} else { 
					// 这个因为装不下，所以就是之前一个存的
					dp[i][cw] = dp[i - 1][cw];
				}
				
			}
		}
		// 算完以后只需要输出矩阵最后一个
		System.out.println(dp[n][w]);
	}
}
