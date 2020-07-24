package day32;

import java.util.Scanner;

// 求n的阶乘后面跟的0的个数
public class DemoC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int num = 0;
            for (int i = a; i >= 5; i--) {
                int c = i;

                // 计算是不是5的整数倍, 如果是就除以5继续循环.
                while (c % 5 == 0) {
                    num++;
                    c /= 5;
                }
            }
            System.out.println(num);
        }
    }
}
