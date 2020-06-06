package oj;

import java.util.Scanner;

public class DeleteSameNode8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            for (int i = 0; i < str2.length(); i++) {
                for (int j = 0; j < str1.length(); j++) {
                    if (str1.charAt(j) == str2.charAt(i)) {
                        str1 = str1.substring(0, j) + str1.substring(j + 1, str1.length());
                        j--;
                    }
                }
            }
            System.out.println(str1);
    }
}
