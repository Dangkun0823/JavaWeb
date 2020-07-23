package day31;

import java.util.Scanner;

//给定一句英语, 将句中所有单词的顺序颠倒输出.
public class DemoA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();  //注意是 sc.nextLine 不是sc.next.
            String[] s1 = s.split(" ");
            for (int i = s1.length - 1; i >= 0; i--) {
                if (i == 0) {
                    System.out.println(s1[i]);
                } else {
                    System.out.print(s1[i] + " ");
                }
            }
        }
    }
}
