package day30;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

//对N个长度最长可达到1000的数进行排升序.
//BigInteger 大整数计算.
public class DemoB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            BigInteger[] bg=new BigInteger[n];
            for(int i=0;i<n;i++){
                bg[i]=sc.nextBigInteger();
            }
            Arrays.sort(bg);    //默认按升序排.
            for(int i=0;i<n;i++){
                System.out.println(bg[i]);
            }
        }
    }
}
