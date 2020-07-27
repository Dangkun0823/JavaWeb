package day38;

import java.util.Scanner;

public class LongestArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int sum = 0;
            int max = 0X80000000; //int型数的最小值 -21亿.
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if(sum<=0){
                    sum=arr[i];
                }else {
                    sum+=arr[i];
                }
                if (max < sum) {
                    max = sum;
                }
            }
            System.out.println(max);
        }
    }
}
