package day16;

import java.util.Scanner;

public class DemoA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = sc.nextInt();
            }
            int p = sc.nextInt();
            int cnt=0;
            for(int i=0;i<n;i++){
                if(num[i] == p){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
