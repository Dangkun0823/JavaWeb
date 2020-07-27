package day38;

import java.util.Scanner;

//找出字符串中最长 数字串.
public class LongestString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int count = 0, max = 0, index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                count++;
                if (max < count) {
                    max = count;
                    index = i;
                }
            }else {
                count=0;
            }
        }
        System.out.println(str.substring(index - max + 1, index + 1)); // 起始位置--->终止位置.
    }
}
