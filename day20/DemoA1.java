package day20;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//到底买不买问题
//使用集合框架
public class DemoA1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String have = sc.nextLine();
            String need = sc.nextLine();
            Map<Character, Integer> h = new HashMap<>();
            for (char c : have.toCharArray()) {
                if (h.containsKey(c)) {
                    h.put(c, h.get(c) + 1);
                } else {
                    h.put(c, 1);
                }
            }
            Map<Character, Integer> n = new HashMap<>();
            for (char d : need.toCharArray()) {
                if (n.containsKey(d)) {
                    n.put(d, n.get(d) + 1);
                } else {
                    n.put(d, 1);
                }
            }
            boolean x = true;
            int y = 0;
            for (Map.Entry<Character, Integer> entry : n.entrySet()) {
                char k = entry.getKey();
                int p = entry.getValue();
                if (h.containsKey(k) && h.get(k) < p) {
                    x = false;
                    y += p - h.get(k);
                } else if (!h.containsKey(k)) {
                    x = false;
                    y += p;
                }
            }
            if (x) {
                System.out.println("Yes" + " " + (have.length() - need.length()));
            } else {
                System.out.println("No" + " " + y);
            }
        }
    }
}
