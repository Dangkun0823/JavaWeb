package day27;

import java.util.Scanner;

public class DemoA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i]=sc.nextInt();
            }
            int m=sc.nextInt();
            int index=0;
            for(int i=0;i<n;i++){
                if(m==num[i]){
                    System.out.print(i);
                    break;
                }
                index++;
            }
            if(index==n){
                System.out.print(-1);
            }
        }
    }
}
