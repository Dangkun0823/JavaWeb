package oj;

import java.util.Scanner;

public class BuyApple7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=a%8==0?a/8:a/8+1;
        int i=0;
        for(;i<20;i++){
            for(int j=0;j<20;j++){
                if(6*i+8*j==a){
                    System.out.println(b);
                    return;
                }
            }
        }
        if(i==20){
            System.out.println(-1);
        }
    }
}
