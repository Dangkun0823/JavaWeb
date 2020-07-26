package day36;

import java.util.Scanner;

//进制转换问题
//输入一个十六进制的数值字符串  0XA
//输出该数值的十进制字符串  10
public class DemoB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            long num = 0;
            for (int i = 2; i < s.length(); i++) {
                num *= 16;
                char ch = s.charAt(i);
                int n = 0;
                if (ch >= 'A' && ch <= 'F') {
                    n = ch - 'A' + 10;
                } else if (ch >= 'a' && ch <= 'f') {
                    n = ch - 'a' + 10;
                } else {
                    n = ch - '0';
                }
                num += n;
            }
            System.out.println(num);
        }
    }
}
