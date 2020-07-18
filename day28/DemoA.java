package day28;

import java.util.Scanner;

//判断守形数
public class DemoA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            isShouXingShu(a);
        }
    }

    private static void isShouXingShu(int a) {
        int b = a * a;
        String s1 = String.valueOf(a);
        String s2 = String.valueOf(b);
        String s = s2.substring(s2.length() - s1.length(), s2.length());
        if (s.equals(s1)) {
            System.out.println("Yes!");
        } else {
            System.out.println("No!");
        }
    }
}
