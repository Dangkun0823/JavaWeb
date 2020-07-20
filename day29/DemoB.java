package day29;

import java.util.Scanner;

//求无人获奖的概率. 以 "xx.xx%" 的格式输出.
//错排(错位排序)算法.
public class DemoB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            float sum1 = factorial(n);
            float sum2 = count(n);       // 无人获奖概率: count(n)/factorial(n).
            float result1 = (sum2 / sum1) * 100;
            System.out.println(String.format("%.2f",result1) + "%");
        }
    }

    //错排算法.
    public static float count(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return (n - 1) * (count(n - 1) + count(n - 2));
        }
    }

    //n的阶乘
    public static float factorial(int num) {
        float result = 1;
        if (num == 0) {
            return 1;
        } else if (num > 0) {
            result = num * factorial(num - 1);
        }
        return result;
    }
}
