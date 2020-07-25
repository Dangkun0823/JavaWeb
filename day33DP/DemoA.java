package day33DP;

import java.util.Scanner;

// 动态规划问题
// 给定一个有n个正整数的数组A和一个整数sum,求数组A中部分数字和为sum的方案数(每个下标在一个方案中只能选一次).
public class DemoA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();   //数组大小
            int a = sc.nextInt();   //要求的和为多少
            int[] num = new int[n];       //初始化数组
            long[] dp = new long[a + 1];  //动态规划数组
                   dp[0] = 1;       // 下标为0的初始化值设为1
            for (int i = 0; i < n; i++) {
                num[i] = sc.nextInt();
                for (int j = a; j >= 0; j--) {
                    if (j >= num[i]) {
                        dp[j] += dp[j - num[i]];
                    }
                }
            }
            System.out.println(dp[a]);
        }
    }
}
