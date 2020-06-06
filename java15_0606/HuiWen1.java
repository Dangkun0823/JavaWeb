package oj;

import java.util.Scanner;

// 回文判断练习
//定义两个指针,一个从前往后一个从后往前遍历,当发现字符不一样时,说明不是回文串
public class HuiWen1 {
    public static boolean isHuiWen(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            String a = sc.next();
            String b = sc.next();
            int count = 0;
            for (int i = 0; i <= a.length(); i++) {
                StringBuilder sb = new StringBuilder(a);
                sb.insert(i, b);
                if (isHuiWen(sb.toString())) {
                    count++;
                }
            }
            System.out.println(count);
    }
}
