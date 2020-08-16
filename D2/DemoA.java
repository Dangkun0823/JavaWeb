package D2;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//23
public class DemoA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            Map<Integer, Integer> map = new TreeMap<>();
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            int[] arr = new int[s1.length];
            for (int i = 0; i < arr.length; i++) {
                int a = Integer.valueOf(s1[i]);
                if (map.containsKey(a)) {
                    map.put(a, map.get(a) + 1);
                } else {
                    map.put(a, 1);
                }
                if (map.get(a) >= s1.length / 2) {
                    System.out.println(a);
                }
            }
        }
    }
}
