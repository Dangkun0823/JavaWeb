package day36;

import java.util.Scanner;

public class DemoA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            char index = 'A';
            for (int i = 0; i < 26; i++) {
                int cnt = 0;
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == index) {
                        cnt++;
                    }
                }
                System.out.println(index + ":" + cnt);
                index++;
            }
        }
    }
}
