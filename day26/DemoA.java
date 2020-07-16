package day26;

import java.util.Scanner;

//对于给定的正整数 n，计算其十进制形式下所有位置数字之和，并计算其平方的各位数字之和.
public class DemoA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = n * n;
            int sum1 = 0;
            while (n > 0) {
                sum1 += n % 10;
                n /= 10;
            }
            System.out.print(sum1 + " ");
            int sum2 = 0;
            while (m > 0) {
                sum2 += m % 10;
                m /= 10;
            }
            System.out.print(sum2);
        }
    }
}
