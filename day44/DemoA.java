package day44;

import java.util.Scanner;

// 骆驼命名法
// 输入“hello_world”,输出helloWorld
public class DemoA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] s1 = s.split("_");
            String result = s1[0];
            for (int i = 1; i < s1.length; i++) {
                    result += (char) (s1[i].charAt(0) - 32);
                 for(int j=1;j<s1[i].length();j++){
                     result+=s1[i].charAt(j);
                 }
            }
            System.out.println(result);
        }
    }
}
