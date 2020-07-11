package day21;

import java.util.Scanner;

// 字母解密
public class DemoB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            char[] c = s.toCharArray();
            for (int i = 0; i < c.length; i++) {
                if (c[i] >= 'F' && c[i] <= 'Z') {
                    c[i] = (char) (c[i] - 5);
                }else if (c[i] >= 'A' && c[i] <= 'E') {
                    c[i] = (char) (c[i] + 21);
                }
            }
            String s1 = new String(c);
            System.out.println(s1);
        }
    }
}
