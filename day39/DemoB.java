package day39;

import java.util.Scanner;

public class DemoB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            // 判断 去掉开头 或 去掉结尾 后剩余字符串是否是回文. 或者自身是否是回文.
            if (isHuiwen(s.substring(0, s.length()-1)) || isHuiwen(s.substring(1, s.length())) || isHuiwen(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isHuiwen(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}