package day14;

import java.util.Scanner;

// 任何一个整数m的立方都可以写成m个连续奇数之和
public class DemoB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int a = n * n - n + 1;    // 核心: 确定首个奇数
            System.out.print(a);
            for (int i = 1; i < n; i++) {
                System.out.print("+" + (a += 2));
            }
            System.out.println();
        }
    }
}
