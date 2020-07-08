package day14;

import java.util.Scanner;

// 输入数据是由 10 个数字组成，表示 0 - 9 出现的次数，组成最小数
public class DemoA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[] num = new int[10];
            for (int i = 0; i < 10; i++) {
                num[i] = sc.nextInt();
            }
            for (int i = 1; i < 10; i++) {
                if (num[i] != 0) {
                    System.out.print(i);
                    num[i]--;
                    break;
                }
            }
            while (num[0]!=0){
                System.out.print(0);
                num[0]--;
            }
            for(int i=1;i<10;i++){
                while (num[i]!=0){
                    System.out.print(i);
                    num[i]--;
                }
            }
        }
    }
}
