package oj;

import java.util.Scanner;

public class Water3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            System.out.println( Water(a));
        }
    }

    public static int Water(int x) {
        int count = 0;
        while (x>2){
            count+=x/3;
            x=x/3+x%3;
        }if(x==2){
            count+=1;
        }
       return count;
    }
}
