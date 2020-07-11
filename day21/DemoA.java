package day21;

import java.util.Scanner;

//统计每个月兔子的总数
//是一个斐波那契数列
//非递归,更快.
public class DemoA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int pre = 1;
            int cur = 1;
            while (n > 2) {
                int nxt = pre + cur;
                pre = cur;
                cur = nxt;
                n--;
            }
            System.out.println(cur);
        }
    }
}
