package day40;

import java.util.Scanner;

//输入两个字符串，从第一字符串中删除第二个字符串中所有的字符
//例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”
public class DemoA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            for (int i = 0; i < s2.length(); i++) {
                s1 = s1.replaceAll(s2.substring(i, i + 1), "");
            }
            System.out.println(s1);
        }
    }
}
