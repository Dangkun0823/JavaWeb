package day45;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DemoA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Map<Character, Integer> A = new HashMap<>();
            Map<Character, Integer> B = new HashMap<>();
            String s1 = sc.next();
            String s2 = sc.next();
            for (int i = 0; i < s1.length(); i++) {
                if (A.containsKey(s1.charAt(i))) {
                    A.put(s1.charAt(i), A.get(s1.charAt(i)) + 1);
                } else {
                    A.put(s1.charAt(i), 1);
                }
            }
            for (int j = 0; j < s2.length(); j++) {
                if (B.containsKey(s2.charAt(j))) {
                    B.put(s2.charAt(j), B.get(s2.charAt(j)) + 1);
                } else {
                    B.put(s2.charAt(j), 1);
                }
            }
            int flag = 0;
            for (char c : B.keySet()) {
                if (!A.containsKey(c)) {
                    flag = 1;
                    break;
                } else {
                    if (A.get(c) < B.get(c)) {
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 1) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }
}
